package com.ziangames;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class Events implements Listener{
	
	PluginStart config;
	
	public Events(PluginStart plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		config = plugin;
	}
	
	@EventHandler
	public void playerKilled(EntityDeathEvent e){
		Entity killer = e.getEntity();
		
		if(killer instanceof Player) {
			Player player = ((Player) killer).getPlayer();
			
			int oldExp = config.getConfig().getInt(player + ".exp");
			int playerLevel = config.getConfig().getInt(player + ".lvl");
			
			
		}
	}

}
