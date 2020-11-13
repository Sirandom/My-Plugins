package Me.MRANDOM.pp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.plugin.java.JavaPlugin;

import Me.MRANDOM.pp.commands.toggle;
import Me.MRANDOM.pp.commands.weiner;

	public class Main extends JavaPlugin {
	
		public static List<UUID> spidey = new ArrayList<UUID>();
		
		@Override
		public void onEnable() {
	
			System.out.println("sup");
				new weiner(this);
				new toggle(this);
	}
}