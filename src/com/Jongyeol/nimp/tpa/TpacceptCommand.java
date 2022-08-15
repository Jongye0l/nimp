package com.Jongyeol.nimp.tpa;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpacceptCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender Sender, Command command, String Cmd, String[] args) {
        if(Sender instanceof Player player){
        } else {
            Sender.sendMessage(ChatColor.RED + "이 명령어는 플레이어만 사용할 수 있습니다.");
            return true;
        }
        if(args.length < 1){
            Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " <player>");
            return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if(!TpaDataManager.TpaisSet(target, player)){
            Sender.sendMessage(ChatColor.RED + target.getName() + "님에게 받은 요청이 없습니다.");
            return true;
        }
        if(!target.isOnline()){
            Sender.sendMessage(ChatColor.RED + "플레이어가 오프라인입니다.");
            TpaDataManager.RemoveTpa(target, player);
            return true;
        }
        target.teleport((Player) Sender);
        target.sendMessage(ChatColor.GREEN + "성공적으로 텔레포트 하였습니다.");
        Sender.sendMessage(ChatColor.GREEN + "성공적으로 텔레포트 시켰습니다.");
        TpaDataManager.RemoveTpa(target, player);
        return true;
    }
}
