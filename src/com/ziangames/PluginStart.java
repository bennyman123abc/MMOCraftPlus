package com.ziangames;

import org.bukkit.plugin.java.JavaPlugin;

public class PluginStart extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getServer().getLogger().info("Plugin made by bennyman123abc and SomeAnnoyingGuy");
		getServer().getLogger().info("Copyright ©2016 ZianGames Inc.   All Rights Reserved");
		new Commands(this);
		
//		Register New Commands Under This Comment Like:
//		getCommand("CommandHere").setExecutor(Commander);
		
		
		
	}
	
	
}
