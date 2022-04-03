package com.stats.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.stats.Manager.ArrayManager.humanss;

public class AllTimePlayer implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]){
        if (sender instanceof Player) {
            if (args.length == 0) {
                Player player = (Player) sender;
                player.sendMessage(String.valueOf(humanss));
            } else {
                sender.sendMessage("완전하지 않은 커멘드");
            }
            return true;
        }
        return false;
    }
}