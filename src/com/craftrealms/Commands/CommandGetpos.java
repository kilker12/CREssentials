package com.craftrealms.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.craftrealms.CREssentials.CREssentials;

public class CommandGetpos implements CommandExecutor {
	private CREssentials p;
	public CommandGetpos(CREssentials plugin) {
		p = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(p.hasPerm(sender, "getpos")) {
			Location player = Bukkit.getPlayer(sender.getName()).getLocation();
			sender.sendMessage("Your location - X: " + player.getBlockX() + " Y: " + player.getBlockY() + " Z: " + player.getBlockZ());
			return true;
		} else {
			sender.sendMessage("You dont have permission to do that!");
		}
		return false;
	}
	
}
