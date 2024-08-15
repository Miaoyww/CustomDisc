package org.miaoyww.customDisc.commands.subCommands;

import org.bukkit.entity.Player;
import org.miaoyww.customDisc.interfaces.ISubCommand;

public class HelpCommand extends ISubCommand {
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "帮助";
    }

    @Override
    public String getSyntax() {
        return "";
    }

    @Override
    public void perform(Player player, String[] args) {
        player.sendMessage("你触发了help指令");
    }
}
