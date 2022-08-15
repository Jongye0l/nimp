package com.Jongyeol.nimp;

import com.Jongyeol.nimp.AutoSave.AutoSave;
import com.Jongyeol.nimp.cmdspy.CmdspyJoin;
import com.Jongyeol.nimp.data.UserDataManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class Main extends JavaPlugin {
    public static Main main;
    private CommandManager commandManager;
    @Override
    public void onEnable(){
        main = this;
        saveDefaultConfig();
        commandManager = new CommandManager(this);
        commandManager.SetupCommand();
        new AutoSave().runTaskTimer(this, 0L, 6000L);
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        final Plugin JongyeolLibrary = Bukkit.getPluginManager().getPlugin("JongyeolLibrary");
        if(JongyeolLibrary == null){
            getLogger().log(Level.SEVERE, "JongyeolLibrary 플러그인이 감지되지 않았습니다.");
            Bukkit.getPluginManager().disablePlugin(this);
        } else {
            String version = JongyeolLibrary.getDescription().getVersion();
            String[] versions = version.split("\\.");
            boolean a = true;
            if(Integer.parseInt(versions[0]) < 1){
                a = false;
            } else if(Integer.parseInt(versions[1]) < 3){
                a = false;
            } else if (Integer.parseInt(versions[2]) < 0) {
                a = false;
            }
            if(!a){
                getLogger().log(Level.SEVERE, "JongyeolLibrary 플러그인에 버전이 지원하지 않는 버전입니다. 업데이트를 해주세요!");
                Bukkit.getPluginManager().disablePlugin(this);
            }
        }
        UserDataManager.ServerLoad();
        CmdspyJoin.ServerLoad();
    }
}
