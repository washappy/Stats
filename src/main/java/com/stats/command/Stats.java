package com.stats.command;

import com.stats.Manager.FileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.stats.Manager.ArrayManager.playerData;
import static com.stats.Manager.FileManager.jsonFile;

public class Stats implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]){
        if (sender instanceof Player) {
            Player player = (Player) sender;

            String playername = player.getPlayer().getName();

            if (args.length == 1) {

                if ("info".equals(args[0])) {
                    player.sendMessage((playerData.get(player.getPlayer().getName())).info());
                }
                else if("save".equals(args[0])) {
                    FileManager.saveFile();
                    FileManager.saveList();
                    player.sendMessage("stats saved");
                }
                else if("jsoninfo".equals(args[0])) {
                    player.sendMessage(playerData.get(playername).toString());
                }
            }
            else if ("add".equals(args[0]) && Integer.valueOf(args[2]) instanceof Integer) {
                int num = Integer.valueOf(args[2]);
                switch (args[1]) {
                    case "strength":
                        player.sendMessage(args[1] + args[2]);
                        playerData.get(playername).addStrength(num);
                        break;
                    case "agility" :
                        player.sendMessage(args[1] + args[2]);
                        playerData.get(playername).addAgility(num);
                        break;
                    case "speed" :
                        player.sendMessage(args[1] + args[2]);
                        playerData.get(playername).addSpeed(num);
                        break;
                    case "health" :
                        player.sendMessage(args[1] + args[2]);
                        playerData.get(playername).addHealth(num);
                        break;
                    case "defense":
                        player.sendMessage(args[1] + args[2]);
                        playerData.get(playername).addDefense(num);
                        break;
                    case "luck" :
                        player.sendMessage(args[1] + args[2]);
                        playerData.get(playername).addLuck(num);
                        break;
                    case "handicraft" :
                        player.sendMessage(args[1] + args[2]);
                        playerData.get(playername).addHandicraft(num);
                        break;
                    case "attractive" :
                        player.sendMessage(args[1] + args[2]);
                        playerData.get(playername).addAttractive(num);
                        break;
                    default:
                        sender.sendMessage("오타난 커멘드");
                        break;
                }
                jsonFile.put(playername,playerData.get(playername).getMap());
            }

            else {
                sender.sendMessage("완전하지 않은 커멘드");
            }
            return true;
        }
        return false;
    }
}
