package com.Jongyeol.nimp.tpa;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpadenyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender Sender, Command command, String Cmd, String[] args) {
        if(Sender instanceof Player){
        } else {
            Sender.sendMessage(ChatColor.RED + "이 명령어는 플레이어만 사용할 수 있습니다.");
            return true;
        }
        Player player = (Player) Sender;
        if(args.length < 1){
            Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " <player>");
            return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if(!TpaDataManager.TpaisSet(target, player)){
            Sender.sendMessage(ChatColor.RED + target.getName() + "님에게 받은 요청이 없습니다.");
            return true;
        }
        target.sendMessage(ChatColor.RED + Sender.getName() + "님이 텔레포드를 거절하였습니다.");
        Sender.sendMessage(ChatColor.GREEN + "텔레포트를 거절하였습니다.");
        TpaDataManager.RemoveTpa(target, player);
        return true;
    }
}
