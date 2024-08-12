package com.atosss.raidpl;

import co.aikar.commands.PaperCommandManager;
import com.atosss.raidpl.commands.RaidCommand;
import org.bukkit.plugin.java.JavaPlugin;
import com.atosss.raidpl.listeners.RaidListener;
import com.atosss.raidpl.managers.RaidManager;

public class RaidPL extends JavaPlugin {
    private PaperCommandManager commandManager;
    private RaidManager raidManager;

    @Override
    public void onEnable() {
        commandManager = new PaperCommandManager(this);
        commandManager.registerCommand(new RaidCommand(this));

        raidManager = new RaidManager(this);
        getServer().getPluginManager().registerEvents(new RaidListener(this), this);

        getLogger().info("RaidPL is ingeschakeld!");
    }

    @Override
    public void onDisable() {
        getLogger().info("RaidPL is uitgeschakeld!");
    }

    public RaidManager getRaidManager() {
        return raidManager;
    }
}
