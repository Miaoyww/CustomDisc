package org.miaoyww.customDisc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.miaoyww.customDisc.enums.MusicDiscType;
import org.miaoyww.customDisc.utils.CheckUtils;
import org.miaoyww.customDisc.utils.Messages;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class MusicDisc {
    private Material material;
    private String sound;
    private String displayName;
    private ItemStack item;
    private String name;

    public MusicDisc(String name, ItemStack item) {
        this.name = name;
        this.item = item;
        ItemMeta meta = item.getItemMeta();
        this.displayName = meta.getDisplayName();
        this.material = item.getType();
        this.sound = meta.getPersistentDataContainer().get(new NamespacedKey("custom_disc", "record"), PersistentDataType.STRING);
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public ItemStack getItem() {
        return this.item;
    }

    public String getName() {
        return this.name;
    }

    public void setMusicDiscType(MusicDiscType type) {
        this.material = type.getMaterial();
        this.sound = type.toString();
    }

    public String getSound() {
        return this.sound;
    }

    public String getDisplayName() {

        return this.displayName;
    }

    public static MusicDisc getDiscItemStack(String name,
                                             String disPlayName,
                                             List<String> lore,
                                             String sound,
                                             Material material) {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(disPlayName);
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.SWIFT_SNEAK, 1, true);
        NamespacedKey key = new NamespacedKey("custom_disc", "tags");
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "is_disc");
        NamespacedKey key2 = new NamespacedKey("custom_disc", "record");
        meta.getPersistentDataContainer().set(key2, PersistentDataType.STRING, sound);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return new MusicDisc(name, item);

    }

    public static MusicDisc readFromFile(FileReader file) {
        Yaml yaml = new Yaml();

        return yaml.loadAs(file, MusicDisc.class);
    }

    public static List<MusicDisc> readFromFile(String filePath) {
        File discFile = new File(filePath);
        FileConfiguration config = YamlConfiguration.loadConfiguration(discFile);
        List<MusicDisc> musicDiscs = new ArrayList<>();
        try {
            for (String key : config.getConfigurationSection("discs").getKeys(false)) {
                String displayName = ChatColor.translateAlternateColorCodes('&', config.getString("discs." + key + ".name"));
                Messages.sendConsole("加载唱片 " + key + ": " + displayName);
                List<String> loreList = new ArrayList<>();
                for (String lore : config.getStringList("discs." + key + ".lore")) {
                    loreList.add(ChatColor.translateAlternateColorCodes('&', lore));
                }
                String record = config.getString("discs." + key + ".record");
                Material material = CheckUtils.getMaterial(config.getString("discs." + key + ".material"));
                Bukkit.getLogger().log(Level.INFO, key);
                musicDiscs.add(getDiscItemStack(key, displayName, loreList, record, material));
            }
            return musicDiscs;
        } catch (NullPointerException e) {
            Bukkit.getLogger().log(Level.SEVERE, "无法找到" + filePath + "下的键", e);
        } catch (Exception e) {
            Bukkit.getLogger().log(Level.SEVERE, "意外的错误", e);
        }
        return null;
    }

    public String toString() {
        return "Material: " + material + " SoundName: " + sound;
    }
}
