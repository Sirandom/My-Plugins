package Me.MRANDOM.pp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Me.MRANDOM.pp.Main;

public class toggle implements CommandExecutor {

	
private Main plugin;
	
	public toggle(Main plugin) {
		plugin.getCommand("spidey").setExecutor(this);
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args ) {
		plugin.getServer().getName();
		Player player = (Player) sender;
		
		if(Main.spidey.contains(player.getUniqueId())) {
			player.sendMessage("No more spiderman powers huh, alright.");
			Main.spidey.remove(player.getUniqueId());
		}
		else {
			player.sendMessage("Alright heres that fat spider cock.");
			Main.spidey.add(player.getUniqueId());
		}
		
		return false;
	}
	
}
