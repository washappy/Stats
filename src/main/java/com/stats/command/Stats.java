package com.stats.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.stats.ArrayManager.playerData;

public class Stats implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]){
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 1) {

                if ("info".equals(args[0])) {
                    player.sendMessage((playerData.get(player.getPlayer().getName())).info());
                }

            }
            else if ("add".equals(args[0]) && Integer.valueOf(args[2]) instanceof Integer) {
                switch (args[1]) {
                    case "strength":
                        playerData.get(player.getPlayer().getName()).addStrength(Integer.valueOf(args[1]));
                        break;
                    case "agility" :
                        playerData.get(player.getPlayer().getName()).addAgility(Integer.valueOf(args[1]));
                        break;
                    case "speed" :
                        playerData.get(player.getPlayer().getName()).addSpeed(Integer.valueOf(args[1]));
                        break;
                    case "health" :
                        playerData.get(player.getPlayer().getName()).addHealth(Integer.valueOf(args[1]));
                        break;
                    case "defense":
                        playerData.get(player.getPlayer().getName()).addDefense(Integer.valueOf(args[1]));
                        break;
                    case "luck" :
                        playerData.get(player.getPlayer().getName()).addLuck(Integer.valueOf(args[1]));
                        break;
                    case "handicraft" :
                        playerData.get(player.getPlayer().getName()).addHandicraft(Integer.valueOf(args[1]));
                        break;
                    case "attractive" :
                        playerData.get(player.getPlayer().getName()).addAttractive(Integer.valueOf(args[1]));
                        break;
                    default:
                        sender.sendMessage("오타난 커멘드");
                        break;
                }
            }

            else {
                sender.sendMessage("완전하지 않은 커멘드");
            }
            return true;
        }
        return false;
    }

}
