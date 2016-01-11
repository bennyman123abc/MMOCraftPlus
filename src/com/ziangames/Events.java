package com.ziangames;

import org.bukkit.event.Listener;

public class Events implements Listener{
	
	PluginStart config;
	
	public Events(PluginStart plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		config = plugin;
	}

}
