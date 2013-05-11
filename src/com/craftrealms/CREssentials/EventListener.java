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
		File f = new File("plugins/CREssentials/userdata/" + login.getPlayer().getName() + ".yml");
		if (!f.exists()) {
		    try {
		        f.createNewFile();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	}
}
