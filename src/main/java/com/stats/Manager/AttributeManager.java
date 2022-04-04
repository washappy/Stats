package com.stats.Manager;

import com.stats.Humans.Human;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

public class AttributeManager {

    public static void setAttributes(Player player, Human hum) {

        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20 + (hum.getHealth()-10));
        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.1+(hum.getSpeed()-10)/1000);
        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(2+(hum.getStrength()-10)/2);
        player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(4+(hum.getAgility()-10)/10);
        player.getAttribute(Attribute.GENERIC_LUCK).setBaseValue((hum.getLuck()-10)*10);
        player.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue((hum.getDefense()-10)/50);
    }

}
