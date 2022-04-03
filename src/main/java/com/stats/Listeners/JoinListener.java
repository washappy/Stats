package com.stats.Listeners;

import com.stats.Manager.FileManager;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static com.stats.Manager.ArrayManager.humanss;
import static com.stats.Manager.ArrayManager.playerData;
import static com.stats.Manager.FileManager.jsonFile;
import static com.stats.Manager.FileManager.jsonList;

import com.stats.Humans.Human;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(@NotNull PlayerJoinEvent e) {
        String playerName;
        playerName = e.getPlayer().getName();
        e.setJoinMessage((ChatColor.WHITE + "앗! 야생의 ") + (ChatColor.YELLOW + playerName) + (ChatColor.WHITE + "(이)가 들어왔다!"));
        boolean contains = humanss.contains(playerName);
        if (contains) {
            //Human hum1 = new Human(playerName, jsonFile.get(playerName));
            //playerData.put(playerName,hum1);
            //AttributeManager 로 스텟 적용
        } else {
            Human hum = new Human(playerName);
            humanss.add(playerName);
            playerData.put(playerName,hum);

            jsonList.add(playerName);
            jsonFile.put(playerName,hum.getMap());
            //AttributeManager
        }
    }

}
