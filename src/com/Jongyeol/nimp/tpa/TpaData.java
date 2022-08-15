package com.Jongyeol.nimp.tpa;

import org.bukkit.entity.Player;

public class TpaData {
    private Player sender;
    private Player target;
    public TpaData(Player sender, Player target) {
        this.sender = sender;
        this.target = target;
    }
    public Player getSender(){
        return sender;
    }

    public Player getTarget() {
        return target;
    }
}
