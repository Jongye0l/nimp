package com.Jongyeol.nimp.spawn;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender Sender, Command command, String Cmd, String[] args) {
        if(Sender instanceof Player player){
        } else {
            Sender.sendMessage(ChatColor.RED + "이 명령어는 플레이어만 사용할 수 있습니다.");
            return true;
        }
        Location spawn = Spawn.getSpawn();
        if(spawn == null){
            Sender.sendMessage(ChatColor.RED + "스폰에 문제가 발생했습니다. 관리자에게 문의하세요.");
            return true;
        }
        player.teleport(spawn);
        player.sendMessage(ChatColor.GREEN + "스폰으로 이동했습니다.");
        return true;
    }
}
