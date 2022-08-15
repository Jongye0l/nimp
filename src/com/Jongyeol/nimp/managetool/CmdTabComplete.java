package com.Jongyeol.nimp.managetool;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class CmdTabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender Sender, Command command, String Cmd, String[] args) {
        if (args.length == 1) {
            return null;
        }
        return new ArrayList<>();
    }
}
