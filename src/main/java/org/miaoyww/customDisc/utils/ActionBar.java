package org.miaoyww.customDisc.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;

public class ActionBar {

    public static void sendActionBar(Player player, String message, int fadeInTime, int showTime, int fadeOutTime) {
//        try {
//            Object handle = player.getClass().getMethod("getHandle").invoke(player);
//            Object playerConnection = handle.getClass().getField("playerConnection").get(handle);
//            Object chatTitle = Class.forName("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + "." + "IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke((Object)null, "{\"text\": \"" + message + "\"}");
//            Constructor<?> titleConstructor = Class.forName("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + "." + "PacketPlayOutTitle").getConstructor(Class.forName("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + "." + "PacketPlayOutTitle").getDeclaredClasses()[0], Class.forName("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + "." + "IChatBaseComponent"), Integer.TYPE, Integer.TYPE, Integer.TYPE);
//            Object packet = titleConstructor.newInstance(Class.forName("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + "." + "PacketPlayOutTitle").getDeclaredClasses()[0].getField("ACTIONBAR").get((Object)null), chatTitle, fadeInTime, showTime, fadeOutTime);
//            Object chatsTitle = Class.forName("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + "." + "IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke((Object)null, "{\"text\": \"\"}");
//            Constructor<?> timingTitleConstructor = Class.forName("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + "." + "PacketPlayOutTitle").getConstructor(Class.forName("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + "." + "PacketPlayOutTitle").getDeclaredClasses()[0], Class.forName("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + "." + "IChatBaseComponent"), Integer.TYPE, Integer.TYPE, Integer.TYPE);
//            Object timingPacket = timingTitleConstructor.newInstance(Class.forName("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + "." + "PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get((Object)null), chatsTitle, fadeInTime, showTime, fadeOutTime);
//
//            try {
//                playerConnection.getClass().getMethod("sendPacket", Class.forName("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + "." + "Packet")).invoke(playerConnection, packet);
//                playerConnection.getClass().getMethod("sendPacket", Class.forName("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + "." + "Packet")).invoke(playerConnection, timingPacket);
//            } catch (ClassNotFoundException var14) {
//                var14.printStackTrace();
//            }
//        } catch (Exception var15) {
//            var15.printStackTrace();
//        }

    }
}
