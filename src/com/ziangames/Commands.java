package com.ziangames;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.bennyman123abc.*;

public class Commands implements CommandExecutor {

	public Commands(PluginStart plugin) {
//		This registers this class file with PluginStart
//		DO NOT REMOVE ANY OF THIS AT ALL!!!!!
	}
	
//	Init Config in this Class
	PluginStart config;

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
//		Code each command in this override
		
//		if(cmd.getName().equalsIgnoreCase("test")) {
//			sender.sendMessage("Test Successful!");
//		}
		
		int length = args.length;
		
		if(cmd.getName().equalsIgnoreCase("stats")) {
			
			if(sender instanceof Player) {
				if(length == 0) {
					String p = args[0];
					String rpname = config.getConfig().getString(p + ".rpname");
					if(rpname == "") {
//						Other stats need to be added later such as EXP, etc.
						sender.sendMessage("Current Roleplay Name: None");
					}
					
					else if(!(rpname == "")) {
						sender.sendMessage("Current Roleplay Name: " + rpname);
					}

				}
			}
		}
		
		if(cmd.getName().equalsIgnoreCase("cname")) {
			
			Player p = (Player)sender;
			

			p.setDisplayName("test");

			p.setDisplayName("Test");

			
		}
		
		if(cmd.getName().equalsIgnoreCase("mmocraftplus")) {
			if(length == 0) {
				sender.sendMessage("Well damn, that sucks. There's nothing here to display yet! And what also sucks is that the permission for this command isn't there!");
			}
			
			if(length == 1) {
				sender.sendMessage("Um.. The argument " + args[0] + " doesn't seem to be working yet. That's a bit embarassing...");
			}
			
			if(length == 2) {
				if(sender instanceof Player) {
					if(args[0] == "setname") {
						Player player = (Player)sender;
						boolean canChangeName = config.getConfig().getBoolean(player + ".canChangeName");
						if(canChangeName == true) {
							config.getConfig().set(player + ".rpname", args[1]);
							config.saveConfig();
							player.sendMessage(Colors.red + "");
						}
					}
				}
			}
		}
		
		return false;
	}
	

}
