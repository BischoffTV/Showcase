package org.bischoff.showcase;

import com.plotsquared.core.PlotAPI;
import com.plotsquared.core.player.PlotPlayer;
import com.plotsquared.core.plot.Plot;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.Dispenser;
import org.bukkit.block.Dropper;
import org.bukkit.block.Hopper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.java.JavaPlugin;

public class Showcase extends JavaPlugin implements Listener {

    private PlotAPI plotAPI;

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.plotAPI = new PlotAPI();
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();

        if (block.getType() == Material.TRAPPED_CHEST || block.getType() == Material.HOPPER || block.getType() == Material.DROPPER || block.getType() == Material.DISPENSER || block.getType() == Material.CHEST) {
            PlotPlayer<Player> plotPlayer = PlotPlayer.from(player);
            Plot plot = plotPlayer.getCurrentPlot();

            if (plot != null && plot.getOwners().contains(player.getUniqueId())) {
                if (block.getState() instanceof Chest) {
                    Chest chest = (Chest) block.getState();
                    if ("Showcase".equals(chest.getCustomName())) {
                        chest.update();
                    }
                } else if (block.getState() instanceof Hopper) {
                    Hopper hopper = (Hopper) block.getState();
                    if ("Showcase".equals(hopper.getCustomName())) {
                        hopper.update();
                    }
                } else if (block.getState() instanceof Dropper) {
                    Dropper dropper = (Dropper) block.getState();
                    if ("Showcase".equals(dropper.getCustomName())) {
                        dropper.update();
                    }
                } else if (block.getState() instanceof Dispenser) {
                    Dispenser dispenser = (Dispenser) block.getState();
                    if ("Showcase".equals(dispenser.getCustomName())) {
                        dispenser.update();
                    }
                }
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();

        if (block.getType() == Material.TRAPPED_CHEST || block.getType() == Material.HOPPER || block.getType() == Material.DROPPER || block.getType() == Material.DISPENSER || block.getType() == Material.CHEST) {
            PlotPlayer<Player> plotPlayer = PlotPlayer.from(player);
            Plot plot = plotPlayer.getCurrentPlot();

            if (plot != null && !plot.getOwners().contains(player.getUniqueId())) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            InventoryHolder holder = event.getInventory().getHolder();

            if (holder instanceof Chest || holder instanceof Hopper || holder instanceof Dropper || holder instanceof Dispenser) {
                String customName = null;
                if (holder instanceof Chest) {
                    customName = ((Chest) holder).getCustomName();
                } else if (holder instanceof Hopper) {
                    customName = ((Hopper) holder).getCustomName();
                } else if (holder instanceof Dropper) {
                    customName = ((Dropper) holder).getCustomName();
                } else if (holder instanceof Dispenser) {
                    customName = ((Dispenser) holder).getCustomName();
                }

                if ("Showcase".equals(customName)) {
                    PlotPlayer<Player> plotPlayer = PlotPlayer.from(player);
                    Plot plot = plotPlayer.getCurrentPlot();

                    if (plot != null && !plot.getOwners().contains(player.getUniqueId())) {
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}