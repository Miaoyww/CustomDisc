package org.miaoyww.customDisc;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.miaoyww.customDisc.commands.CommandManager;
import org.miaoyww.customDisc.enums.MusicDiscType;
import org.miaoyww.customDisc.gui.DiscGui;
import org.miaoyww.customDisc.utils.Files;

import java.util.*;

public final class CustomDiscPlugin extends JavaPlugin {
    private static Plugin plugin;
    private static CustomDiscPlugin instance;
    public Dictionary<String, MusicDisc> discList = new Hashtable<>();
    public static final int DiscTypes = MusicDiscType.values().length;
    public static DiscGui Gui = new DiscGui();
    
    @Override
    public void onEnable() {
        plugin = this;
        instance = this;
        loadConfig();
        getCommand("disc").setExecutor(new CommandManager());

        getServer().getPluginManager().registerEvents(Gui, this);
    }

    @Override
    public void onDisable() {

    }

    public void loadConfig() {
        Files.createDataFolders();
        Files.deserializeAllConfig();
        getConfig().options().copyDefaults(true);
    }

    public static Plugin getPlugin() {
        return plugin;
    }
    public static CustomDiscPlugin getInstance() {
        return instance;
    }

    public boolean registerDisc(String name, String path) {
        if (hasDisc(name)) {
            return false;
        }
        Material material = Material.MUSIC_DISC_13;
        ItemMeta meta = plugin.getServer().getItemFactory().getItemMeta(material);
        meta.setLore(List.of(name));
        MusicDisc disc = new MusicDisc(name, path ,material);
        
        discList.put(name, disc);
        return true;
    }    
    
    public boolean registerDisc(String name, String path, Material material) {
        if (hasDisc(name)) {
            return false;
        }
        ItemMeta meta = plugin.getServer().getItemFactory().getItemMeta(material);
        meta.setLore(List.of(name));
        MusicDisc disc = new MusicDisc(name, path ,material);
        discList.put(name, disc);
        return true;
    }

    public boolean hasDisc(String name) {
        for (Iterator<String> it = discList.keys().asIterator(); it.hasNext(); ) {
            String key = it.next();
            if (key.equals(name)) {
                return true;
            }
        }
        return false;
    }
    
    public String getDiscSound(String name) {
        return discList.get(name).getSound();
    }
    
    public MusicDisc getDisc(String name) {
        return discList.get(name);
    }
}
