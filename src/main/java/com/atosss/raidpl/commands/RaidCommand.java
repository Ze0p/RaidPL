package com.atosss.raidpl.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Optional;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.atosss.raidpl.RaidPL;
import com.atosss.raidpl.gui.RaidGUI;

public class RaidCommand extends BaseCommand {
    private final RaidPL plugin;

    public RaidCommand(RaidPL plugin) {
        this.plugin = plugin;
    }

    @CommandAlias("raid")
    @Default
    public void onRaidCommand(CommandSender sender, @Optional String region) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Dit commando kan alleen door een speler worden uitgevoerd.");
            return;
        }

        Player player = (Player) sender;

        if (region == null || region.isEmpty()) {
            player.sendMessage("Gebruik: /raid <region>");
            return;
        }

        // Open de Raid GUI
        RaidGUI raidGUI = new RaidGUI(plugin);
        raidGUI.openRaidGUI(player);
    }
}
