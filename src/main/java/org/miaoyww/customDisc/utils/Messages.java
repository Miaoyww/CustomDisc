package org.miaoyww.customDisc.utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class Messages {
    public static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    /**
     * Get plugin prefix
     *
     * @return prefix
     */
    private static String getPrefix() {
        return "&a[CustomDisc] &f";
    }

    /**
     * Send a message to a player
     *
     * @param player
     * @param message
     */
    public static void sendMessageToPlayer(Player player, String message) {
        player.sendMessage(colorize(getPrefix() + message));
    }

    /**
     * Send a message to the console
     *
     * @param message
     */
    public static void sendConsole(String message) {
        Bukkit.getConsoleSender().sendMessage(colorize(getPrefix() + message));
    }

    /**
     * Send a message to anyone
     *
     * @param sender
     * @param message
     */
    public static void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(colorize(getPrefix() + message));
    }

    public static void sendHelpMessage(CommandSender sender) {
        Messages.sendMessage(sender, "§7--- §eCustomDisc Help §7---");
        Messages.sendMessage(sender, "§e/disc help - §7打开帮助菜单");
        Messages.sendMessage(sender, "§e/disc list - §7列出所有唱片");
        Messages.sendMessage(sender, "§e/disc Add <name> <displayName> <lore> <record> [material] - §7创建一个新唱片");
        Messages.sendMessage(sender, "§e/disc del <name> - §7删除已存在的唱片");
        Messages.sendMessage(sender, "§e/disc get <name> - §7获取已存在的唱片");
    }
}
