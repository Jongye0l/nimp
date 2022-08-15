package com.Jongyeol.nimp.cmdspy;

import com.Jongyeol.Library.CheckSet.CommandComplete;
import com.Jongyeol.Library.CheckSet.CustomBoolean;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class CmdspyTabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender Sender, Command command, String Cmd, String[] args) {
        List<String> arg = new ArrayList<>();
        if(args.length == 1) {
            if (args[0].toLowerCase().split("")[0].equals("")){
                arg.add("true");
                arg.add("false");
                return arg;
            }
            return CommandComplete.getCompleteList(CustomBoolean.getCustomBoolean(), args[0]);
        }
        return arg;
    }
}
