package com.stats.command;

import com.stats.GUI.StatsGui;
import com.stats.Manager.FileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.stats.Manager.ArrayManager.playerData;

public class AutoTab implements TabCompleter {

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {

        Player player = (Player) sender;
        String playername = player.getPlayer().getName();

        if (args.length == 1) {

            if ("info".equals(args[0])) {
                player.sendMessage((playerData.get(player.getPlayer().getName())).info());
            }
            else if("save".equals(args[0])) {
                saveFile(player);
            }
            else if("help".equals(args[0])) {
                statsHelp(player);
            }
            else if("open".equals(args[0])) {
                new StatsGui(player);
            }
            ArrayList<String> arrayList = new ArrayList<>(4);
            arrayList.add("info");
            arrayList.add("save");
            arrayList.add("help");
            arrayList.add("open");
            return arrayList;
        }

        return null;
    }

    private void statsHelp(Player player) {
        player.sendMessage("\n================");
        player.sendMessage("/stats info : 스텟 정보 보기");
        player.sendMessage("/stats add <스텟이름> <값> : 스텟 더하기");
        player.sendMessage("/stats save : 스텟 수동 저장");
        player.sendMessage("/stats help : 스텟 정보 보기");
        player.sendMessage("================");
    }

    private void saveFile(Player player) {
        FileManager.makeFile();
        FileManager.makeList();
        FileManager.saveFile();
        FileManager.saveList();
        player.sendMessage("stats saved");
    }
}
