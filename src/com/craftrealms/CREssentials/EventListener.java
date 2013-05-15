package com.craftrealms.CREssentials;

import java.io.File;
import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

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
	@EventHandler
	public void PlayerQuit(PlayerQuitEvent event) {
		UserData data = new UserData(event.getPlayer().getName());
		data.setLastPm("");
		data.setFly(false);
		event.getPlayer().setAllowFlight(false);
	}
	@EventHandler
	public void EntityDamage(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player)event.getEntity();
			if(p.gods.contains(player.getName())) {
				event.setCancelled(true);
			}
		}
	}
}
