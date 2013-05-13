package com.craftrealms.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.craftrealms.CREssentials.CREssentials;

public class CommandSetSpawn implements CommandExecutor {
	private CREssentials p;
	
	public CommandSetSpawn(CREssentials plugin) {
		p = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		if(p.hasPerm(sender, "setspawn")) {
			Player player = Bukkit.getPlayer(sender.getName());
			player.getWorld().setSpawnLocation(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
			player.sendMessage("New spawn location set for world " + player.getWorld());
			return true;
		}
		return false;
	}
	
}
