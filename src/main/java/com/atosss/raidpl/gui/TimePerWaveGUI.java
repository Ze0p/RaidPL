package com.atosss.raidpl.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.Arrays;
import com.atosss.raidpl.RaidPL;

public class TimePerWaveGUI {
    private final RaidPL plugin;

    public TimePerWaveGUI(RaidPL plugin) {
        this.plugin = plugin;
    }

    public void openTimePerWaveGUI(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, "Tijd per Wave");

        // Voeg items toe voor elke wave
        for (int i = 0; i < plugin.getRaidManager().getNumberOfWaves(player); i++) {
            gui.addItem(createGuiItem(Material.CLOCK, "Wave " + (i + 1), "Klik om tijd in te stellen voor wave " + (i + 1)));
        }

        player.openInventory(gui);
    }

    private ItemStack createGuiItem(Material material, String name, String... lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }
}
