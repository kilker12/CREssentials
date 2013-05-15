package com.craftrealms.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.craftrealms.CREssentials.CREssentials;

public class CommandGod implements CommandExecutor {
	private CREssentials p;
	public CommandGod(CREssentials plugin) {
		p = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(p.hasPerm(sender, "god")) {
			if(args.length > 0) {
				if(p.hasPerm(sender, "god.others")) {
					Player player = Bukkit.getPlayer(args[0]);
					if(player == null) {
						sender.sendMessage(ChatColor.RED + "Player is not online!");
						return true;
					}
					if(p.gods.contains(player.getName())) {
						p.gods.remove(player.getName());
						player.sendMessage("God mode disabled");
						sender.sendMessage("God mode disabled for " + player.getDisplayName());
						return true;
					} else {
						p.gods.add(player.getName());
						player.sendMessage("God mode enabled");
						sender.sendMessage("God mode enabled for " + player.getDisplayName());
						return true;
					}
				} else {
					sender.sendMessage(ChatColor.RED + "You dont have permission to do that!");
				}
			} else if(args.length == 0) {
				if(p.gods.contains(sender.getName())) {
					p.gods.remove(sender.getName());
					sender.sendMessage("God mode disabled");
					return true;
				} else {
					p.gods.add(sender.getName());
					sender.sendMessage("God mode enabled");
					return true;
				}
			}
		} else {
			sender.sendMessage(ChatColor.RED + "You dont have permission to do that!");
			return true;
		}
		return false;
	}
}
