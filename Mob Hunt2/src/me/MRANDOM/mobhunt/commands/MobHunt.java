package me.MRANDOM.mobhunt.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import me.MRANDOM.mobhunt.Main;
import me.MRANDOM.mobhunt.stuff.goal;

public class MobHunt implements CommandExecutor {
	
	private Main plugin;
	
	public MobHunt(Main plugin) {
		plugin.getCommand("mhcreate").setExecutor(this);
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args ) {
		Player player = (Player) sender;
		
		List<String> players = new ArrayList<String>();
		 
		for(Player online : plugin.getServer().getOnlinePlayers()) {
		players.add(online.getName());
		}
		if (args.length == 0) {
			player.sendMessage(ChatColor.RED + "Usage: /mobhunt <player> <player>");
			return true;
		}
		if (args.length == 2) {
		
			if(args[0].equalsIgnoreCase(players.toString().replace("[", "").replace("]", "")) && 
					args[1].equalsIgnoreCase(players.toString().replace("[", "").replace("]", ""))) {
		
			plugin.getServer().broadcastMessage(ChatColor.AQUA+"Mobhunt goals are now here :)");
			
			Location loc = player.getLocation();
			loc.setY(loc.getY()-1);
			ArmorStand standee = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
			standee.setVisible(false);
			standee.setSmall(true);
			plugin.standee = standee;
			
			goal gaol = new goal();
			gaol.goal1(player, args, plugin);
			gaol.goal2(player, args, plugin);
			
			plugin.name1 = args[0];
			plugin.name2 = args[1];
			
			plugin.tf = 1;
			
			}
			else {
				player.sendMessage(ChatColor.RED + "not a valid name" + ChatColor.BOLD);
			}
		}
		else {
		player.sendMessage(ChatColor.RED + "You need two player names" + ChatColor.BOLD);
		}
		return false;
	}
}