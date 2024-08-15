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
        player.sendMessage("-------Discs------");
        if (CustomDiscPlugin.getInstance().discList.isEmpty()) {
            player.sendMessage("当前没有已创建的唱片");
        } else {
            for (Iterator<String> it = CustomDiscPlugin.getInstance().discList.keys().asIterator(); it.hasNext(); ) {
                String key = it.next();
                MusicDisc value = CustomDiscPlugin.getInstance().discList.get(key);
                player.sendMessage("唱片名称: " + key + ", 命名空间: " + value.getSound());
            }
        }
        player.sendMessage("---------------------");
    }


}