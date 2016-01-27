package com.ziangames;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.bennyman123abc.Colors;

public class Commands implements CommandExecutor {

	public Commands(PluginStart plugin) {
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
			
			sender.sendMessage(ErrorMessages.removed);
			
//			Player p = (Player)sender;
//			
//
//			p.setDisplayName("test");
//
//			p.setDisplayName("Test");

			
		}
		
		if(cmd.getName().equalsIgnoreCase("mmocraftplus")) {
			if(length == 0) {
				sender.sendMessage(Colors.darkRed + ErrorMessages.todo);
			}
			
			if(length == 1) {
				sender.sendMessage(ErrorMessages.noArg);
			}
			
			if(length == 2) {
				if(sender instanceof Player) {
					if(args[0] == "setname") {
						Player player = (Player)sender;
						boolean canChangeName = config.getConfig().getBoolean(player + ".canChangeName");
						if(canChangeName == true) {
							config.getConfig().set(player + ".rpname", args[1]);
							config.saveConfig();
							player.sendMessage(Colors.gold + "Your Roleplay name has been changed to " + args[1]);
							return true;
						}
						if(canChangeName == false) {
							player.sendMessage(Colors.darkRed + "You cannot change your name right now!");
							return true;
						}
					}
					
					else if(args[0] == "setexp") {
						Player player = (Player)sender;
						if(!player.hasPermission(PluginStart.admin)) {
							player.sendMessage(Colors.darkRed + ErrorMessages.noPerm);
							Logger.getLogger(player.getName() + " has tried to set their EXP without permission!");
							return true;
						}
						else if(player.hasPermission(PluginStart.admin)) {
							player.sendMessage(Colors.darkRed + ErrorMessages.todo);
						}
					}
				}
			}
		}
		
		return false;
	}
	

}
