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

            List<String> arrayList = new ArrayList<>(5);

            arrayList.add("info");
            arrayList.add("save");
            arrayList.add("help");
            arrayList.add("open");
            arrayList.add("add");

            return arrayList;
        } else if (args.length == 2 && "add".equals(args[0])) {
            List<String> arrayList = new ArrayList<>();
            arrayList.add("agility");
            arrayList.add("attractive");
            arrayList.add("defense");
            arrayList.add("handicraft");
            arrayList.add("health");
            arrayList.add("luck");
            arrayList.add("speed");
            arrayList.add("strength");

            return arrayList;
        }

        return null;
    }
}