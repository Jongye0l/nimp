package com.Jongyeol.nimp.spawn;

import com.Jongyeol.nimp.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

public class Spawn {
    public static Location getSpawn(){
        Configuration config = Main.main.getConfig();
        if(config.contains("spawn")) {
            World world = Bukkit.getWorld(config.getString("spawn.world"));
            if (world == null) {
                for (Player player2 : Bukkit.getOnlinePlayers()) {
                    if (player2.isPermissionSet("nimp.setspawn")) {
                        player2.sendMessage(ChatColor.RED + "스폰에 문제가 발생했습니다. 스폰을 다시 지정해주세요.");
                    }
                }
                return null;
            }
            double x = config.getDouble("spawn.x");
            double y = config.getDouble("spawn.y");
            double z = config.getDouble("spawn.z");
            float yaw = (float) config.getDouble("spawn.yaw");
            float pitch = (float) config.getDouble("spawn.pitch");
            return new Location(world, x, y, z, yaw, pitch);
        }
        World world = Bukkit.getWorld("world");
        if(world == null) {
            for(Player player2 : Bukkit.getOnlinePlayers()){
                if(player2.isPermissionSet("nimp.setspawn")){
                    player2.sendMessage(ChatColor.RED + "스폰에 문제가 발생했습니다. 스폰을 다시 지정해주세요.");
                }
            }
            return null;
        }
        for(Player player2 : Bukkit.getOnlinePlayers()){
            if(player2.isPermissionSet("nimp.setspawn")){
                player2.sendMessage(ChatColor.RED + "스폰이 설정되어있지 않습니다. 스폰을 설정해주세요.");
            }
        }
        return Bukkit.getWorld("world").getSpawnLocation();
    }
}
