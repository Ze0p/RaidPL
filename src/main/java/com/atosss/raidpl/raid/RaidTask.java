package com.atosss.raidpl.raid;

import org.bukkit.scheduler.BukkitRunnable;

public class RaidTask extends BukkitRunnable {
    private final Raid raid;

    public RaidTask(Raid raid) {
        this.raid = raid;
    }

    @Override
    public void run() {
        // Raid task logic here
    }
}
