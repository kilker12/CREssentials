package com.craftrealms.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.craftrealms.CREssentials.CREssentials;

public class CommandFeed implements CommandExecutor {
	CREssentials p;
	public CommandFeed(CREssentials plugin) {
		p = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(p.hasPerm(sender, "feed")) {
			Player target;
			try {
				if(p.hasPerm(sender, "feed.others")) {
					target = Bukkit.getPlayer(args[0]);
				} else {
					sender.sendMessage("You dont have permission to do that!");
					return true;
				}
			} catch(ArrayIndexOutOfBoundsException e) {
				target = Bukkit.getPlayer(sender.getName());
			}
			if(target == null) {
				sender.sendMessage("Player is not online!");
				return true;
			}
			target.setFoodLevel(100);
			return true;
		} else {
			sender.sendMessage("You dont have permission to do that!");
			return true;
		}
	}
}
