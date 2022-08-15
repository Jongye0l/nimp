package com.Jongyeol.nimp.tpa;

import com.Jongyeol.Library.CheckSet.CommandComplete;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TpaTabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender Sender, Command command, String Cmd, String[] args) {
        List<String> arg = new ArrayList<>();
        if(args.length == 1) {
            for(Player player : Bukkit.getOnlinePlayers()){
                if(!TpaDataManager.TpaisSet((Player) Sender, player)) {
                    arg.add(player.getName());
                }
            }
            return CommandComplete.getCompleteList(arg, args[0]);
        }
        return arg;
    }
}
