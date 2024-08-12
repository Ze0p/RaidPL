package com.atosss.raidpl.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager {
    private final JavaPlugin plugin;
    private FileConfiguration config;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
        // Load other configurations
    }

    public FileConfiguration getConfig() {
        return config;
    }

    // Methods to access and modify configurations
}
