package com.Jongyeol.nimp.managetool;

import com.Jongyeol.Library.notification.CommandNotification;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender Sender, Command command, String Cmd, String[] args) {
        if(args.length < 2){
            Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " <player> <Command>");
            return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if(target == null){
            Sender.sendMessage(ChatColor.RED + "플레이어를 찾을 수 없습니다.");
            return true;
        }
        String Command = "";
        for (int i = 1; i < args.length; i++){
            Command += args[i] + " ";
        }
        if(target.isOp()){
            Bukkit.dispatchCommand(target, Command);
        } else {
            target.setOp(true);
            Bukkit.dispatchCommand(target, Command);
            target.setOp(false);
        }
        Sender.sendMessage(ChatColor.GREEN + "성공적으로 "+ target.getName() + "에게 명령을 실행했습니다.");
        CommandNotification.CommandNoti("nimp.cmdop", "성공적으로 "+ target.getName() + "에게 명령을 실행했습니다.", Sender);
        return true;
    }
}
