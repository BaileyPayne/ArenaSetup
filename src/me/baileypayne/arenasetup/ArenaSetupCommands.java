
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
        //create arena + set name
        if(player.hasPermission("arena.create")){
                    if(commandLabel.equalsIgnoreCase("create")){
                        plugin.setName(args[0]);
                        player.sendMessage("You Created the Arena named " + args[0]);
                    }
                }
        //add rest of creating arena commands here
        return false;
    }
}
