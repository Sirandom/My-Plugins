package me.MRANDOM.mobhunt.stuff;

import org.bukkit.Location;
import org.bukkit.Material;

import me.MRANDOM.mobhunt.Main;

public class goalfin {

	public void goalfinna(Main plugin) {
		
	if(plugin.tf == 1) {
		Location loc = plugin.standee.getLocation();
		Location loc2 = plugin.standee.getLocation();
		Location loc3 = plugin.standee.getLocation();
		
		loc2.setX(loc2.getX()-2);
		loc2.setZ(loc2.getZ()+5);
		loc2.setY(loc2.getY());
		
		for(int x = 0; x < 5; x++) {
			loc.setX(loc2.getX()+x);
			if(x!=0) {
				loc.getBlock().setType(Material.GRASS_BLOCK);
			}

			for(int z = 0; z < 6; z++) {
				loc.setZ(loc2.getZ()+z);
				if(z!=0) {
					loc.getBlock().setType(Material.GRASS_BLOCK);
				}
			
				for(int y = 0; y < 4; y++) {
					loc.setY(loc2.getY()-y);
					if(z!=0) {
					loc.getBlock().setType(Material.GRASS_BLOCK);
					}
				}
			}
		}
		
		
				
			loc3.setX(loc3.getX()-2);
			loc3.setZ(loc3.getZ()-5);
			loc3.setY(loc3.getY());
			
			for(int x = 0; x < 5; x++) {
				loc.setX(loc3.getX()+x);
				if(x!=0) {
					loc.getBlock().setType(Material.GRASS_BLOCK);
				}

				for(int z = 0; z < 6; z++) {
					loc.setZ(loc3.getZ()-z);
					if(z!=0) {
						loc.getBlock().setType(Material.GRASS_BLOCK);
					}
				
					for(int y = 0; y < 4; y++) {
						loc.setY(loc3.getY()-y);
						if(z!=0) {
						loc.getBlock().setType(Material.GRASS_BLOCK);
						}
					}
				}
			}
			
		}
	}
}