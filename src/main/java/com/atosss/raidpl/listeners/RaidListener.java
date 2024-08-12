package com.atosss.raidpl.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.entity.Player;
import com.atosss.raidpl.RaidPL;
import com.atosss.raidpl.gui.RaidGUI;
import com.atosss.raidpl.gui.TimePerWaveGUI;
import com.atosss.raidpl.gui.WaitTimeGUI;
import com.atosss.raidpl.gui.MobsPerWaveGUI;

public class RaidListener implements Listener {
    private final RaidPL plugin;

    public RaidListener(RaidPL plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        Player player = (Player) event.getWhoClicked();

        // Hoofd-GUI interacties
        if (inventory.getHolder().equals(RaidGUI.GUI_NAME)) {// Gebruik getName() in plaats van getTitle()
            event.setCancelled(true); // Voorkom dat de speler items uit de GUI haalt
            int slot = event.getSlot();

            switch (slot) {
                case 0: // Aantal Waves
                    player.sendMessage("Typ het aantal waves in de chat.");
                    plugin.getRaidManager().setSettingWaves(player, true); // Zet instelling aan
                    break;
                case 1: // Tijd per Wave
                    if (plugin.getRaidManager().getNumberOfWaves(player) == 0) {
                        player.sendMessage("Stel eerst het aantal waves in.");
                    } else {
                        TimePerWaveGUI timeGUI = new TimePerWaveGUI(plugin);
                        timeGUI.openTimePerWaveGUI(player);
                    }
                    break;
                case 2: // Wachttijd tussen Waves
                    if (plugin.getRaidManager().getNumberOfWaves(player) == 0) {
                        player.sendMessage("Stel eerst het aantal waves in.");
                    } else {
                        WaitTimeGUI waitGUI = new WaitTimeGUI(plugin);
                        waitGUI.openWaitTimeGUI(player);
                    }
                    break;
                case 3: // Mobs per Wave
                    if (plugin.getRaidManager().getNumberOfWaves(player) == 0) {
                        player.sendMessage("Stel eerst het aantal waves in.");
                    } else {
                        MobsPerWaveGUI mobsGUI = new MobsPerWaveGUI(plugin);
                        mobsGUI.openMobsPerWaveGUI(player);
                    }
                    break;
                case 4: // Start Raid
                    player.sendMessage("Raid gestart!");
                    plugin.getRaidManager().startRaid(player); // Zorg ervoor dat deze methode bestaat
                    break;
                default:
                    break;
            }
        }
    }


    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();

        // Controleer of de speler bezig is met het instellen van het aantal waves
        if (plugin.getRaidManager().isSettingWaves(player)) {
            event.setCancelled(true); // Voorkom dat het bericht in de chat verschijnt

            try {
                int waves = Integer.parseInt(message);
                plugin.getRaidManager().setNumberOfWaves(player, waves);
                player.sendMessage("Aantal waves ingesteld op: " + waves);
                player.sendMessage("Klik nu op de tijd per wave in de GUI.");
                plugin.getRaidManager().setSettingWaves(player, false); // Zet de instelling terug naar false
                // Open de tijd per wave GUI
                TimePerWaveGUI timeGUI = new TimePerWaveGUI(plugin);
                timeGUI.openTimePerWaveGUI(player);
            } catch (NumberFormatException e) {
                player.sendMessage("Voer een geldig getal in voor het aantal waves.");
            }
        }

        // Controleer of de speler bezig is met het instellen van de tijd per wave
        if (plugin.getRaidManager().isSettingTimePerWave(player)) {
            event.setCancelled(true); // Voorkom dat het bericht in de chat verschijnt

            try {
                int time = Integer.parseInt(message);
                int waveIndex = plugin.getRaidManager().getCurrentWaveIndex(player); // Huidige wave index
                plugin.getRaidManager().setTimePerWave(player, waveIndex, time);
                player.sendMessage("Tijd voor wave " + (waveIndex + 1) + " ingesteld op: " + time + " seconden.");
                plugin.getRaidManager().setSettingTimePerWave(player, false); // Zet de instelling terug naar false
                // Open de wachttijd GUI
                WaitTimeGUI waitGUI = new WaitTimeGUI(plugin);
                waitGUI.openWaitTimeGUI(player);
            } catch (NumberFormatException e) {
                player.sendMessage("Voer een geldig getal in voor de tijd per wave.");
            }
        }

        // Controleer of de speler bezig is met het instellen van de wachttijd
        if (plugin.getRaidManager().isSettingWaitTime(player)) {
            event.setCancelled(true); // Voorkom dat het bericht in de chat verschijnt

            try {
                int waitTime = Integer.parseInt(message);
                int waveIndex = plugin.getRaidManager().getCurrentWaveIndex(player); // Huidige wave index
                plugin.getRaidManager().setWaitTime(player, waveIndex, waitTime);
                player.sendMessage("Wachttijd tussen wave " + (waveIndex + 1) + " ingesteld op: " + waitTime + " seconden.");
                plugin.getRaidManager().setSettingWaitTime(player, false); // Zet de instelling terug naar false
                // Open de mobs per wave GUI
                MobsPerWaveGUI mobsGUI = new MobsPerWaveGUI(plugin);
                mobsGUI.openMobsPerWaveGUI(player);
            } catch (NumberFormatException e) {
                player.sendMessage("Voer een geldig getal in voor de wachttijd.");
            }
        }
    }
}
