package com.Jongyeol.nimp.broadcast;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class BroadcastTabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender Sender, Command command, String Cmd, String[] args) {
        return new ArrayList<>();
    }
}
