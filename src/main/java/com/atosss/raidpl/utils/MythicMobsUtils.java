package com.atosss.raidpl.utils;

import io.lumine.mythic.api.mobs.MythicMob;
import io.lumine.mythic.bukkit.BukkitAdapter;
import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.core.mobs.ActiveMob;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import java.util.Optional;

public class MythicMobsUtils {

    // Retrieve a MythicMob by name
    public MythicMob getMythicMob(String mobName) {
        return MythicBukkit.inst().getMobManager()
                .getMythicMob(mobName)
                .orElse(null); // Returns null if the mob is not found
    }

    // Spawn a MythicMob at a given location
    public void spawnMythicMob(String mobName, Location location, int count) {
        MythicMob mob = getMythicMob(mobName);
        if (mob != null) {
            ActiveMob activeMob = mob.spawn(BukkitAdapter.adapt(location), count);
            Entity entity = activeMob.getEntity().getBukkitEntity();
            // Now you can use the Bukkit entity if needed
        }
    }

    // Check if a Bukkit Entity is a MythicMob
    public boolean isMythicMob(Entity entity) {
        return MythicBukkit.inst().getMobManager().isMythicMob(entity);
    }

    // Get the type of an ActiveMob from its Bukkit Entity
    public Optional<String> getMobType(Entity entity) {
        return MythicBukkit.inst().getMobManager().getActiveMob(entity.getUniqueId())
                .map(ActiveMob::getType)
                .map(type -> type.getInternalName());
    }

}
