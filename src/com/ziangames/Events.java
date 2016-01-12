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
	
	@SuppressWarnings("unused")
	@EventHandler
	public void playerKilled(EntityDeathEvent e){
		Entity killer = e.getEntity();
		
		e.setDroppedExp(0);
		
		if(killer instanceof Player) {
			Player player = ((Player) killer).getPlayer();
			
			int oldExp = config.getConfig().getInt(player + ".exp");
			int oldPlayerLevel = config.getConfig().getInt(player + ".lvl");
			int newExp = oldExp + 1;
			player.setExp(newExp);
			config.getConfig().set(player + ".exp", newExp);
			config.saveConfig();
			
//			Possible XP sound
			
//			new Experience();
			
//			if(oldPlayerLevel >= 0 && oldPlayerLevel <= 16) {
//				int level = config.getConfig().getInt(player + ".lvl");
//				int exp = config.getConfig().getInt(player + ".exp");
//				int s1 = level * level;
//				int s2 = 6 * level;
//				int newExp = s1 + s2;
//				
//				player.setExp(newExp);
//			}
		}
	}

}
