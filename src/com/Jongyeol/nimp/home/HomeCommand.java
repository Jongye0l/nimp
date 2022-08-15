package com.Jongyeol.nimp.home;

import com.Jongyeol.Library.CheckSet.Other;
import com.Jongyeol.Library.prefix.Prefix;
import com.Jongyeol.nimp.Main;
import com.Jongyeol.nimp.data.UserDataManager;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.logging.Level;

public class HomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender Sender, Command command, String Cmd, String[] args) {
        if(Sender instanceof Player){
        } else {
            Sender.sendMessage(ChatColor.RED + "이 명령어는 플레이어만 사용할 수 있습니다.");
            return true;
        }
        Player player = (Player) Sender;
        if(player.hasPermission("nimp.home.other")){
            if(args.length < 1){
                teleportmyhome(player);
                return true;
            }
            OfflinePlayer target = Other.getOfflinePlayer(args[0]);
            if(target == null) {
                Sender.sendMessage(ChatColor.RED + "플레이어를 찾을 수 없습니다.");
                return true;
            }
            teleportotherhome(player, target);
            return true;
        }
        teleportmyhome(player);
        return true;
    }
    public void teleportmyhome(Player player){
        FileConfiguration config = UserDataManager.getConfig(player);
        String homestring = "home";
        if(config.contains(homestring)){
            World world = Bukkit.getWorld(config.getString("home.world"));
            if(world == null) {
                player.sendMessage(ChatColor.RED + "집이 없거나 사라진 월드에 저장되어 있습니다.");
                Main.main.getLogger().log(Level.SEVERE, player.getName() + "님에 집이 없거나 사라진 월드에 저장되어 있습니다.");
                return;
            }
            double x = config.getDouble("home.x");
            double y = config.getDouble("home.y");
            double z = config.getDouble("home.z");
            float yaw = (float) config.getDouble("home.yaw");
            float pitch = (float) config.getDouble("home.pitch");
            Location home = new Location(world, x, y, z, yaw, pitch);
            player.teleport(home);
            player.sendMessage(ChatColor.GREEN + "집으로 이동했습니다.");
            return;
        }
        player.sendMessage(ChatColor.RED + "설정된 집이 없습니다.");
    }
    public void teleportotherhome(Player player, OfflinePlayer target) {
        FileConfiguration config = UserDataManager.getViewConfig(target);
        if(config == null){
            player.sendMessage(ChatColor.RED + "플레이어를 찾을 수 없습니다.");
            return;
        }
        if(config.contains("home")){
            World world = Bukkit.getWorld(config.getString("home.world"));
            if(world == null) {
                player.sendMessage(ChatColor.RED + "해당 플레이어에 집이 없거나 사라진 월드에 저장되어있습니다.");
                return;
            }
            double x = config.getDouble("home.x");
            double y = config.getDouble("home.y");
            double z = config.getDouble("home.z");
            float yaw = (float) config.getDouble("home.yaw");
            float pitch = (float) config.getDouble("home.pitch");
            Location home = new Location(world, x, y, z, yaw, pitch);
            player.teleport(home);
            player.sendMessage(Prefix.getPrefix(target) + target.getName() + ChatColor.GREEN + "님 집으로 이동했습니다.");
            return;
        }
        player.sendMessage(ChatColor.RED + "해당 플레이어에 설정된 집이 없습니다.");
    }
}
