package com.craftrealms.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.craftrealms.CREssentials.CREssentials;

public class CommandWhisper implements CommandExecutor {
	CREssentials p;
	public CommandWhisper(CREssentials plugin) {
		p = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player recipient = Bukkit.getPlayer(args[0]);
		if(recipient == null) {
			sender.sendMessage("Player is not online!");
			return true;
		}
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < args.length; i++) {
		   result.append( args[i] );
		   //result.append( optional separator );
		}
		String message = result.toString();
		String pm = p.whisperformat.replace("%f", Bukkit.getPlayer(sender.getName()).getDisplayName());
		pm = pm.replace("%m", message);
		recipient.sendMessage(pm);
		return true;
	}

}
