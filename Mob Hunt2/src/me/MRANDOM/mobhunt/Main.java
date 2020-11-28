package me.MRANDOM.mobhunt;

import java.util.HashMap;

import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

import me.MRANDOM.mobhunt.commands.MobHunt;
import me.MRANDOM.mobhunt.commands.setime;
import me.MRANDOM.mobhunt.commands.stop;
import me.MRANDOM.mobhunt.commands.timer;
import me.MRANDOM.mobhunt.stuff.Tabby;

public class Main extends JavaPlugin {
	
public HashMap<String, String> mobhunt = new HashMap<String, String>();

public Entity standee = null;
public Entity stando1 = null;
public Entity stando2 = null;

public String name1 = null;
public String name2 = null;

public int tf = 0;
public int P1 = 0;
public int P2 = 0;
public int T = 3600;

	@Override
	public void onEnable() {
		System.out.println("(!) Good job");
			new MobHunt(this);
			new timer(this);
			new stop(this);
			new setime(this);
			new Tabby(this);
	}
}