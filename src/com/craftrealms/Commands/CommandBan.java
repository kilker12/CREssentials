package com.craftrealms.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.craftrealms.CREssentials.CREssentials;
import com.craftrealms.CREssentials.Utils;

public class CommandBan implements CommandExecutor {
	private CREssentials p;
	public CommandBan(CREssentials plugin) {
		this.p = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < args.length; i++) {
		   result.append( args[i] );
		   //result.append( optional separator );
		}
		String reason = result.toString();
		Player player = Bukkit.getPlayer(args[0]);
		if(player == null) {
			Bukkit.getOfflinePlayer(args[0]).setBanned(true);
			Utils.GetPlayerDataFile(p, Bukkit.getOfflinePlayer(args[0])).set("banned", reason);
		} else {
			player.setBanned(true);
			player.kickPlayer("Banned! Reason: " + reason);
			Utils.GetPlayerDataFile(p, Bukkit.getOfflinePlayer(args[0])).set("banned", reason);
		}
		return false;
	}
}
