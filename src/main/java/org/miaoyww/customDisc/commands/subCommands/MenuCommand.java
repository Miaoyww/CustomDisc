package org.miaoyww.customDisc.commands.subCommands;

import org.bukkit.entity.Player;
import org.miaoyww.customDisc.CustomDiscPlugin;
import org.miaoyww.customDisc.gui.DiscGui;
import org.miaoyww.customDisc.interfaces.ISubCommand;
import org.miaoyww.customDisc.utils.PlayerData;

public class MenuCommand extends ISubCommand {
    @Override
    public String getName() {
        return "menu";
    }

    @Override
    public String getDescription() {
        return "打开菜单";
    }

    @Override
    public String getSyntax() {
        return "<None>";
    }

    @Override
    public void perform(Player player, String[] args) {
        player.openInventory(CustomDiscPlugin.Gui.GetDiscGui());
    }

}
