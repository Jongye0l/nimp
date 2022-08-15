package com.Jongyeol.nimp;

import com.Jongyeol.nimp.cmdspy.CmdspyJoin;
import com.Jongyeol.nimp.cmdspy.CmdspyMessage;
import com.Jongyeol.nimp.data.UserDataManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventListener implements Listener {
    @EventHandler
    public void OnCommand(PlayerCommandPreprocessEvent event) {
        CmdspyMessage.onCommand(event);
    }
    @EventHandler
    public void OnJoin(PlayerJoinEvent event) {
        UserDataManager.OnJoin(event);
        CmdspyJoin.OnJoin(event);
    }
    @EventHandler
    public void OnQuit(PlayerQuitEvent event){
        UserDataManager.OnQuit(event);
        CmdspyJoin.OnQuit(event);
    }
}
