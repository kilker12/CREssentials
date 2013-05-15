package com.craftrealms.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.craftrealms.CREssentials.CREssentials;

public class CommandTempban implements CommandExecutor {
	private CREssentials p;
	
	public CommandTempban(CREssentials plugin) {
		p = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(p.hasPerm(sender, "tempban")) {
			Player target = Bukkit.getPlayer(args[0]);
			if(target == null) {
				p.tempbans.put(args[0], Integer.parseInt(args[1]));
				return true;
			} else {
				p.tempbans.put(args[0], Integer.parseInt(args[1]));
				target.kickPlayer("You are temporarily banned for " + args[1] + " minutes!");
				return true;
			}
		}
		return false;
	}

}
