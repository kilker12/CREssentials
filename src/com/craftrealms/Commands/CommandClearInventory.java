package com.craftrealms.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.craftrealms.CREssentials.CREssentials;

public class CommandClearInventory implements CommandExecutor {
	private CREssentials p;
	public CommandClearInventory(CREssentials plugin) {
		p = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player target;
		try {
			if(p.hasPerm(sender, "clearinventory.others")) {
				target = Bukkit.getPlayer(args[0]);
			} else {
				sender.sendMessage(ChatColor.RED + "You dont have permission to do that!");
				return true;
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			target = Bukkit.getPlayer(sender.getName());
		}
		target.getInventory().clear();
		return true;
	}

}
