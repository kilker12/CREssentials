package com.craftrealms.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.craftrealms.CREssentials.CREssentials;

public class CommandExp implements CommandExecutor {
	private CREssentials p;
	public CommandExp(CREssentials plugin) {
		p = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(p.hasPerm(sender, "exp")) {
			if(args.length == 0) {
				sender.sendMessage(sender.getName() + " has " + Bukkit.getPlayer(sender.getName()).getExp() + " experience");
				return true;
			} else if(args.length == 3) {
				if(args[0] == "set") {
					if(p.hasPerm(sender, "exp.set")) {
						Player target = Bukkit.getPlayer(args[1]);
						if(target == null) {
							sender.sendMessage("Player is not online!");
							return true;
						}
						target.setExp(Float.parseFloat(args[2]));
						return true;
					} else {
						sender.sendMessage("You dont have permission to do that!");
						return true;
					}
				}
			} else if(args.length == 2) {
				if(args[0] == "set") {
					if(p.hasPerm(sender, "exp.set")) {
						Player target = Bukkit.getPlayer(sender.getName());
						target.setExp(Float.parseFloat(args[1]));
						return true;
					}
				}
			} else if(args.length == 1) {
				Player target = Bukkit.getPlayer(args[0]);
				if(target == null) {
					sender.sendMessage("Player is not online!");
					return true;
				}
				sender.sendMessage(target.getDisplayName() + " has " + target.getExp() + " experience");
				return true;
			} else {
				return false;
			}
		} else {
			sender.sendMessage("You dont have permission to do that!");
		}
		return false;
	}
}
