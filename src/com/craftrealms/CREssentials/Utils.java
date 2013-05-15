package com.craftrealms.CREssentials;

import java.io.File;
import java.io.IOException;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Utils {
	public static void SaveTempBans(CREssentials p) {
		File fileloc = new File(p.getDataFolder() + File.separator + "tempbans.yml");
		FileConfiguration tempbans = YamlConfiguration.loadConfiguration(fileloc);
		for(String key: p.tempbans.keySet()) {
			tempbans.set(key, p.tempbans.get(key));
		}
		try {
			tempbans.save(fileloc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static FileConfiguration GetPlayerDataFile(CREssentials p, Player player) {
		return YamlConfiguration.loadConfiguration(new File(p.getDataFolder() + File.separator + "userdata" + File.separator + player.getName() + ".yml"));
	}
	public static FileConfiguration GetPlayerDataFile(CREssentials p, OfflinePlayer offlinePlayer) {
		return YamlConfiguration.loadConfiguration(new File(p.getDataFolder() + File.separator + "userdata" + File.separator + offlinePlayer.getName() + ".yml"));
		
	}
}
