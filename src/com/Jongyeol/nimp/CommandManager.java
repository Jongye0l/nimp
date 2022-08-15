package com.Jongyeol.nimp;

import com.Jongyeol.nimp.AutoSave.AutoSave;
import com.Jongyeol.nimp.broadcast.BroadcastCommand;
import com.Jongyeol.nimp.broadcast.BroadcastTabComplete;
import com.Jongyeol.nimp.cmdspy.CmdspyCommand;
import com.Jongyeol.nimp.cmdspy.CmdspyTabComplete;
import com.Jongyeol.nimp.home.HomeCommand;
import com.Jongyeol.nimp.home.HomeTabComplete;
import com.Jongyeol.nimp.home.SethomeCommand;
import com.Jongyeol.nimp.home.SethomeTabComplete;
import com.Jongyeol.nimp.managetool.*;
import com.Jongyeol.nimp.spawn.SetspawnCommand;
import com.Jongyeol.nimp.spawn.SetspawnTabComplete;
import com.Jongyeol.nimp.spawn.SpawnCommand;
import com.Jongyeol.nimp.spawn.SpawnTabComplete;
import com.Jongyeol.nimp.tpa.*;

public class CommandManager {
    private Main plugin;
    public CommandManager(Main plugin){
        this.plugin = plugin;
    }
    public void SetupCommand() {
        plugin.getCommand("broadcast").setExecutor(new BroadcastCommand());
        plugin.getCommand("broadcast").setTabCompleter(new BroadcastTabComplete());
        plugin.getCommand("cmdspy").setExecutor(new CmdspyCommand());
        plugin.getCommand("cmdspy").setTabCompleter(new CmdspyTabComplete());
        plugin.getCommand("home").setExecutor(new HomeCommand());
        plugin.getCommand("home").setTabCompleter(new HomeTabComplete());
        plugin.getCommand("sethome").setExecutor(new SethomeCommand());
        plugin.getCommand("sethome").setTabCompleter(new SethomeTabComplete());
        plugin.getCommand("spawn").setExecutor(new SpawnCommand());
        plugin.getCommand("spawn").setTabCompleter(new SpawnTabComplete());
        plugin.getCommand("setspawn").setExecutor(new SetspawnCommand());
        plugin.getCommand("setspawn").setTabCompleter(new SetspawnTabComplete());
        plugin.getCommand("cmd").setExecutor(new CmdCommand());
        plugin.getCommand("cmd").setTabCompleter(new CmdTabComplete());
        plugin.getCommand("cmdop").setExecutor(new CmdopCommand());
        plugin.getCommand("cmdop").setTabCompleter(new CmdTabComplete());
        plugin.getCommand("chat").setExecutor(new ChatCommand());
        plugin.getCommand("chat").setTabCompleter(new CmdTabComplete());
        plugin.getCommand("chatop").setExecutor(new ChatopCommand());
        plugin.getCommand("chatop").setTabCompleter(new CmdTabComplete());
        plugin.getCommand("cmdcon").setExecutor(new CmdconCommand());
        plugin.getCommand("cmdcon").setTabCompleter(new CmdconTabComplete());
        plugin.getCommand("talk").setExecutor(new TalkCommand());
        plugin.getCommand("talk").setTabCompleter(new CmdTabComplete());
        plugin.getCommand("talkop").setExecutor(new TalkopCommand());
        plugin.getCommand("talkop").setTabCompleter(new CmdTabComplete());
        plugin.getCommand("tpa").setExecutor(new TpaCommand());
        plugin.getCommand("tpa").setTabCompleter(new TpaTabComplete());
        plugin.getCommand("tpaccept").setExecutor(new TpacceptCommand());
        plugin.getCommand("tpaccept").setTabCompleter(new TpRequestTabComplete());
        plugin.getCommand("tpdeny").setExecutor(new TpadenyCommand());
        plugin.getCommand("tpdeny").setTabCompleter(new TpRequestTabComplete());
        plugin.getCommand("save").setExecutor(new AutoSave());
        plugin.getCommand("save").setTabCompleter(new com.Jongyeol.nimp.AutoSave.TabCompleter());
    }
}
