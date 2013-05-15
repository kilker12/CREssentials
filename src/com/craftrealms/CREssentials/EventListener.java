package com.craftrealms.CREssentials;

import java.io.File;
import java.io.IOException;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class EventListener implements Listener {
	private CREssentials p;
	public EventListener(CREssentials plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		p = plugin;
	}
	@EventHandler
	public void PlayerLogin(PlayerLoginEvent login) {
		File userfiles = new File(p.getDataFolder() + File.separator + "userdata" + File.separator + login.getPlayer().getName() + ".yml");
		if(!userfiles.exists()){
			try {
				userfiles.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(p.tempbans.containsKey(login.getPlayer().getName().toLowerCase())) {
			login.setKickMessage("You are temporarily banned for " + p.tempbans.get(login.getPlayer().getName().toLowerCase()) + " minutes!");
			login.setResult(null);
		}
	}
}
