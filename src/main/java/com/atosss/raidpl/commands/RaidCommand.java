package com.atosss.raidpl.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Subcommand;
import org.bukkit.command.CommandSender;

public class RaidCommand extends BaseCommand {

    @CommandAlias("raid")
    public void onRaidCommand(CommandSender sender) {
        // Handle main /raid command
    }

    @Subcommand("start")
    public void onStart(CommandSender sender) {
        // Handle starting a raid
    }
}
