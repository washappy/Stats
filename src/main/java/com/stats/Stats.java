package com.stats;

import com.stats.Listeners.GuiListener;
import com.stats.Listeners.JoinListener;
import com.stats.Listeners.LevelListener;
import com.stats.Manager.ArrayManager;
import com.stats.Manager.FileManager;
import com.stats.command.AllTimePlayer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Stats extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("stats plugin activated");
        getCommands();
        registerEvents();
        FileManager.makeFile();
        FileManager.makeList();
        ArrayManager.putJson();
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("stats plugin deactivated");
        FileManager.makeFile();
        FileManager.makeList();
        FileManager.saveFile();
        FileManager.saveList();
    }

    private void getCommands() {
        Objects.requireNonNull(getCommand("stats")).setExecutor(new com.stats.command.Stats());
        Objects.requireNonNull(getCommand("alltime")).setExecutor(new AllTimePlayer());
    }

    private void registerEvents(){
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new LevelListener(), this);
        getServer().getPluginManager().registerEvents(new GuiListener(), this);
    }

}
