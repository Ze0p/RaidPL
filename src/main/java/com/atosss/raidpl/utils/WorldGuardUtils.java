package com.atosss.raidpl.utils;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

public class WorldGuardUtils {
    private final WorldGuardPlugin worldGuard;

    public WorldGuardUtils(Plugin plugin) {
        this.worldGuard = (WorldGuardPlugin) plugin.getServer().getPluginManager().getPlugin("WorldGuard");
    }

    public boolean isInRegion(Location location, String region) {
        // Check if the location is inside the specified region
        return true; // Example placeholder
    }
}
