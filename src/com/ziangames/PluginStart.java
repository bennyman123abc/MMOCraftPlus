package com.ziangames;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginStart extends JavaPlugin{
	
	private Commands Commander;
	
	public static final Permission admin = new Permission("mmo.admin");
	
	@SuppressWarnings("unused")
	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		
		pm.addPermission(admin);
		
		getServer().getLogger().info("Plugin made by bennyman123abc");
		getServer().getLogger().info("Copyright 2016 ZianGames Inc.   All Rights Reserved");
		Commander = new Commands(this);
		new Events(this);
		new ErrorMessages();
		
		boolean cfgGen = getConfig().getBoolean("generated");
		
		if(cfgGen = true) {
//			getServer().getLogger().info("Plugin Config Already Generated. Moving On");
		}
		
		if(cfgGen = true) {
//			getServer().getLogger().info("Config Not Generated. Generating Config Now");
			
			int lvl = 1;
			
			while(lvl <= 16) {
				double equ = (lvl * lvl) + (6 * lvl);
				String cfglvl = String.valueOf(lvl);
				getConfig().set("levelValue" + cfglvl, equ);
				lvl++;
			}
			
			while(lvl >= 17 && lvl <= 31) {
				double square = Math.pow(lvl, 2);
				double equ = (2.5 * square) - (40.5 * lvl) + 360;
				String cfglvl = String.valueOf(lvl);
				getConfig().set("levelValue" + cfglvl, equ);
				lvl++;
			}
			
			getServer().getLogger().info("Config Generation Complete!");
			getServer().getLogger().info("Config Will Now Be Loaded Into Memory");
			getConfig().set("generated", true);
			saveConfig();
		}
		
//		Register New Commands Under This Comment Like:
//		getCommand("CommandHere").setExecutor(Commander);
		
		getCommand("cname").setExecutor(Commander);
		
//		Update RPName and Exp count from Config
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			public void run() {
				for (Player player : Bukkit.getServer().getOnlinePlayers()) {
					int Exp = getConfig().getInt(player + ".exp");
					player.setExp(Exp);
					int lvl = player.getExpToLevel();
					String rpname = getConfig().getString(player + ".rpname");
					
					player.setLevel(lvl);
					
					
					if(!(rpname == "")) {
						player.setCustomName(rpname);
					}
//					Titles to be added later
				}
				
			}
			
			
		}, 0L, 2L);
		
	}
	
}
