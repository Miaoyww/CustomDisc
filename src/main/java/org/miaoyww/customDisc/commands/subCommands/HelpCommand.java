package org.miaoyww.customDisc.commands.subCommands;

import org.bukkit.entity.Player;
import org.miaoyww.customDisc.interfaces.ISubCommand;
import org.miaoyww.customDisc.utils.Messages;

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
        Messages.sendHelpMessage(player);
    }
}
