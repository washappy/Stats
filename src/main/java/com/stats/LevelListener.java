package com.stats;

import com.stats.Humans.Human;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.jetbrains.annotations.NotNull;

import static com.stats.ArrayManager.humanss;
import static com.stats.ArrayManager.playerData;

public class LevelListener implements Listener {

    @EventHandler
    public void onLevelUp(@NotNull PlayerLevelChangeEvent e) {

        String playerName;
        playerName = e.getPlayer().getName();

        if (e.getNewLevel()>e.getOldLevel()) {
            for (int i =0; i < e.getNewLevel()-e.getOldLevel(); i++) {
                e.getPlayer().sendMessage(ChatColor.YELLOW + "Level Up!");
                Human hum = playerData.get(playerName).hLevelUp();
            }
        }
    }
}
