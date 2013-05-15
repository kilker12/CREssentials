package com.craftrealms.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTp implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player tp1 = null;
		Player tp2 = null;
		try {
			tp1 = Bukkit.getPlayer(args[0]);
		} catch(ArrayIndexOutOfBoundsException e) {}
		if(tp1 != null) {
			try {
				tp2 = Bukkit.getPlayer(args[1]);
			} catch(ArrayIndexOutOfBoundsException e) {}
			if(tp2 == null) {
			} else {
				tp1.teleport(tp2);
				return true;
			}
			Bukkit.getPlayer(sender.getName()).teleport(tp1);
			return true;
		} else {
			sender.sendMessage(args[0] + " is not currently online!");
			return true;
		}
	}
}
