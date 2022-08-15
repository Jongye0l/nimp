package com.Jongyeol.nimp.tpa;

import com.Jongyeol.nimp.Main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TpaCommand implements CommandExecutor {
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
        if(target == null){
            Sender.sendMessage(ChatColor.RED + "플레이어를 찾을 수 없습니다.");
            return true;
        }
        if(TpaDataManager.TpaisSet(player, target)){
            Sender.sendMessage(ChatColor.RED + target.getName() + "님에게 이미 요청을 보냈습니다.");
            return true;
        }
        target.sendMessage(ChatColor.AQUA + "---------------------------------------");
        target.sendMessage(ChatColor.LIGHT_PURPLE + player.getName() + "님이 당신에세 tp요청을 보냈습니다. 120초에 시간이 주워집니다.");
        TextComponent accept = new TextComponent(ChatColor.GREEN + "이곳을 눌러 tp를 받습니다.");
        accept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpaccept " + player.getName()));
        target.spigot().sendMessage(accept);
        TextComponent deny = new TextComponent(ChatColor.RED + "이곳을 눌러 거절합니다");
        deny.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpdeny " + player.getName()));
        target.spigot().sendMessage(deny);
        target.sendMessage(ChatColor.AQUA + "---------------------------------------");
        Sender.sendMessage(ChatColor.GREEN + target.getName() + "님에게 tp요청을 보냈습니다. 120초에 시간이 주워집니다.");
        TpaDataManager.AddTpa(player, target);
        new BukkitRunnable(){
            @Override
            public void run() {
                if(TpaDataManager.TpaisSet(player, target)){
                    Sender.sendMessage(ChatColor.RED + "시간이 초과되어 tp요청이 취소되었습니다.");
                    target.sendMessage(ChatColor.RED + "시간이 초과되어 tp요청이 취소되었습니다.");
                    TpaDataManager.RemoveTpa(player, target);
                }
            }
        }.runTaskLater(Main.main, 2400);
        return true;
    }
}
