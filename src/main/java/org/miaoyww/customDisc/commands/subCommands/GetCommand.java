package org.miaoyww.customDisc.commands.subCommands;

import org.bukkit.entity.Player;
import org.miaoyww.customDisc.CustomDiscPlugin;
import org.miaoyww.customDisc.MusicDisc;
import org.miaoyww.customDisc.interfaces.ISubCommand;

public class GetCommand extends ISubCommand {
    @Override
    public String getName() {
        return "get";
    }

    @Override
    public String getDescription() {
        return "获取已添加的唱片";
    }

    @Override
    public String getSyntax() {
        return "<None>";
    }

    @Override
    public void perform(Player player, String[] args) {
        if (args.length != 1) {
            player.sendMessage("参数错误");
            return;
        }
        String discName = args[0];
        MusicDisc disc = CustomDiscPlugin.getInstance().discList.get(discName);
        if (disc!=null) {
            player.getInventory().addItem(disc.getItem());
        } else {
            player.sendMessage("未找到唱片");
        }
    }

}
