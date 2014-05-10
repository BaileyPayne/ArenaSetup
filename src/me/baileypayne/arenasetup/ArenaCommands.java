package me.baileypayne.arenasetup;

import me.baileypayne.arenasetup.*;

/**
 * Arena Commands Class
 *
*/

public class ArenaCommands {

     public static Arena main;
     public static Arena plugin;
     
     public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
            if(cmd.getName().equalsIgnoreCase("setlobbyloc"){
               if(sender.hasPermission("arena.setlobbyloc"){
                  Location playerLocation = new Location(sender.getLocation());
                  plugin.setLobbyLocation(playerLocation);
                  sender.sendMessage(ChatColor.GOLD + "Lobby Location" + ChatColor.RED + " set!");
               }else{
                  sender.sendMessage(ChatColor.RED + "Permission denied!");
               }
            }else if(cmd.getName().equalsIgnoreCase("setredloc"){
               if(sender.hasPermission("arena.setredloc"){
                  Location playerLocation2 = new Location(sender.getLocation());
                  plugin.setRedSpawn(playerLocation2);
                  sender.sendMessage(ChatColor.GOLD + "Red Location" + ChatColor.RED + " set!");
               }else{
                  sender.sendMessage(ChatColor.RED + "Permission denied!");
               }
            }else if(cmd.getName().equalsIgnoreCase("setblueloc"){
               if(sender.hasPermission("arena.setblueloc"){
                  Location playerLocation3 = new Location(sender.getLocation());
                  plugin.setBlueSpawn(playerLocation3);
                  sender.sendMessage(ChatColor.GOLD + "Blue Location" + ChatColor.RED + " set!");
               }else{
                  sender.sendMessage(ChatColor.RED + "Permission denied!");
               }
            }else if(cmd.getName().equalsIgnoreCase("setendloc"){
               if(sender.hasPermission("arena.setendloc"){
                  Location playerLocation4 = new Location(sender.getLocation());
                  plugin.setEndLocation(playerLocation4);
                  sender.sendMessage(ChatColor.GOLD + "End Location" + ChatColor.RED + " set!");
               }else{
                  sender.sendMessage(ChatColor.RED + "Permission denied!");
               }
            }
    }

}
