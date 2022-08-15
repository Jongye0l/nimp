package com.Jongyeol.nimp.data;

import com.Jongyeol.nimp.Main;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class UserData {
    private final File folder;
    private final File configFile;
    private final OfflinePlayer player;
    private FileConfiguration config;
    public UserData(Player player){
        this.player = player;
        folder = new File(Main.main.getDataFolder(), "userdata");
        if (!folder.exists()){
            folder.mkdirs();
        }
        configFile = new File(folder, player.getUniqueId().toString() + ".yml");
        if (!configFile.exists()) {
            Main.main.getLogger().log(Level.INFO, player.getName() + "님에 데이터를 생성합니다...");
            try {
                configFile.createNewFile();
                Main.main.getLogger().log(Level.INFO, player.getName() + "님에 데이터를 생성하였습니다.");
            } catch (IOException e) {
                Main.main.getLogger().log(Level.SEVERE, player.getName() + "님에 데이터를 생성할 수 없습니다.\n" + e);
                player.kickPlayer(ChatColor.RED + "데이터를 생성할 수 없습니다. 서버 운영자나 플러그인 개발자에게 문의하세요.");
                return;
            }
        }
        config = YamlConfiguration.loadConfiguration(configFile);
        config.set("name", player.getName());
        config.set("lastIp", player.getServer().getIp());
        SaveConfig();
    }
    public UserData(OfflinePlayer player){
        this.player = player;
        folder = new File(Main.main.getDataFolder(), "userdata");
        configFile = new File(folder, player.getUniqueId().toString() + ".yml");
        if (!configFile.exists()) {
            Main.main.getLogger().log(Level.INFO, player.getName() + "님에 데이터가 존재하지 않습니다.");
            UserDataManager.removeData(player, this);
            return;
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }
    public OfflinePlayer getPlayer() {
        return player;
    }
    public FileConfiguration getConfig() {
        return config;
    }
    public void SaveConfig() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            Main.main.getLogger().log(Level.SEVERE, player.getName() + "님에 데이터가 저장되지 않았습니다.");
        }
    }
}
