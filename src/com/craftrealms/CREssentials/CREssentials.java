package com.craftrealms.CREssentials;

import org.bukkit.plugin.java.JavaPlugin;

import com.craftrealms.Commands.CommandBan;

public class CREssentials extends JavaPlugin {
	public void onEnable() {
		getCommand("ban").setExecutor(new CommandBan(this));
		info("CREssentials has been enabled!");
	}
	public void onDisable() {
		
	}
	public void info(String msg) {
		
	}
}
