package com.Jongyeol.nimp.home;

import com.Jongyeol.Library.prefix.Prefix;
import com.Jongyeol.nimp.data.UserDataManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SethomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender Sender, Command command, String Cmd, String[] args) {
        if(Sender instanceof Player){
        } else {
            Sender.sendMessage(ChatColor.RED + "이 명령어는 플레이어만 사용할 수 있습니다.");
            return true;
        }
        Player player = (Player) Sender;
        if(player.hasPermission("nimp.sethome.other")){
            if(args.length < 1){
                setmyhome(player);
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);
            if(target == null){
                Sender.sendMessage(ChatColor.RED + "플레이어를 찾을 수 없습니다.");
                return true;
            }
            setotherhome(player, target);
            return true;
        }
        setmyhome(player);
        return true;
    }
    public void setmyhome(Player player){
        FileConfiguration config = UserDataManager.getConfig(player);
        config.set("home.world", player.getWorld().getName());
        config.set("home.x", player.getLocation().getX());
        config.set("home.y", player.getLocation().getY());
        config.set("home.z", player.getLocation().getZ());
        config.set("home.yaw", player.getLocation().getYaw());
        config.set("home.pitch", player.getLocation().getPitch());
        UserDataManager.SaveConfig(player);
        player.sendMessage(ChatColor.GREEN + "집이 이곳에 설정되었습니다.");
    }
    public void setotherhome(Player player, Player target){
        FileConfiguration config = UserDataManager.getConfig(target);
        config.set("home.world", player.getWorld().getName());
        config.set("home.x", player.getLocation().getX());
        config.set("home.y", player.getLocation().getY());
        config.set("home.z", player.getLocation().getZ());
        config.set("home.yaw", player.getLocation().getYaw());
        config.set("home.pitch", player.getLocation().getPitch());
        UserDataManager.SaveConfig(target);
        player.sendMessage(Prefix.getPrefix(target) + target.getName() + ChatColor.GREEN + "님에 집이 이곳에 설정되었습니다.");
        return;

    }
}
