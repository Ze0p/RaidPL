package com.atosss.raidpl.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.Arrays;
import com.atosss.raidpl.RaidPL;

public class RaidGUI {
    public static final String GUI_NAME = "Raid Instellingen";
    private final RaidPL plugin;

    public RaidGUI(RaidPL plugin) {
        this.plugin = plugin;
    }

    public void openRaidGUI(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, GUI_NAME);

        gui.addItem(createGuiItem(Material.DIAMOND_SWORD, "Aantal Waves", "Klik om het aantal waves in te stellen"));
        gui.addItem(createGuiItem(Material.CLOCK, "Tijd per Wave", "Klik om de tijd per wave in te stellen"));
        gui.addItem(createGuiItem(Material.BEACON, "Wachttijd tussen Waves", "Klik om de wachttijd in te stellen"));
        gui.addItem(createGuiItem(Material.PAPER, "Mobs per Wave", "Klik om de mobs per wave in te stellen"));
        gui.addItem(createGuiItem(Material.GREEN_WOOL, "Start Raid", "Klik om de raid te starten"));

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
