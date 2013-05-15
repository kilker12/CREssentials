package com.craftrealms.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.craftrealms.CREssentials.CREssentials;
import com.craftrealms.CREssentials.UserData;

public class CommandFly implements CommandExecutor {
	private CREssentials p;
	public CommandFly(CREssentials plugin) {
		p = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(p.hasPerm(sender, "fly")) {
			Player target = null;
			if(args.length > 0) {
				target = Bukkit.getPlayer(args[0]);
				if(target == null) {
					sender.sendMessage("Player is not online!");
					return true;
				}
			} else if(args.length == 0) {
				target = Bukkit.getPlayer(sender.getName());
			}
			UserData data = new UserData(target.getName());
			if(target.getAllowFlight()) {
				target.setAllowFlight(false);
				if(target.isFlying()) {
					target.setFlying(false);
				}
				data.setFly(false);
				sender.sendMessage("Flying disabled");
				return true;
			} else {
				target.setAllowFlight(true);
				data.setFly(true);
				sender.sendMessage("Flying enabled");
				return true;
			}
		}
		return false;
	}
}
