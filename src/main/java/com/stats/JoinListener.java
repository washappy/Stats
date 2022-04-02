package com.stats;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static com.stats.ArrayManager.humanss;
import static com.stats.ArrayManager.playerData;

import com.stats.Humans.Human;
import org.jetbrains.annotations.NotNull;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(@NotNull PlayerJoinEvent e) {
        String playerName;
        playerName = e.getPlayer().getName();
        boolean contains = humanss.contains(playerName);
        if (contains) {
            //대충 json 에서 접속한 사람 스텟 불러오기
            //AttributeManager 로 스텟 적용
        } else {
            humanss.add(playerName);
            Human hum = new Human(playerName);
            playerData.put(playerName,hum);
            //AttributeManager

        }
    }

}
