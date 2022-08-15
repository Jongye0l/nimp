package com.Jongyeol.nimp.home;

import com.Jongyeol.Library.CheckSet.CommandComplete;
import com.Jongyeol.Library.CheckSet.Other;
import com.Jongyeol.nimp.data.UserDataManager;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class HomeTabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender Sender, Command command, String Cmd, String[] args) {
        List<String> arg = new ArrayList<>();
        if(Sender.isPermissionSet("nimp.home.other")){
            if(args.length == 1) {
                for(OfflinePlayer player : Other.getOfflinePlayers()){
                    FileConfiguration config = UserDataManager.getViewConfig(player);
                    if(config != null && config.contains("home")){
                        arg.add(player.getName());
                    }
                }
                return CommandComplete.getCompleteList(arg, args[0]);
            }
        }
        return arg;
    }
}
