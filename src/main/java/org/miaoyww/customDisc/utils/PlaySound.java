package org.miaoyww.customDisc.utils;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.miaoyww.customDisc.enums.MusicDiscType;

public class PlaySound {
    public static void playSound(Player player, String sound) {
        player.getWorld().playSound(player.getLocation(), sound, 1, 1);
    }
    
    public static void playSound(Player player, MusicDiscType type) {
        player.getWorld().playSound(player.getLocation(), type.getSound(), 1, 1);
    } 
    public static void playSound(Player player, Sound sound) {
        player.getWorld().playSound(player.getLocation(), sound, 1, 1);
    }
}
