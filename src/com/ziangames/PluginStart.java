package com.ziangames;

import org.bukkit.plugin.java.JavaPlugin;

public class PluginStart extends JavaPlugin{
	
	private Commands Commander;
	
	@Override
	public void onEnable() {
		getServer().getLogger().info("Plugin made by bennyman123abc and SomeAnnoyingGuy");
		getServer().getLogger().info("Copyright ©2016 ZianGames Inc.   All Rights Reserved");
		Commander = new Commands(this);
		new Events(this);
		
//		Register New Commands Under This Comment Like:
//		getCommand("CommandHere").setExecutor(Commander);
		
		getCommand("cname").setExecutor(Commander);
		
	}
	
	
}
