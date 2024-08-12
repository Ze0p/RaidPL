package com.atosss.raidpl;

import org.bukkit.plugin.java.JavaPlugin;

public class RaidPL extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("RaidPL enabled!");
        // Initialize commands, listeners, and GUI
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("RaidPL disabled!");
    }
}
