package com.Jongyeol.nimp.cmdspy;

import com.Jongyeol.nimp.data.UserDataManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class CmdspyJoin {
    public static void OnJoin(PlayerJoinEvent event){
        FileConfiguration config = UserDataManager.getConfig(event.getPlayer());
        if(config.contains("cmdspy")) {
            CmdspyMessage.cmdspy(event.getPlayer(), config.getBoolean("cmdspy"));
        }
    }
    public static void ServerLoad() {
        for(Player player : Bukkit.getOnlinePlayers()){
            FileConfiguration config = UserDataManager.getConfig(player);
            if(config.contains("cmdspy")) {
                CmdspyMessage.cmdspy(player, config.getBoolean("cmdspy"));
            }
        }
    }
    public static void OnQuit(PlayerQuitEvent event){
        CmdspyMessage.cmdspy(event.getPlayer(), false);
    }
}
