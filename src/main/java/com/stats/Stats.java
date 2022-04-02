package com.stats;

import com.stats.command.AllTimePlayer;
import com.stats.command.Statsadd;
import com.stats.command.StatsInfo;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import com.stats.JoinListener;

import java.util.Objects;

import static com.stats.ArrayManager.playerData;

//import static com.stats.FileMaker.makeFile;

public final class Stats extends JavaPlugin {

    //public static HashMap<Player, Object>
    //private final File f = new File(getDataFolder(), "/data.txt");

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("stats plugin activated");
        getCommands();
        registerEvents();
        //makeFile(f);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("stats plugin deactivated");
    }

    private void getCommands() {
        Objects.requireNonNull(getCommand("statsadd")).setExecutor(new Statsadd());
        Objects.requireNonNull(getCommand("statsinfo")).setExecutor(new StatsInfo());
        Objects.requireNonNull(getCommand("alltime")).setExecutor(new AllTimePlayer());
    }

    private void registerEvents(){
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new LevelListener(), this);
    }

}
