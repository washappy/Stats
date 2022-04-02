package com.stats;

import com.stats.Humans.Human;
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
        e.getPlayer().sendMessage(playerName);
        //playerData.put(playerName,playerData.get(playerName).hLevelUp());
        Human hum = playerData.get(playerName).hLevelUp();
        e.getPlayer().sendMessage(Integer.toString(hum.getLevel()));
        e.getPlayer().sendMessage(Integer.toString(playerData.get(playerName).getLevel()));
    }
}
