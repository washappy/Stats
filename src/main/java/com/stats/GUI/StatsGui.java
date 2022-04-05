package com.stats.GUI;

import com.stats.Humans.Human;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import static com.stats.Manager.ArrayManager.playerData;


public class StatsGui extends GuiBase{

    private static final HashMap<Player, Integer> onPage = new HashMap<>();

    public StatsGui(@NotNull Player p) {

        super(p, 54, "Stats");
    }

    @Override
    protected void init(Player p) {

        onPage.putIfAbsent(p, 0);
        int page = onPage.get(p);

        Human human = playerData.get(p.getPlayer().getName());
        for(int i=0;i<54;i++){
            setItem(" ",null,  Material.LIGHT_GRAY_STAINED_GLASS_PANE, 1, i, "stats.background", false);
        }
        for(int i=0;i<9;i++){
            setItem(" ",null,  Material.BLACK_STAINED_GLASS_PANE, 1, i, "stats.background", false);
        }
        for(int i=9;i<45;i+=9){
            setItem(" ",null,  Material.BLACK_STAINED_GLASS_PANE, 1, i, "stats.background", false);
        }
        for(int i=8;i<45;i+=9){
            setItem(" ",null,  Material.BLACK_STAINED_GLASS_PANE, 1, i, "stats.background", false);
        }

        setItem("힘 strength", Collections.singletonList(""+human.getStrength()), Material.RED_STAINED_GLASS_PANE, 1, 12, "stats.strength", true);
        setItem("신속 speed", Collections.singletonList(""+human.getSpeed()), Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, 14, "stats.speed", true);
        setItem("민첩 agility",Collections.singletonList(""+human.getAgility()),  Material.BLUE_STAINED_GLASS_PANE, 1, 20, "stats.agility", true);
        setItem("체력 health",Collections.singletonList(""+human.getHealth()),  Material.PINK_STAINED_GLASS_PANE, 1, 24, "stats.health", true);
        setItem("방어 defense",Collections.singletonList(""+human.getDefense()),  Material.GREEN_STAINED_GLASS_PANE, 1, 38, "stats.defense", true);
        setItem("행운 luck",Collections.singletonList(""+human.getLuck()),  Material.YELLOW_STAINED_GLASS_PANE, 1, 42, "stats.luck", true);
        setItem("손재주 handicraft",Collections.singletonList(""+human.getHandicraft()),  Material.MAGENTA_STAINED_GLASS_PANE, 1, 48, "stats.handicraft", true);
        setItem("매력 attractive",Collections.singletonList(""+human.getAttractive()),  Material.PURPLE_STAINED_GLASS_PANE, 1, 50, "stats.attractive", true);

        setItem("현재 페이지/새로고침",Arrays.asList("현재 페이지를 나타냅니다.", "눌러서 새로고침"),  Material.BEACON, page+1, 45, "stats.reload", false);
        setItem("현재 페이지/닫기",Collections.singletonList("페이지 닫기"),  Material.BARRIER, 1, 53, "stats.close", false);
    }

    @Override
    public void onClick(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);
        String btn = getValue(e.getRawSlot());

        Human human = playerData.get(p.getPlayer().getName());

        if(btn==null) return;

        switch (btn){
            case "stats.strength":
                human.addStrength(1);
                break;
            case "stats.health":
                human.addHealth(1);
                break;
            case "stats.agility":
                human.addAgility(1);
                break;
            case "stats.speed":
                human.addSpeed(1);
                break;
            case "stats.luck":
                human.addLuck(1);
                break;
            case "stats.defense":
                human.addDefense(1);
                break;
            case "stats.handicraft":
                human.addHandicraft(1);
                break;
            case "stats.attractive":
                human.addAttractive(1);
                break;
            case "stats.reload":
                new StatsGui(p);
                break;
            default:
                break;
        }
    }
}