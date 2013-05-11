package com.craftrealms.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.craftrealms.CREssentials.CREssentials;

public class CommandBan implements CommandExecutor {
	private CREssentials p;
	public CommandBan(CREssentials plugin) {
		this.p = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String reason = null;
		for(int i = 1; args[i] != null; i = i + 1) {
			reason += args[i];
		}
		p.info(reason);
		return false;
	}
}
