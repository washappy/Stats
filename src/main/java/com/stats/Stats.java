package com.stats;

import com.stats.command.AllTimePlayer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

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
        Objects.requireNonNull(getCommand("stats")).setExecutor(new com.stats.command.Stats());
        Objects.requireNonNull(getCommand("alltime")).setExecutor(new AllTimePlayer());
    }

    private void registerEvents(){
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new LevelListener(), this);
    }

}
