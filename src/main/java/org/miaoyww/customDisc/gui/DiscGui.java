package org.miaoyww.customDisc.gui;

import org.bukkit.*;
import org.bukkit.block.Jukebox;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DiscGui implements Listener {

    private final String name;
    private final int size;
    private Jukebox jukebox;

    public DiscGui() {
        this.name = ChatColor.DARK_GRAY + "Put your disc here";
        this.size = 1;
    }

    /// <summary>
    /// 获取唱片机Gui
    /// </summary>
    public Inventory GetDiscGui(Jukebox jukebox) {
        this.jukebox = jukebox;
        return Bukkit.createInventory(null, 9, this.name);
    }

    public Inventory GetDiscGui(Jukebox jukebox,ItemStack item) {
        this.jukebox = jukebox;
        Inventory inventory = Bukkit.createInventory(null, 9, this.name);
        inventory.addItem(item);
        return inventory;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase(this.name)) {
            if (event.isShiftClick()) {
                return;
            }
            Player player = (Player) event.getWhoClicked();
            ItemStack item = event.getCurrentItem();
            if (item != null && item.getType().toString().startsWith("MUSIC_DISC")) {
                if(item == jukebox.getRecord()) {
                    player.getInventory().addItem(item);
                    jukebox.getInventory().clear();
                    jukebox.update();
                    return;
                }
                jukebox.setRecord(item);
                jukebox.update();
            }
        }

    }
}
