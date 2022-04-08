package com.stats.Listeners;

import com.stats.GUI.MainGUI;
import com.stats.GUI.StatsGui;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class RightClickListenter implements Listener {
    @EventHandler
    public void rightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action a = e.getAction();

        if (a==Action.RIGHT_CLICK_AIR||a==Action.RIGHT_CLICK_BLOCK) {
            if (p.getItemInHand().getType()== Material.BOOK) {
                new MainGUI(p);
            }
        }
    }
}
