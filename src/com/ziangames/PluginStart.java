package com.ziangames;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginStart extends JavaPlugin{
	
	private Commands Commander;
	
	@Override
	public void onEnable() {
		getServer().getLogger().info("Plugin made by bennyman123abc");
		getServer().getLogger().info("Copyright 2016 ZianGames Inc.   All Rights Reserved");
		Commander = new Commands(this);
		new Events(this);
		
//		Register New Commands Under This Comment Like:
//		getCommand("CommandHere").setExecutor(Commander);
		
		getCommand("cname").setExecutor(Commander);
		
//		Update RPName and Exp count from Config
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			@SuppressWarnings("unused")
			@Override
			public void run() {
				for (Player player : Bukkit.getServer().getOnlinePlayers()) {
					int Exp = getConfig().getInt(player + ".exp");
					String rpname = getConfig().getString(player + ".rpname");
					
					player.setExp(Exp);
					
//					Titles and Custom Names to be added later
				}
				
			}
			
			
		}, 0L, 2L);
		
	}
	
}
