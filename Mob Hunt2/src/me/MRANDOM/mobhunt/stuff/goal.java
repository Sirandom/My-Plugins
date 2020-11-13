package me.MRANDOM.mobhunt.stuff;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import me.MRANDOM.mobhunt.Main;

public class goal {

	
	
	public void goal1(Player player, String[] args, Main plugin) {
		
	Location loc = player.getLocation();
	Location loc2 = player.getLocation();
	Location loc3 = player.getLocation();
	
	loc.setZ(loc.getZ()+8);
	loc.setY(loc.getY()-1);
	
		ArmorStand stande1 = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
		plugin.stando1 = stande1;
		stande1.setGravity(false);
		stande1.setVisible(false);
		stande1.setCustomName(args[0] + "("+plugin.P1+")");
		stande1.setCustomNameVisible(true);
		
	loc2.setX(loc2.getX()-2);
	loc2.setZ(loc2.getZ()+5);
	loc2.setY(loc2.getY()-1);
	
	for(int x = 0; x < 5; x++) {
		loc.setX(loc2.getX()+x);
		if(x!=0) {
			loc.getBlock().setType(Material.BEDROCK);
		}

		for(int z = 0; z < 6; z++) {
			loc.setZ(loc2.getZ()+z);
			if(z!=0) {
				loc.getBlock().setType(Material.BEDROCK);
			}
		
			for(int y = 0; y < 4; y++) {
				loc.setY(loc2.getY()-y);
				if(z!=0) {
				loc.getBlock().setType(Material.BEDROCK);
				}
			}
		}
	}
	
	loc3.setX(loc3.getX()-1);
	loc3.setZ(loc3.getZ()+6);
	loc3.setY(loc3.getY()-1);
	
	for(int x = 0; x < 3; x++) {
		loc.setX(loc3.getX()+x);
		if(x!=0) {
			loc.getBlock().setType(Material.AIR);
		}

		for(int z = 0; z < 4; z++) {
			loc.setZ(loc3.getZ()+z);
			if(z!=0) {
				loc.getBlock().setType(Material.AIR);
			}
		
			for(int y = 0; y < 3; y++) {
				loc.setY(loc3.getY()-y);
				if(z!=0) {
				loc.getBlock().setType(Material.AIR);
				}
			}
		}
	}
	
	return;
	}
	
	
	
	
	
	public void goal2(Player player, String[] args, Main plugin) {
		
		Location loc = player.getLocation();
		Location loc2 = player.getLocation();
		Location loc3 = player.getLocation();
		
		loc.setZ(loc.getZ()-8);
		loc.setY(loc.getY()-1);
			ArmorStand stande2 = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
			plugin.stando2 = stande2;
			stande2.setGravity(false);
			stande2.setVisible(false);
			stande2.setCustomName(args[1] + "("+plugin.P2+")");
			stande2.setCustomNameVisible(true);
			
		loc2.setX(loc2.getX()-2);
		loc2.setZ(loc2.getZ()-5);
		loc2.setY(loc2.getY()-1);
		
		for(int x = 0; x < 5; x++) {
			loc.setX(loc2.getX()+x);
			if(x!=0) {
				loc.getBlock().setType(Material.BEDROCK);
			}

			for(int z = 0; z < 6; z++) {
				loc.setZ(loc2.getZ()-z);
				if(z!=0) {
					loc.getBlock().setType(Material.BEDROCK);
				}
			
				for(int y = 0; y < 4; y++) {
					loc.setY(loc2.getY()-y);
					if(z!=0) {
					loc.getBlock().setType(Material.BEDROCK);
					}
				}
			}
		}
		
		loc3.setX(loc3.getX()-1);
		loc3.setZ(loc3.getZ()-6);
		loc3.setY(loc3.getY()-1);
		
		for(int x = 0; x < 3; x++) {
			loc.setX(loc3.getX()+x);
			if(x!=0) {
				loc.getBlock().setType(Material.AIR);
			}

			for(int z = 0; z < 4; z++) {
				loc.setZ(loc3.getZ()-z);
				if(z!=0) {
					loc.getBlock().setType(Material.AIR);
				}
			
				for(int y = 0; y < 3; y++) {
					loc.setY(loc3.getY()-y);
					if(z!=0) {
					loc.getBlock().setType(Material.AIR);
					}
				}
			}
		}
		
		return;
		
	}
	
}