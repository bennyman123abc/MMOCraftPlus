package com.ziangames;

import org.bukkit.Bukkit;

public class ConfigGen {
	
	PluginStart config;
	
	boolean cfgGen = config.getConfig().getBoolean("generated"); {
	
	if(cfgGen = true) {
//		getServer().getLogger().info("Plugin Config Already Generated. Moving On");
	}
	
	if(cfgGen = true) {
//		getServer().getLogger().info("Config Not Generated. Generating Config Now");
		
		int lvl = 1;
		
		while(lvl <= 16) {
			double equ = (lvl * lvl) + (6 * lvl);
			String cfglvl = String.valueOf(lvl);
			config.getConfig().set("levelValue" + cfglvl, equ);
			lvl++;
		}
		
		while(lvl >= 17 && lvl <= 31) {
			double square = Math.pow(lvl, 2);
			double equ = (2.5 * square) - (40.5 * lvl) + 360;
			String cfglvl = String.valueOf(lvl);
			config.getConfig().set("levelValue" + cfglvl, equ);
			lvl++;
		}
		
		Bukkit.getServer().getLogger().info("Config Generation Complete!");
		config.getServer().getLogger().info("Config Will Now Be Loaded Into Memory");
		config.getConfig().set("generated", true);
		config.saveConfig();
	}
}
}
	
