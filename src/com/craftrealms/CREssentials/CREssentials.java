package com.craftrealms.CREssentials;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.craftrealms.Commands.*;

public class CREssentials extends JavaPlugin {
	public static Permission permission = null;
	public HashMap<String, Integer> tempbans = new HashMap<String, Integer>();
	public String whisperformat = null;
	public List<String> gods = new ArrayList<String>();
	
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
        		tempbans.put(key.toLowerCase(), tempbansf.getInt(key));
        	} catch (Exception e) {}
        }
        whisperformat = getConfig().getString("whisperformat");
        new Thread(new Timer(this)).start();
        setupPermissions();
		new EventListener(this);
		getCommand("setspawn").setExecutor(new CommandSetSpawn(this));
		getCommand("spawn").setExecutor(new CommandSpawn(this));
		getCommand("tempban").setExecutor(new CommandTempban(this));
		getCommand("tp").setExecutor(new CommandTp());
		getCommand("whisper").setExecutor(new CommandWhisper(this));
		getCommand("r").setExecutor(new CommandReply(this));
		getCommand("clearinventory").setExecutor(new CommandClearInventory(this));
		getCommand("feed").setExecutor(new CommandFeed(this));
		getCommand("heal").setExecutor(new CommandHeal(this));
		getCommand("burn").setExecutor(new CommandBurn(this));
		getCommand("exp").setExecutor(new CommandExp(this));
		getCommand("fly").setExecutor(new CommandFly(this));
		getCommand("gamemode").setExecutor(new CommandGamemode(this));
		getCommand("getpos").setExecutor(new CommandGetpos(this));
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
