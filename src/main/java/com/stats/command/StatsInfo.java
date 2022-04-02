package com.stats.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.stats.ArrayManager.playerData;

public class StatsInfo implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]){
        if (sender instanceof Player) {
            if (args.length == 0) {
                Player player = (Player) sender;
                player.sendMessage((playerData.get(player.getPlayer().getName())).info());
            } else {
                sender.sendMessage("완전하지 않은 커멘드");
            }
            return true;
        }
        return false;
    }
}
