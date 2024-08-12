package com.atosss.raidpl.managers;

import com.atosss.raidpl.RaidPL;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class RaidManager {
    private final RaidPL plugin;
    private final Map<Player, Integer> playerWaves = new HashMap<>();
    private final Map<Player, Integer[]> timePerWave = new HashMap<>();
    private final Map<Player, Integer[]> waitTimePerWave = new HashMap<>();
    private final Map<Player, Map<Integer, String>> mobsPerWave = new HashMap<>();

    // Instellingen
    private final Map<Player, Boolean> settingWaves = new HashMap<>();
    private final Map<Player, Boolean> settingTimePerWave = new HashMap<>();
    private final Map<Player, Boolean> settingWaitTime = new HashMap<>();
    private final Map<Player, Integer> currentWaveIndex = new HashMap<>();

    public RaidManager(RaidPL plugin) {
        this.plugin = plugin;
    }

    public void setNumberOfWaves(Player player, int waves) {
        playerWaves.put(player, waves);
        timePerWave.put(player, new Integer[waves]); // Initialiseer tijd array
        waitTimePerWave.put(player, new Integer[waves]); // Initialiseer wachttijd array
        mobsPerWave.put(player, new HashMap<>()); // Initialiseer mobs map
    }

    public int getNumberOfWaves(Player player) {
        return playerWaves.getOrDefault(player, 0);
    }

    public void setSettingWaves(Player player, boolean setting) {
        settingWaves.put(player, setting);
    }

    public boolean isSettingWaves(Player player) {
        return settingWaves.getOrDefault(player, false);
    }

    public void setSettingTimePerWave(Player player, boolean setting) {
        settingTimePerWave.put(player, setting);
    }

    public boolean isSettingTimePerWave(Player player) {
        return settingTimePerWave.getOrDefault(player, false);
    }

    public void setSettingWaitTime(Player player, boolean setting) {
        settingWaitTime.put(player, setting);
    }

    public boolean isSettingWaitTime(Player player) {
        return settingWaitTime.getOrDefault(player, false);
    }

    public void setTimePerWave(Player player, int waveIndex, int time) {
        Integer[] times = timePerWave.get(player);
        if (times != null && waveIndex < times.length) {
            times[waveIndex] = time;
        }
    }

    public Integer getTimePerWave(Player player, int waveIndex) {
        Integer[] times = timePerWave.get(player);
        return (times != null && waveIndex < times.length) ? times[waveIndex] : null;
    }

    public void setWaitTime(Player player, int waveIndex, int waitTime) {
        Integer[] waits = waitTimePerWave.get(player);
        if (waits != null && waveIndex < waits.length) {
            waits[waveIndex] = waitTime;
        }
    }

    public Integer getWaitTime(Player player, int waveIndex) {
        Integer[] waits = waitTimePerWave.get(player);
        return (waits != null && waveIndex < waits.length) ? waits[waveIndex] : null;
    }

    public void setMobsForWave(Player player, int waveIndex, String mobType) {
        Map<Integer, String> mobs = mobsPerWave.get(player);
        if (mobs != null) {
            mobs.put(waveIndex, mobType);
        }
    }

    public String getMobsForWave(Player player, int waveIndex) {
        Map<Integer, String> mobs = mobsPerWave.get(player);
        return (mobs != null) ? mobs.get(waveIndex) : null; // Controleer of mobs niet null is
    }

    public int getCurrentWaveIndex(Player player) {
        return currentWaveIndex.getOrDefault(player, 0); // Huidige wave index
    }

    public void setCurrentWaveIndex(Player player, int index) {
        currentWaveIndex.put(player, index);
    }

    public void startRaid(Player player) {
        int waves = getNumberOfWaves(player);
        // Logica om de raid te starten
    }
}
