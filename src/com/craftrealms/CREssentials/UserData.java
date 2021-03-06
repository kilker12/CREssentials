package com.craftrealms.CREssentials;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class UserData extends Player {
	private FileConfiguration file;
	private String p;
	
	public UserData(String player) {
		p = player;
		file = YamlConfiguration.loadConfiguration(new File("plugins" + File.separator + "CREssentials" + File.separator + "userdata" + File.separator + player + ".yml"));
	}
	private void saveData() {
		try {
			file.save(new File("plugins" + File.separator + "CREssentials" + File.separator + "userdata" + File.separator + p + ".yml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public boolean getMuted() {
		return file.getBoolean("muted");
	}
	public String getLastPm() {
		return file.getString("lastpm");
	}
	public boolean isBanned() {
		return file.getBoolean("banned");
	}
	public int getTempBanTime() {
		return file.getInt("bannedtime");
	}
	public boolean getFly() {
		return file.getBoolean("fly");
	}
	public boolean inCreative() {
		return file.getBoolean("creative");
	}
	public void setBanned(boolean b) {
		file.set("banned", true);
		file.set("bannedtime", 0);
	}
	public void setTempBanTime(int t) {
		file.set("bannedtime", t);
	}
	public void setLastPm(String player) {
		file.set("lastpm", player);
		saveData();
	}
	public void setCreative(boolean b) {
		file.set("creative", b);
		saveData();
	}
	public void setFly(boolean b) {
		file.set("fly", true);
		saveData();
	}
	public void setMuted(boolean b) {
		file.set("muted", b);
		saveData();
	}
}
