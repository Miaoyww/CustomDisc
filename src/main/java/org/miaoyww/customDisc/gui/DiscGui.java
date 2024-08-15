package org.miaoyww.customDisc.gui;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.miaoyww.customDisc.CustomDiscPlugin;
import org.miaoyww.customDisc.MusicDisc;
import org.miaoyww.customDisc.enums.MusicDiscType;
import org.miaoyww.customDisc.utils.ActionBar;
import org.miaoyww.customDisc.utils.PlaySound;

import java.util.Iterator;
import java.util.logging.Level;

public class DiscGui implements Listener {

    private final String name;
    private final int size;

    public DiscGui() {
        this.name = ChatColor.DARK_GRAY + "\u266b" + " Disc List " + "\u266b";
        this.size = 1;
    }

    /// <summary>
    /// 获取唱片机Gui
    /// </summary>
    public Inventory GetDiscGui() {
        Inventory inventory = Bukkit.createInventory(null, 18, this.name);
        int discCount = 0;
        for (Iterator<String> it = CustomDiscPlugin.getInstance().discList.keys().asIterator(); it.hasNext(); ) {
            String key = it.next();
            Bukkit.getLogger().log(Level.INFO, "Key: " + key);
            MusicDisc value = CustomDiscPlugin.getInstance().discList.get(key);
            inventory.setItem(discCount, value.getItemStack());
            discCount += 1;
        }

        return inventory;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {


        if (event.getView().getTitle().equalsIgnoreCase(this.name)) {
            if (event.isShiftClick()) {
                event.setCancelled(true);
                return;
            }
            Player player = (Player) event.getWhoClicked();
            player.playSound(
                    player,
                    Sound.UI_BUTTON_CLICK,
                    SoundCategory.PLAYERS,
                    1,
                    1);

            event.setCancelled(true);
            event.getWhoClicked().closeInventory();

            if (event.getWhoClicked() instanceof Player) {
                try {
                    if (Sound.valueOf(event.getCurrentItem().getType().toString().toUpperCase()) != null) {
                        player.stopAllSounds();
                        PlaySound.playSound(player, CustomDiscPlugin.getInstance().getDiscSound(event.getCurrentItem().getLore().get(0)));
                    }
                    Bukkit.getLogger().log(Level.INFO, "Playing " + event.getCurrentItem().getType().toString().toUpperCase());
//                    ActionBar.sendActionBar(player, ChatColor.LIGHT_PURPLE + "\u266b" + ChatColor.GREEN + " Now Playing "  + event.getCurrentItem().getLore() + ChatColor.LIGHT_PURPLE + "\u266b", 0, 10, 0);
                } catch (IllegalArgumentException var4) {
                }
            }
        }

    }
}
