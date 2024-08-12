package com.atosss.raidpl.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class RaidGui extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

        getCommand("raid").setExecutor((sender, command, label, args) -> {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                openRaidSettingsGui(player);
                return true;
            }
            return false;
        });
    }

    private void openRaidSettingsGui(Player player) {
        Inventory gui = getServer().createInventory(null, 27, "Raid Settings");

        // Voeg een item toe aan de GUI
        ItemStack swordItem = new ItemStack(Material.DIAMOND_SWORD);
        gui.setItem(11, swordItem);

        // Open de GUI voor de speler
        player.openInventory(gui);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("Raid Settings")) {
            event.setCancelled(true); // Zorg ervoor dat andere interacties niet plaatsvinden

            if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
                Player player = (Player) event.getWhoClicked();
                player.sendMessage("Sword clicked!");
            }
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        // Je kunt hier logica toevoegen voor wanneer de speler de GUI sluit
    }
}
