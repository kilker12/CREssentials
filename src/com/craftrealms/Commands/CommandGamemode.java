package com.craftrealms.Commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.craftrealms.CREssentials.CREssentials;
import com.craftrealms.CREssentials.UserData;

public class CommandGamemode implements CommandExecutor {
	private CREssentials p;
	public CommandGamemode(CREssentials plugin) {
		p = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(p.hasPerm(sender, "gamemode")) {
			UserData data = new UserData(sender.getName());
			Player player = Bukkit.getPlayer(sender.getName());
			if(data.inCreative()) {
				player.setGameMode(GameMode.SURVIVAL);
				data.setCreative(false);
				return true;
			} else {
				player.setGameMode(GameMode.CREATIVE);
				data.setCreative(true);
				return true;
			}
		}
		return false;
	}
}
