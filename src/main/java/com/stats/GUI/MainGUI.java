package com.stats.GUI;

import com.stats.Humans.Human;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import static com.stats.Manager.ArrayManager.playerData;
import static com.stats.Manager.ArrayManager.playerLocate;
import static com.stats.Manager.AttributeManager.setAttributes;

public class MainGUI extends GuiBase{
    private static final HashMap<Player, Integer> onPage = new HashMap<>();

    public MainGUI(@NotNull Player p) {

        super(p, 9, "info");
    }

    @Override
    protected void init(Player p) {

        onPage.putIfAbsent(p, 0);

        Human human = playerData.get(p.getPlayer().getName());
        /*for(int i=0;i<54;i++){
        *    setItem(" ",null,  Material.LIGHT_GRAY_STAINED_GLASS_PANE, 1, i, "stats.background", false);
        *}
        */

        setItem("현재 위치 저장", Collections.singletonList(""), Material.SLIME_BALL, 1, 2, "place.save", true);
        setItem("저장된 위치 불러오기", Collections.singletonList(""), Material.SNOWBALL, 1, 3, "place.load", true);
        setItem("스텟 창 열기", Collections.singletonList(""), Material.ENDER_EYE, 1, 4, "stats.info", true);
        setItem("스폰 위치 불러오기", Collections.singletonList(""), Material.MAGMA_CREAM, 1, 5, "spawn.load", true);
        setItem("추가 예정", Collections.singletonList(""), Material.FIRE_CHARGE, 1, 6, "aa", true);

        setItem("현재 페이지/새로고침",Arrays.asList("현재 페이지를 나타냅니다.", "눌러서 새로고침"),  Material.BEACON, 1, 0, "stats.reload", false);
        setItem("현재 페이지/닫기",Collections.singletonList("페이지 닫기"),  Material.BARRIER, 1, 8, "stats.close", false);
    }

    @Override
    public void onClick(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        String playerName = p.getPlayer().getName();
        e.setCancelled(true);
        String btn = getValue(e.getRawSlot());

        Human human = playerData.get(p.getPlayer().getName());

        if(btn==null) return;

        switch (btn){
            case "stats.info":
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5F, 1);
                new StatsGui(p);
                break;
            case "place.save":
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5F, 1);
                playerLocate.put(playerName,p.getLocation());
                new MainGUI(p);
                break;
            case "place.load":
                Location location = playerLocate.get(playerName);
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5F, 1);
                if (location!=null) p.sendMessage("x = " + location.getBlockX()+" y = " + location.getBlockY() + " z = " + location.getBlockZ());
                new MainGUI(p);
                break;
            case "spawn.load":
                Location location1 = p.getBedSpawnLocation();
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5F, 1);
                if (location1!=null) p.sendMessage("x = " + location1.getBlockX()+" y = " + location1.getBlockY() + " z = " + location1.getBlockZ());
                new MainGUI(p);
                break;
            case "stats.reload":
                new MainGUI(p);
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5F, 1);
                break;
            case "stats.close":
                this.forceCloseGUI(p);
                break;
            default:
                break;
        }
    }
}
