package com.Jongyeol.nimp.cmdspy;

import com.Jongyeol.Library.prefix.Prefix;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.ArrayList;

public class CmdspyMessage {
    private static ArrayList<Player> enablePlayer = new ArrayList<Player>();
    public static void onCommand(PlayerCommandPreprocessEvent event) {
        SendMessage(ChatColor.GREEN + "[명령어] " + ChatColor.RESET + Prefix.getPrefix(event.getPlayer()) + event.getPlayer().getName() + ChatColor.RESET + " : " + event.getMessage());
    }
    private static void SendMessage(String string) {
        for(int i = 0; i < enablePlayer.size(); i++){
            enablePlayer.get(i).sendMessage(string);
        }
    }
    public static void cmdspy(Player player, boolean Cmdspy){
        Boolean exist = false;
        for(int i = 0; i < enablePlayer.size(); i++){
            if(enablePlayer.get(i) == player){
                if(Cmdspy) {
                    exist = true;
                } else {
                    enablePlayer.remove(i);
                    break;
                }
            }
        }
        if(Cmdspy){
            if (!exist){
                enablePlayer.add(player);
            }
        }
    }
}
