package com.Jongyeol.nimp.managetool;

import com.Jongyeol.Library.notification.CommandNotification;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TalkCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender Sender, Command command, String Cmd, String[] args) {
        if(args.length < 2){
            Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " <player> <Message>");
            return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if(target == null){
            Sender.sendMessage(ChatColor.RED + "플레이어를 찾을 수 없습니다.");
            return true;
        }
        String Message = "";
        for (int i = 1; i < args.length; i++){
            Message += args[i] + " ";
        }
        target.chat(Message);
        Sender.sendMessage(ChatColor.GREEN + "성공적으로 "+ target.getName() + "에 이름으로 채팅을 전송했습니다.");
        CommandNotification.CommandNoti("nimp.talk", "성공적으로 "+ target.getName() + "에 이름으로 채팅을 실행했습니다.", Sender);
        return true;
    }
}
