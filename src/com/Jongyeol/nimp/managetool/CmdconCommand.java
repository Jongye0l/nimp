package com.Jongyeol.nimp.managetool;

import com.Jongyeol.Library.notification.CommandNotification;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CmdconCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender Sender, Command command, String Cmd, String[] args) {
        if(args.length < 1){
            Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " <Command>");
            return true;
        }
        String Command = "";
        for (int i = 0; i < args.length; i++){
            Command += args[i] + " ";
        }
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Command);
        Sender.sendMessage(ChatColor.GREEN + "성공적으로 콘솔에게 명령을 실행했습니다.");
        CommandNotification.CommandNoti("nimp.chat", "성공적으로 콘솔에게 명령을 실행했습니다.", Sender);
        return true;
    }
}
