package org.miaoyww.customDisc.utils;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class CheckUtils {
    public static boolean isCustomDisc(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        if(meta == null) return false;
        NamespacedKey key = new NamespacedKey("custom_disc", "tags");
        if (meta.getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            String value = meta.getPersistentDataContainer().get(key, PersistentDataType.STRING);
            return value != null && value.equals("is_disc");
        }
        return false;
    }
    public static Material getMaterial(String material) {
        switch (material) {
            case "cat":
                return Material.MUSIC_DISC_CAT;
            case "blocks":
                return Material.MUSIC_DISC_BLOCKS;
            case "chirp":
                return Material.MUSIC_DISC_CHIRP;
            case "far":
                return Material.MUSIC_DISC_FAR;
            case "mall":
                return Material.MUSIC_DISC_MALL;
            case "mellohi":
                return Material.MUSIC_DISC_MELLOHI;
            case "stal":
                return Material.MUSIC_DISC_STAL;
            case "strad":
                return Material.MUSIC_DISC_STRAD;
            case "ward":
                return Material.MUSIC_DISC_WARD;
            case "11":
                return Material.MUSIC_DISC_11;
            case "wait":
                return Material.MUSIC_DISC_WAIT;
            case "otherside":
                return Material.MUSIC_DISC_OTHERSIDE;
            case "relic":
                return Material.MUSIC_DISC_RELIC;
            case "5":
                return Material.MUSIC_DISC_5;
            case "pigstep":
                return Material.MUSIC_DISC_PIGSTEP;
            default:
                return Material.MUSIC_DISC_CAT;
        }
    }   
    public static String getString(final Material material) {
        switch (material) {
            case MUSIC_DISC_CAT:
                return "cat";
            case MUSIC_DISC_BLOCKS:
                return "blocks";
            case MUSIC_DISC_CHIRP:
                return "chirp";
            case MUSIC_DISC_FAR:
                return "far";
            case MUSIC_DISC_MALL:
                return "mall";
            case MUSIC_DISC_MELLOHI:
                return "mellohi";
            case MUSIC_DISC_STAL:
                return "stal";
            case MUSIC_DISC_STRAD:
                return "strad";
            case MUSIC_DISC_WARD:
                return "ward";
            case MUSIC_DISC_11:
                return "11";
            case MUSIC_DISC_WAIT:
                return "wait";
            case MUSIC_DISC_OTHERSIDE:
                return "otherside";
            case MUSIC_DISC_RELIC:
                return "relic";
            case MUSIC_DISC_5:
                return "5";
            case MUSIC_DISC_PIGSTEP:
                return "pigstep";
            default:
                return "cat";
        }
    }
}
