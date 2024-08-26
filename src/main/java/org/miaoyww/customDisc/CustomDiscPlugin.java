package org.miaoyww.customDisc;

import net.kyori.adventure.sound.SoundStop;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Jukebox;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.miaoyww.customDisc.commands.CommandManager;
import org.miaoyww.customDisc.enums.MusicDiscType;
import org.miaoyww.customDisc.gui.DiscGui;
import org.miaoyww.customDisc.utils.CheckUtils;
import org.miaoyww.customDisc.utils.Files;
import org.miaoyww.customDisc.utils.Messages;

import java.util.*;
import java.util.logging.Level;

public final class CustomDiscPlugin extends JavaPlugin implements Listener {
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
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(Gui, this);
        Messages.sendConsole("CustomDisc插件已加载");
    }

    @Override
    public void onDisable() {

    }

    public void loadConfig() {
        Files.createDataFolders();
        Files.deserializeAllConfig();
        getConfig().options().copyDefaults(true);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();
            if (block.getType() != Material.JUKEBOX) return;
            Jukebox jukebox = (Jukebox) block.getState();
            if (jukebox.hasRecord()) {
                block.getWorld().stopSound(SoundStop.all());
                return;
            }
            if (CheckUtils.isCustomDisc(event.getPlayer().getInventory().getItemInMainHand())) {
                Player player = event.getPlayer();
                event.setCancelled(true);
                ItemStack currentItem = event.getPlayer().getInventory().getItemInMainHand();
                jukebox.getInventory().addItem(currentItem);
                player.getInventory().setItemInMainHand(null);
                block.getWorld().stopSound(SoundStop.all());

                NamespacedKey recordKey = new NamespacedKey("custom_disc", "record");
                if (currentItem.getItemMeta().getPersistentDataContainer().has(recordKey, PersistentDataType.STRING)) {
                    String record = currentItem.getItemMeta().getPersistentDataContainer().get(recordKey, PersistentDataType.STRING);
                    if (record != null) {
                        block.getWorld().playSound(block.getLocation(), record, 1f, 1f);
                    }
                }
            }
        }
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    public static CustomDiscPlugin getInstance() {
        return instance;
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
}
