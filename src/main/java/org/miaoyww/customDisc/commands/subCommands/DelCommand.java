package org.miaoyww.customDisc.commands.subCommands;

import org.bukkit.entity.Player;
import org.miaoyww.customDisc.CustomDiscPlugin;
import org.miaoyww.customDisc.interfaces.ISubCommand;
import org.miaoyww.customDisc.utils.Files;
import org.miaoyww.customDisc.utils.Messages;

public class DelCommand extends ISubCommand {
    @Override
    public String getName() {
        return "del";
    }

    @Override
    public String getDescription() {
        return "删除唱片";
    }

    @Override
    public String getSyntax() {
        return "";
    }

    @Override
    public void perform(Player player, String[] args) {
        if (args.length != 1) {
            Messages.sendMessageToPlayer(player, "参数错误, 正确用法 /disc del <name>");
            return;
        }
        String discName = args[0];
        if(!CustomDiscPlugin.getInstance().hasDisc(discName)){
            Messages.sendMessageToPlayer(player, "未找到唱片");
            return;
        }
        CustomDiscPlugin.getInstance().discList.remove(discName);
        Messages.sendMessageToPlayer(player, "已删除唱片: " + discName);
        Files.saveDiscConfig();
    }


}
