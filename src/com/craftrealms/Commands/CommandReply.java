package com.craftrealms.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.craftrealms.CREssentials.CREssentials;
import com.craftrealms.CREssentials.UserData;

public class CommandReply implements CommandExecutor {
	private CREssentials p;
	public CommandReply(CREssentials plugin) {
		p = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		UserData data = new UserData(sender.getName());
		if(data.getLastPm() != null || data.getLastPm() != "") {
			Player recipient = Bukkit.getPlayer(data.getLastPm());
			if(recipient != null) {
				StringBuffer result = new StringBuffer();
				for (int i = 0; i < args.length; i++) {
					result.append( args[i] );
				}
				String message = result.toString();
				String pm = p.whisperformat.replace("%f", Bukkit.getPlayer(sender.getName()).getDisplayName());
				pm = pm.replace("%m", message);
				recipient.sendMessage(pm);
				return true;
			} else {
				sender.sendMessage("Player is no longer online!");
				return true;
			}
		} else {
			sender.sendMessage("Nobody has send you a PM recently!");
		}
		return false;
	}
	
}
