package com.example.whyhedisconnected;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class WhyHeDisconnected extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        String playerName = event.getPlayer().getName();
        PlayerQuitEvent.QuitReason reason = event.getReason();
        String message = playerName + " logged out " + reason;

        // Send message only to operators
        for (var player : Bukkit.getOnlinePlayers()) {
            if (player.isOp()) {
                player.sendMessage(message);
            }
        }
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent event) {
        String playerName = event.getPlayer().getName();
        String reason = event.getReason();
        String message = playerName + " was kicked: " + reason;

        // Send message only to operators
        for (var player : Bukkit.getOnlinePlayers()) {
            if (player.isOp()) {
                player.sendMessage(message);
            }
        }
    }
}