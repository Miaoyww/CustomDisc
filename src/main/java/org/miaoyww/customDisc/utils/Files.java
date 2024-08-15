package org.miaoyww.customDisc.utils;

import org.bukkit.Bukkit;
import org.json.simple.parser.JSONParser;
import org.miaoyww.customDisc.CustomDiscPlugin;
import org.miaoyww.customDisc.MusicDisc;

import java.io.File;
import java.util.logging.Level;

public class Files {
    static String pluginFolderPath = CustomDiscPlugin.getPlugin().getDataFolder().getPath();
    
    public static void createDataFolders() {
        File timersFile = new File(pluginFolderPath + "/discs");
        timersFile.mkdirs();
    }

    public static void deserializeAllConfig(){
        File dir = new File(pluginFolderPath + "/discs");
        File[] directoryListing = dir.listFiles();
        JSONParser jsonParser = new JSONParser();
        try {
            if (directoryListing != null) {
                for (File file : directoryListing) {
                    if (!file.exists() || !file.getName().contains("yaml")) {
                        continue;
                    }
                    MusicDisc item = MusicDisc.readFromFile(file.getPath());
                    Bukkit.getLogger().log(Level.INFO, "Loaded config file " + file.getName() + ":" + item.toString());
                }
            }
            
            
        }catch (Exception e) {
            Bukkit.getLogger().log(Level.SEVERE, "Error deserializing config files", e);
        }
    }


    
}
