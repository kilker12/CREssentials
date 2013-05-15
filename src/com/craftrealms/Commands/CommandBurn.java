package com.craftrealms.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.craftrealms.CREssentials.CREssentials;

public class CommandBurn implements CommandExecutor {
	private CREssentials p;
	public CommandBurn(CREssentials plugin) {
		p = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(p.hasPerm(sender, "burn")) {
			if(args.length < 1) {
				sender.sendMessage("Please enter a player to burn!");
				return true;
			}
			Player target = Bukkit.getPlayer(args[0]);
			if(target == null) {
				sender.sendMessage("Player is not online!");
				return true;
			}
			target.setFireTicks(10000);
			sender.sendMessage(target.getDisplayName() + " has been set on fire!");
			return true;
		}
		return false;
	}
	
}
