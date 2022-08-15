package com.Jongyeol.nimp.AutoSave;

import com.Jongyeol.Library.notification.CommandNotification;
import com.Jongyeol.nimp.data.UserDataManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class AutoSave extends BukkitRunnable implements CommandExecutor {
    @Override
    public void run() {
        save();
    }
    public static void save() {
        Bukkit.broadcastMessage(ChatColor.GREEN + "플레이어를 저장하는중...");
        Bukkit.savePlayers();
        for(Player player : Bukkit.getOnlinePlayers()){
            UserDataManager.SaveConfig(player);
        }
        Bukkit.broadcastMessage(ChatColor.GREEN + "플레이어를 저장했습니다.");
        Bukkit.broadcastMessage(ChatColor.GREEN + "월드를 저장하는중...");
        for(World world : Bukkit.getWorlds()){
            world.save();
        }
        Bukkit.broadcastMessage(ChatColor.GREEN + "월드를 저장했습니다.");

    }
    @Override
    public boolean onCommand(CommandSender Sender, Command command, String Cmd, String[] args) {
        CommandNotification.CommandNoti("nimp.save", "서버를 저장합니다.", Sender);
        Sender.sendMessage(ChatColor.GREEN + "서버를 저장합니다.");
        save();
        return true;
    }
}
