package Me.MRANDOM.pp.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import Me.MRANDOM.pp.Main;

public class weiner implements Listener {
	
	private Main plugin;
	
	public weiner(Main plugin) {
		Bukkit.getPluginManager().registerEvents(this, plugin);
		this.plugin = plugin;
	}
	
	Map<String, Long> cooldown = new HashMap<String, Long>();
	Map<String, Long> cool = new HashMap<String, Long>();
	
	@EventHandler
	public void onClick(PlayerInteractEvent event) {
		if(event.getAction() == Action.RIGHT_CLICK_AIR) {
			Player player = (Player) event.getPlayer();
			if(Main.spidey.contains(player.getUniqueId())) {
			
			Material mhand = player.getInventory().getItemInMainHand().getType();
			Material ohand = player.getInventory().getItemInOffHand().getType();
			
			List<Material> mat = new ArrayList<Material>(Arrays.asList(Material.BOW, Material.CROSSBOW, Material.TRIDENT,
			Material.FISHING_ROD, Material.SHIELD, Material.SNOWBALL, Material.EGG));
		
			if(mat.contains(mhand) || mat.contains(ohand) || mhand.isEdible() || ohand.isEdible())  {
			return;
			}
			
				if (cooldown.containsKey(player.getName())) {
					if(cooldown.get(player.getName()) > System.currentTimeMillis()) {
					
						return;
					}
				}
			
			cooldown.put(player.getName(), System.currentTimeMillis() + (8 * 100));
			
			Location loc = event.getPlayer().getLocation();
			Vector di = loc.getDirection();
				
				Arrow arrow = (Arrow) player.launchProjectile(Arrow.class);
				arrow.setGravity(false);
				arrow.setSilent(true);
				Vector sped = arrow.getVelocity();
				Bat bat = (Bat) loc.getWorld().spawnEntity(loc, EntityType.BAT);
				bat.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 200, 1, true, false));
				bat.setAI(false);
				bat.setLeashHolder(player);
				bat.setSilent(true);
			
				BukkitScheduler sched = player.getServer().getScheduler();
				
				sched.scheduleSyncRepeatingTask(this.plugin, new Runnable() {

					int i = 0;
					
					@Override
					public void run() {
						i++;
							bat.teleport(arrow);
							if(arrow.isInBlock()) {
								
								cool.put(player.getName(), System.currentTimeMillis() + (25 * 100));
								player.getServer().getScheduler().cancelTasks(plugin);
								player.setVelocity(di.add(sped));
								arrow.remove();
								bat.remove();
								
								player.playSound(loc, Sound.ENTITY_MAGMA_CUBE_JUMP, 75, 1);
								
								cooldown.clear();
							}
							if(arrow.isDead()) {
								bat.remove();
							}
							if(i == 15) {
								player.getServer().getScheduler().cancelTasks(plugin);
								arrow.remove();
								bat.remove();
							}
							
						}},0L , 1L);
			}
		}
	}	
	@EventHandler
	public void hit(ProjectileHitEvent event) {
		Entity e = event.getHitEntity();
		Player player = (Player) event.getEntity().getShooter();
		Arrow arrow = (Arrow) event.getEntity();
		e.teleport(player);
		arrow.remove();
	}
	@EventHandler
	public void onFall(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			if(event.getCause() == DamageCause.FALL) {
				if (cool.containsKey(player.getName())) {
					if(cool.get(player.getName()) > System.currentTimeMillis()) {
						float fall = player.getFallDistance();
							event.setCancelled(true);
						if(fall > 3 && fall < 10) {
							player.damage(1);
							return;
						}
						if(fall > 10 && fall < 20) {
							player.damage(2);
							return;
						}
						if(fall > 20 && fall < 30) {
							player.damage(3);
							return;
						}
						else {
							player.damage(4);
							return;
						}
						
					}
				}
		
			}
		}
		
	}
}