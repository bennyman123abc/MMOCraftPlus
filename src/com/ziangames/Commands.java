package com.ziangames;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {

	public Commands(PluginStart plugin) {
//		This registers this class file with PluginStart
//		DO NOT REMOVE ANY OF THIS AT ALL!!!!!
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
//		Code each command in this override
		
		if(cmd.getName().equalsIgnoreCase("test")) {
			sender.sendMessage("Test Successful!");
		}
		
		return false;
	}

}
