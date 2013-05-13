package com.craftrealms.CREssentials;

import java.io.File;
import java.util.HashMap;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.craftrealms.Commands.CommandBan;
import com.craftrealms.Commands.CommandSetSpawn;
import com.craftrealms.Commands.CommandSpawn;

public class CREssentials extends JavaPlugin {
	public static Permission permission = null;
	public HashMap<String, Integer> tempbans = new HashMap<String, Integer>();
	
	public void onEnable() {
		saveDefaultConfig();
		File userfiles;
        try {
            userfiles = new File(getDataFolder() + File.separator + "userdata");
            if(!userfiles.exists()){
                userfiles.mkdirs();
            }
        } catch(SecurityException e) {
            warning("Error creating userdata folder!");
            return;
        }
        File tempbanfile;
        try {
            tempbanfile = new File(getDataFolder() + File.separator + "tempbans.yml");
            if(!tempbanfile.exists()){
                tempbanfile.createNewFile();
            }
        } catch(Exception e) {
            warning("Error creating userdata folder!");
            return;
        }
        FileConfiguration tempbansf = YamlConfiguration.loadConfiguration(tempbanfile);
        for(String key : tempbansf.getKeys(false)){
        	try {
        		tempbans.put(key, tempbansf.getInt(key));
        	} catch (Exception e) {}
        }
        Timer timer = new Timer(this); 
        Thread timerThread = new Thread(timer);
        timerThread.start(); 
        setupPermissions();
		new EventListener(this);
		getCommand("ban").setExecutor(new CommandBan(this));
		getCommand("setspawn").setExecutor(new CommandSetSpawn(this));
		getCommand("spawn").setExecutor(new CommandSpawn(this));
		info("CREssentials has been enabled!");
	}
	public void onDisable() {
		
	}
	private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }
	public void info(String msg) {
		getLogger().info(msg);
	}
	public boolean hasPerm(Player player, String perm) {
		return permission.has(player, "cressentials." + perm);
	}
	public void warning(String msg) {
		getLogger().warning(msg);
	}
	public boolean hasPerm(CommandSender sender, String perm) {
		return permission.has(sender, "cressentials." + perm);
	}
}
