package me.MRANDOM.mobhunt.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.MRANDOM.mobhunt.Main;
import me.MRANDOM.mobhunt.stuff.goalfin;

public class stop implements CommandExecutor {
	
	private Main plugin;
	
	public stop(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("mhstop").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args ) {
		Player player = (Player) sender;
		if(plugin.tf == 1) {
			
			Bukkit.getServer().getScheduler().cancelTasks(plugin);
		
			goalfin goalpp = new goalfin();
			goalpp.goalfinna(plugin);
			
			plugin.mobhunt.clear();
		
			plugin.standee.remove();
			plugin.stando1.remove();
			plugin.stando2.remove();
		
			plugin.tf = 0;
			plugin.P1 = 0;
			plugin.P2 = 0;
		
		}
		else {
			player.sendMessage(ChatColor.RED + "Cant stop something that hasnt started.");
		}
		return false;
	}
}