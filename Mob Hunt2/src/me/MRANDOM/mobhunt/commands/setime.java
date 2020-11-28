package me.MRANDOM.mobhunt.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.MRANDOM.mobhunt.Main;

public class setime implements CommandExecutor {

	
private Main plugin;
	
	public setime(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("mhtime").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args ) {
		
		Player player = (Player) sender;
		if(args.length == 1) {
			try {
				int t = Integer.parseInt(args[0]);
				plugin.T = t;
				
				player.sendMessage(ChatColor.GREEN + "Set mobhunt time to " + plugin.T + " seconds");
			}
				catch(NumberFormatException e) {
					player.sendMessage(ChatColor.RED + "next time put a number, god");
				}
			}
		if(args.length == 0 || args.length > 1) {
			player.sendMessage(ChatColor.RED + "Usage: /mhtime <seconds>");
		}
	return false;
	}
}