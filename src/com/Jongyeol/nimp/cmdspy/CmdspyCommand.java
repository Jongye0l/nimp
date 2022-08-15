package com.Jongyeol.nimp.cmdspy;

import com.Jongyeol.Library.CheckSet.CustomBoolean;
import com.Jongyeol.Library.notification.CommandNotification;
import com.Jongyeol.nimp.data.UserDataManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CmdspyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender Sender, Command command, String Cmd, String[] args) {
        if (Sender instanceof Player) {
        } else {
            Sender.sendMessage(ChatColor.RED + "이 명령어는 플레이어만 사용할 수 있습니다.");
            return true;
        }
        if(args.length < 1){
            Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " <boolean>");
            return true;
        }
        if(CustomBoolean.booleanCheck(args[0].toLowerCase())) {
            Sender.sendMessage(ChatColor.RED + "True/false를 입력해주세요.");
            return true;
        }
        boolean Boolean = CustomBoolean.makeboolean(args[0].toLowerCase());
        Player player = (Player) Sender;
        FileConfiguration config = UserDataManager.getConfig(player);
        if(Boolean) {
            CommandNotification.CommandNoti("nimp.cmdspy", "커맨드보기 기능을 활성화했습니다.", Sender);
            Sender.sendMessage(ChatColor.GREEN + "커맨드보기 기능을 활성화했습니다.");
        } else {
            CommandNotification.CommandNoti("nimp.cmdspy", "커맨드보기 기능을 비활성화했습니다.", Sender);
            Sender.sendMessage(ChatColor.GREEN + "커맨드보기 기능을 비활성화했습니다.");
        }
        CmdspyMessage.cmdspy(player, Boolean);
        config.set("cmdspy", Boolean);
        UserDataManager.SaveConfig(player);
        return true;
    }
}
