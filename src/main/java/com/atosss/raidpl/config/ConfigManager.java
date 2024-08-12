package com.atosss.raidpl.config;

import com.atosss.raidpl.RaidPL;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;

public class ConfigManager {
    private final RaidPL plugin;
    private FileConfiguration config;
    private File configFile;

    public ConfigManager(RaidPL plugin) {
        this.plugin = plugin;
        this.configFile = new File(plugin.getDataFolder(), "config.yml");
    }

    public void loadConfig() {
        if (!configFile.exists()) {
            plugin.saveDefaultConfig();
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public FileConfiguration getConfig() {
        return config;
    }
    public int getDefaultWaves() {
        return config.getInt("default-waves");
    }

    public int getDefaultWaveTime() {
        return config.getInt("default-wave-time");
    }

}
