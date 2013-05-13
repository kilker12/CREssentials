package com.craftrealms.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.craftrealms.CREssentials.CREssentials;

public class CommandSpawn implements CommandExecutor {
	private CREssentials p;
	public CommandSpawn(CREssentials plugin) {
		p = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String label, String[] args) {
		if(p.hasPerm(sender, "spawn")) {
			Player player = Bukkit.getPlayer(sender.getName());
			player.teleport(player.getWorld().getSpawnLocation());
			player.sendMessage("You have been teleported to the world spawn");
			return true;
		}
		return false;
	}
}
