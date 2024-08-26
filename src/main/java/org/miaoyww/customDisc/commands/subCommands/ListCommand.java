package org.miaoyww.customDisc.commands.subCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.miaoyww.customDisc.CustomDiscPlugin;
import org.miaoyww.customDisc.MusicDisc;
import org.miaoyww.customDisc.interfaces.ISubCommand;
import org.miaoyww.customDisc.utils.Messages;

import java.util.Iterator;
import java.util.List;

public class ListCommand extends ISubCommand {
    @Override
    public String getName() {
        return "list";
    }

    @Override
    public String getDescription() {
        return "列出所有唱片";
    }

    @Override
    public String getSyntax() {
        return "";
    }

    @Override
    public void perform(Player player, String[] args) {
        Messages.sendMessageToPlayer(player,"§7--- §eCustomDisc List§7---");
        if (CustomDiscPlugin.getInstance().discList.isEmpty()) {
            Messages.sendMessageToPlayer(player,"§e当前没有已创建的唱片");
        } else {
            for (Iterator<String> it = CustomDiscPlugin.getInstance().discList.keys().asIterator(); it.hasNext(); ) {
                String key = it.next();
                MusicDisc value = CustomDiscPlugin.getInstance().discList.get(key);
                Messages.sendMessageToPlayer(player,"名称: " + key + " 路径: " + value.getSound());
            }
        }
    }


}