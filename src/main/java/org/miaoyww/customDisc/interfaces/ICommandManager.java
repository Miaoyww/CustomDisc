package org.miaoyww.customDisc.interfaces;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public abstract class ICommandManager extends ISubCommand implements TabExecutor {
    public ArrayList<ISubCommand> SubCommands = new ArrayList<>();
    public ArrayList<String> Suggestions = new ArrayList<>();

    public ISubCommand getCommand(String name) {
        for (ISubCommand command : this.SubCommands) {
            if (command.getName().equalsIgnoreCase(name)) {
                return command;
            }
        }
        return null;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) {
            ArrayList<String> suggestions = new ArrayList<>();
            for (ISubCommand ISubCommand : SubCommands) {
                suggestions.add(ISubCommand.getName());
            }
            for (String suggestion : Suggestions) {
                if (suggestion.startsWith(args[0])) {
                    suggestions.add(suggestion);
                }
            }
            return suggestions;
        }
        return new ArrayList<>();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (commandSender instanceof Player) {
            if (args.length == 0) {
                getCommand("help").perform((Player) commandSender, args);
                return true;
            } else {
                if (getCommand(args[0]) == null) {
                    commandSender.sendMessage("Invalid subcommand");
                    return true;
                }
                if (args[0].isEmpty()) {
                    commandSender.sendMessage("Invalid subcommand");
                    return true;
                }
                // 将args减少一个以便递归
                String[] newArgs = new String[args.length - 1];
                System.arraycopy(args, 1, newArgs, 0, args.length - 1);
                if (getCommand(args[0]) instanceof ICommandManager) {
                    ((ICommandManager) getCommand(args[0])).onCommand(
                            commandSender,
                            command,
                            label,
                            newArgs);
                    return true;
                }

                getCommand(args[0]).perform((Player) commandSender, newArgs);
                return true;
            }
        }
        return true;
    }

}
