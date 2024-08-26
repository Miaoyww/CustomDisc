package org.miaoyww.customDisc.utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.json.simple.parser.JSONParser;
import org.miaoyww.customDisc.CustomDiscPlugin;
import org.miaoyww.customDisc.MusicDisc;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

public class Files {
    static String pluginFolderPath = CustomDiscPlugin.getPlugin().getDataFolder().getPath();

    public static void createDataFolders() {
        File timersFile = new File(pluginFolderPath + "/discs");
        timersFile.mkdirs();
    }

    public static void deserializeAllConfig() {
        File dir = new File(pluginFolderPath + "/discs");
        File[] directoryListing = dir.listFiles();
        try {
            if (directoryListing != null) {
                for (File file : directoryListing) {
                    if (!file.exists() || !file.getName().contains("yaml")) {
                        continue;
                    }
                    try {
                        for (MusicDisc musicDisc : MusicDisc.readFromFile(file.getPath())) {
                            CustomDiscPlugin.getInstance().discList.put(musicDisc.getName(), musicDisc);
                        }
                    } catch (Exception e) {
                        Messages.sendConsole("加载" + file.getName() + "时出错" + e);
                    }
                }
            }
        } catch (Exception e) {
            Messages.sendConsole("加载配置时出错" + e);
        }
    }

    public static void saveDiscConfig() {
        File file = new File(pluginFolderPath + "/discs/discs.yaml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        config.createSection("discs");
        for (Iterator<String> it = CustomDiscPlugin.getInstance().discList.keys().asIterator(); it.hasNext(); ) {
            String key = it.next();
            MusicDisc disc = CustomDiscPlugin.getInstance().discList.get(key);
            Messages.sendConsole("Saving disc: " + disc.getName());
            config.set("discs." + key + ".name", disc.getDisplayName());
            config.set("discs." + key + ".lore", disc.getItem().getLore());
            config.set("discs." + key + ".record", disc.getSound());
            config.set("discs." + key + ".material", CheckUtils.getString(disc.getItem().getType()));
        }
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
