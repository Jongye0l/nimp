package com.Jongyeol.nimp.spawn;

import com.Jongyeol.nimp.Main;
import com.Jongyeol.Library.notification.CommandNotification;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

public class SetspawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender Sender, Command command, String Cmd, String[] args) {
        if(Sender instanceof Player){
        } else {
            Sender.sendMessage(ChatColor.RED + "이 명령어는 플레이어만 사용할 수 있습니다.");
            return true;
        }
        Player player = (Player) Sender;
        Configuration config = Main.main.getConfig();
        config.set("spawn.world", player.getWorld().getName());
        config.set("spawn.x", player.getLocation().getX());
        config.set("spawn.y", player.getLocation().getY());
        config.set("spawn.z", player.getLocation().getZ());
        config.set("spawn.yaw", player.getLocation().getYaw());
        config.set("spawn.pitch", player.getLocation().getPitch());
        Main.main.saveConfig();
        player.sendMessage(ChatColor.GREEN + "스폰이 이곳에 설정되었습니다.");
        CommandNotification.CommandNoti("nimp.setspawn", "스폰이 이곳에 설정되었습니다.", Sender);
        return true;
    }
}
