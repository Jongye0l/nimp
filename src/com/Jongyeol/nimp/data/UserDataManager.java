package com.Jongyeol.nimp.data;

import com.Jongyeol.nimp.Main;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class UserDataManager {
    private static ArrayList<UserData> datalist = new ArrayList<UserData>();
    private static Map<OfflinePlayer, UserData> dataMap = new HashMap<OfflinePlayer, UserData>();
    public static void OnJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        UserData userData = new UserData(player);
        dataMap.put(player, userData);
    }
    public static void ServerLoad() {
        for(Player player : Bukkit.getOnlinePlayers()){
            UserData userData = new UserData(player);
            dataMap.put(player, userData);
        }
    }
    public static void OnQuit(PlayerQuitEvent event){
        UserData userData = dataMap.get(event.getPlayer());
        if(userData == null){
            Main.main.getLogger().log(Level.SEVERE, event.getPlayer().getName() + "님에 데이터가 로딩되지 않았습니다.");
            return;
        }
        userData.SaveConfig();
        removeData(event.getPlayer(), userData);
    }
    public static FileConfiguration getConfig(OfflinePlayer player) {
        UserData userData = dataMap.get(player);
        if(userData == null){
            userData = new UserData(player);
            dataMap.put(player, userData);
        }
        return userData.getConfig();
    }
    public static FileConfiguration getViewConfig(OfflinePlayer player) {
        File folder = new File(Main.main.getDataFolder(), "userdata");
        File configFile = new File(folder, player.getUniqueId().toString() + ".yml");
        if (!configFile.exists()) {
            Main.main.getLogger().log(Level.INFO, player.getName() + "님에 데이터가 존재하지 않습니다.");
            return null;
        }
        return YamlConfiguration.loadConfiguration(configFile);
    }
    public static void SaveConfig(OfflinePlayer player) {
        UserData userData = dataMap.get(player);
        if(userData != null){
            userData.SaveConfig();
            if(!player.isOnline()) removeData(player, userData);
        }
    }
    public static void removeData(OfflinePlayer player, UserData userData) {
        dataMap.remove(player, userData);
    }
}
