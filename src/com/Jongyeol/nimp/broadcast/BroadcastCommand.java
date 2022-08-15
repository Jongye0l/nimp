package com.Jongyeol.nimp.broadcast;

import com.Jongyeol.Library.notification.CommandNotification;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BroadcastCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender Sender, Command command, String Cmd, String[] args) {
        if(args.length < 1) {
            Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " <String>");
            return true;
        }
        CommandNotification.CommandNoti("nimp.broadcast", "공지를 했습니다.", Sender);
        String msg = "";
        for(int i = 0; i < args.length; i++) { msg = msg + args[i] + " "; }
        Bukkit.broadcastMessage(ChatColor.RED + "[" + ChatColor.DARK_RED + "공지" + ChatColor.RED + "] " + ChatColor.GREEN + msg.replaceAll("&", "§"));
        return true;
    }
}
