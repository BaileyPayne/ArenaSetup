
package me.baileypayne.arenasetup;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Bailey
 */
public class ArenaSetupCommands {
    
    private Arena plugin;
    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        Player player = (Player) sender;
        
        //Player Commands
                
                //join
                if(commandLabel.equalsIgnoreCase("join")){
                    ArenaManager.getManager().addPlayers(player, args[0]);
                }
                //leave
                if(commandLabel.equalsIgnoreCase("leave")){
                    ArenaManager.getManager().removePlayer(player, args[0]);
                }
                
                //Admin Commands
                
                //start
                if(player.hasPermission("arena.start")){
                    if(commandLabel.equalsIgnoreCase("forcestart")){
                        ArenaManager.getManager().startArena(args[0]);
                    }
                }
                //stop
                if(player.hasPermission("arena.end")){
                    if(commandLabel.equalsIgnoreCase("forcestop")){
                        ArenaManager.getManager().endArena(args[0]);
                    }
                }
        
        //create arena + set name
        if(player.hasPermission("arena.create")){
                    if(commandLabel.equalsIgnoreCase("create")){
                        ArenaManager.getManager().createArena(args[0], null, null, null, null, 10);
                        player.sendMessage("You Created the Arena named " + args[0]);
                    }
                }
        //set lobby location
        if(player.hasPermission("arena.set.lobby")){
            if(commandLabel.equalsIgnoreCase("setlobbyspawn")){
                //check that the arena exist
                ArenaManager.getManager().getArena(args[0]).setLobbyLocation(player.getLocation());
                //sends confirmation message
                player.sendMessage("Lobby Location has been succesfully added!");
                
            }
        }
        //set red spawn
        if(player.hasPermission("arena.set.redspawn")){
            if(commandLabel.equalsIgnoreCase("setredspawn")){
                //Check that the arena is equal to the arguements and sets spawn
                ArenaManager.getManager().getArena(args[0]).setRedSpawn(player.getLocation());
                //sends confirmation message
                player.sendMessage("Red Spawn has been succesfully added!");
            }
        }
        //set blue spawn
        if(player.hasPermission("arena.set.bluespawn")){
            if(commandLabel.equalsIgnoreCase("setbluespawn")){
                //check that the arena is equal to the arguements plus set spawn
                ArenaManager.getManager().getArena(args[0]).setBlueSpawn(player.getLocation());
                //sends confirmation message
                player.sendMessage("Blue Spawn has been succesfully added!");
            }
        }
        //set end location
        if(player.hasPermission("arena.set.endloc")){
            if(commandLabel.equalsIgnoreCase("setendloc")){
                //check the arena is real and set spawn
                ArenaManager.getManager().getArena(args[0]).setEndLocation(player.getLocation());
                //sends confirmation message
                player.sendMessage("End Location Succesfully added!");
            }
        }
        return false;
    }
}
