package com.Jongyeol.nimp.tpa;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class TpaDataManager {
    private static ArrayList<TpaData> tpalist = new ArrayList<TpaData>();
    public static void AddTpa(Player sender, Player target){
        tpalist.add(new TpaData(sender, target));
    }
    public static boolean TpaisSet(Player sender, Player target) {
        for (TpaData tpaData : tpalist) {
            if (tpaData.getSender().getName().equals(sender.getName())) {
                if (tpaData.getTarget().getName().equals(target.getName())) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void RemoveTpa(Player sender, Player target){
        for(TpaData tpaData : tpalist){
            if(tpaData.getSender().getName().equals(sender.getName())) {
                if(tpaData.getTarget().getName().equals(target.getName())) {
                    tpalist.remove(tpaData);
                    return;
                }
            }
        }
    }
}
