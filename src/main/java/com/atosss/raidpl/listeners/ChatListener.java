package com.atosss.raidpl.listeners;

import com.atosss.raidpl.gui.MobsPerWaveGUI;
import com.atosss.raidpl.gui.TimePerWaveGUI;
import com.atosss.raidpl.gui.WaitTimeGUI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.entity.Player;
import com.atosss.raidpl.RaidPL;

public class ChatListener implements Listener {
    private final RaidPL plugin;

    public ChatListener(RaidPL plugin) {
        this.plugin = plugin;
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
