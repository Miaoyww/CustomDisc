package org.miaoyww.customDisc.commands;
import org.miaoyww.customDisc.commands.subCommands.*;
import org.miaoyww.customDisc.interfaces.ICommandManager;
import org.bukkit.entity.Player;


public class CommandManager extends ICommandManager {
    public CommandManager() {
        this.SubCommands.add(new HelpCommand());
        this.SubCommands.add(new AddCommand());
        this.SubCommands.add(new ListCommand());
        this.SubCommands.add(new PlayCommand());
        this.SubCommands.add(new MenuCommand());
    }

    @Override
    public String getName() {
        return "main";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String getSyntax() {
        return "";
    }

    @Override
    public void perform(Player player, String[] args) {
        
    }
}
