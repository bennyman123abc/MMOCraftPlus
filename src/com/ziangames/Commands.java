package com.ziangames;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

	public Commands(PluginStart plugin) {
//		This registers this class file with PluginStart
//		DO NOT REMOVE ANY OF THIS AT ALL!!!!!
	}
	
//	Init Config in this Class
	PluginStart config;

	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
//		Code each command in this override
		
//		if(cmd.getName().equalsIgnoreCase("test")) {
//			sender.sendMessage("Test Successful!");
//		}
		
		if(cmd.getName().equalsIgnoreCase("stats")) {
			
			int length = args.length;
			
			if(sender instanceof Player) {
				if(length == 0) {
					String p = args[0];
					String rpname = config.getConfig().getString(p + ".rpname");
//					Other stats need to be added later such as EXP, etc.
				}
			}
		}
		
		if(cmd.getName().equalsIgnoreCase("cname")) {
			
			Player p = (Player)sender;
			

			p.setDisplayName("test");

			p.setDisplayName("Test");

			
		}
		
		return false;
	}

}
