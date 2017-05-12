package de.luxa.boots;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Witch;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;

@SuppressWarnings("deprecation")
public class EVENTboots implements Listener{

	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(p.getInventory().getBoots() !=null && p.getInventory().getBoots().getType() != Material.AIR) {
			switch(p.getInventory().getBoots().getItemMeta().getDisplayName()) {
			case "§bWater-Boots":
				p.playEffect(p.getLocation().add(0, 1, 0), Effect.WATERDRIP, 1);
				break; 
			case"§cFire-Boots":
				p.playEffect(p.getLocation().add(0, 1, 0), Effect.LAVADRIP, 1);
				break;
			case "Cloud-Boots":
				p.playEffect(p.getLocation().add(0, 1, 0), Effect.CLOUD, 1);
				
				
				
				default:
					break; 
			}
		}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(e.getWhoClicked() instanceof Player) {
			Player p = (Player) e.getWhoClicked(); 
			
			if(e.getClickedInventory().getTitle().equalsIgnoreCase("6§lHexenboots-Shop")) {
				e.setCancelled(true);
				if(e.getCurrentItem().getType() !=Material.AIR && e.getCurrentItem() !=null ) {
					p.getInventory().setBoots(e.getCurrentItem());
				}
			}
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEntityEvent e) {
		if(e.getRightClicked() instanceof Witch) {
			Witch v = (Witch) e.getRightClicked();
			if(v.getCustomName().equalsIgnoreCase("§5§lLynix")) {
				e.setCancelled(true);
				e.getPlayer().openInventory(BootTrader.getBootInv()); 
			}
		}
	}
	
}
