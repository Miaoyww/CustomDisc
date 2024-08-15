package org.miaoyww.customDisc;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.miaoyww.customDisc.enums.MusicDiscType;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class MusicDisc extends ItemStack {
    private Material material;
    private String sound;
    private String displayName;
    private ItemStack item;

    public MusicDisc(
            String name,
            String sound,
            Material material) {
        this.material = material;
        this.sound = sound;
        this.item = new ItemStack(material, 1);
        item.setLore(List.of(name));
        this.displayName = name;
    }

    public MusicDisc(
            String displayName,
            String name,
            String sound,
            Material material) {
        this.material = material;
        this.sound = sound;
        this.item = new ItemStack(material, 1);
        this.displayName = displayName;
        item.setLore(List.of(name));
        item.getItemMeta().setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));

    }

    public MusicDisc(MusicDiscType type) {
        this.setMusicDiscType(type);
        this.setItemStack(new ItemStack(type.getMaterial(), 1));
    }

    public void setItemStack(ItemStack item) {
        this.item = item;
    }

    public ItemStack getItemStack() {
        return this.item;
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

    public static MusicDisc readFromFile(FileReader file) {
        Yaml yaml = new Yaml();

        return yaml.loadAs(file, MusicDisc.class);
    }

    public static MusicDisc readFromFile(String filePath) {
        Yaml yaml = new Yaml();
        try {
            return yaml.loadAs(new FileReader(filePath), MusicDisc.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return "Material: " + material + " SoundName: " + sound;
    }
}
