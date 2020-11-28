package me.MRANDOM.mobhunt.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitScheduler;

import me.MRANDOM.mobhunt.Main;
import me.MRANDOM.mobhunt.stuff.OnGoal;

public class timer implements CommandExecutor {
	
	private Main plugin;
	
	public timer(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("mhstart").setExecutor(this);
	}
	
	
	public int task3;
	
	OnGoal ongoal = new OnGoal();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args ) {
		if(plugin.tf == 1) {
		
			plugin.getServer().broadcastMessage(ChatColor.AQUA+"Mobhunt started good luck!");
		
			ongoal.ongoal1(plugin);
			ongoal.ongoal2(plugin);
		
			BukkitScheduler sched = plugin.getServer().getScheduler();
			task3 = sched.scheduleSyncRepeatingTask(plugin, new Runnable() {
		
				int i = plugin.T;
		
				@Override
				public void run() {
					i--;
					ongoal.end(plugin, i);
				
						if(i == 0) {
							Bukkit.getServer().getScheduler().cancelTask(task3);
						}
				}}, 0L, 20L);
		}
		else {
			plugin.getServer().broadcastMessage(ChatColor.RED + "Yeah, um. you should have a goal first.");
		}
		return false;
	}
}