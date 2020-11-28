package me.MRANDOM.mobhunt.stuff;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import me.MRANDOM.mobhunt.Main;

public class Tabby implements TabCompleter {

	private Main plugin;
	
	public Tabby(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("mhcreate").setTabCompleter(this);
	}
	
		List<String> arguments = new ArrayList<String>();
	
		public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args ) {
			
			if(arguments.isEmpty()) {
				List<String> players = new ArrayList<String>();
				 
				for(Player online : plugin.getServer().getOnlinePlayers()) {
				players.add(online.getName());
				}
			arguments.add(players.toString().replace("[", "").replace("]", ""));
			
			}
			List<String> result1 = new ArrayList<String>();
			if(args.length == 1) {
				for (String a : arguments) {
					if(a.toLowerCase().startsWith(args[0].toLowerCase()))
						result1.add(a);
				}
				return result1;
			}
			
			List<String> result2 = new ArrayList<String>();
			if(args.length == 2) {
				for (String a : arguments) {
					if(a.toLowerCase().startsWith(args[1].toLowerCase()))
						result2.add(a);
				}
				return result2;
			}
			
			return null;
		}
}