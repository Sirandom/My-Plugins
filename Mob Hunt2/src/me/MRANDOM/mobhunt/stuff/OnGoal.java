package me.MRANDOM.mobhunt.stuff;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitScheduler;

import me.MRANDOM.mobhunt.Main;



public class OnGoal {

	public int task1;
	public int task2;
	
	public void end(Main plugin, int i) {
		
		if(i == 0) {
			
			Bukkit.getServer().getScheduler().cancelTasks(plugin);
			
			if(plugin.P1 > plugin.P2) {
				plugin.getServer().broadcastMessage(ChatColor.BOLD + plugin.name1 + ChatColor.BOLD + ChatColor.GREEN + " has won with a total of " + ChatColor.BOLD + ChatColor.WHITE + plugin.P1 + " points!");
			}
			if(plugin.P1 < plugin.P2) {
				plugin.getServer().broadcastMessage(ChatColor.BOLD + plugin.name2 + ChatColor.BOLD + ChatColor.GREEN + " has won with a total of " + ChatColor.BOLD + ChatColor.WHITE + plugin.P2 + " points!");
			}
			if(plugin.P1 == plugin.P2) {
				plugin.getServer().broadcastMessage(ChatColor.GOLD + "It's a tie!");
			}
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
	}

	public void ongoal1(Main plugin) {
		
	BukkitScheduler sched = plugin.getServer().getScheduler();
	task1 = sched.scheduleSyncRepeatingTask(plugin, new Runnable() {

		double radius = 1.0; 
		
		@Override
		public void run() {
		
			List<Entity> nearby = plugin.stando1.getNearbyEntities(radius, radius, radius);
			
			
				 for (Entity entity : nearby) {
			            if(entity instanceof Creature) {
			            	entity.remove();
			            	
			            		if(plugin.mobhunt.get(entity.getType().toString()) == plugin.name1) {
			            			plugin.P1 = Math.addExact(plugin.P1, 1);
			            			
			            		}
			            		else {
			            			plugin.P1 = Math.addExact(plugin.P1, 5);
			            			
			            	}
			            		String nig = Integer.toString(plugin.P1);
			            	plugin.mobhunt.put(entity.getType().toString(), plugin.name1);
			            	plugin.getServer().broadcastMessage(ChatColor.BOLD + plugin.name1 + ChatColor.BOLD + ChatColor.GREEN + " now has " + nig + " points!");
			            	plugin.stando1.setCustomName(plugin.name1 + "("+plugin.P1+")");
			            	
			      }
			
		}
	}
		
		
		},0L , 1L);
	return;
	}
	public void ongoal2(Main plugin) {
		
		BukkitScheduler sched = plugin.getServer().getScheduler();
		task2 = sched.scheduleSyncRepeatingTask(plugin, new Runnable() {

			double radius = 1.0; 
			
			@Override
			public void run() {
			
				List<Entity> nearby = plugin.stando2.getNearbyEntities(radius, radius, radius);
				
					 for (Entity entity : nearby) {
				            if(entity instanceof Creature) {
				            	entity.remove();
				            	
				            		if(plugin.mobhunt.get(entity.getType().toString()) == plugin.name2) {
				            			plugin.P2 = Math.addExact(plugin.P2, 1);
				            		
				            		}
				            		else {
				            			plugin.P2 = Math.addExact(plugin.P2, 5);
				            			
				            	}
				            		String nig = Integer.toString(plugin.P2);
				            	plugin.mobhunt.put(entity.getType().toString(), plugin.name2);
				            	plugin.getServer().broadcastMessage(ChatColor.BOLD + plugin.name2 + ChatColor.BOLD + ChatColor.GREEN + " now has " + nig + " points!");
				            	plugin.stando2.setCustomName(plugin.name2 + "("+plugin.P2+")");
				           }
				
			}
		}
			
			
			},0L , 1L);
		return;
		}
}