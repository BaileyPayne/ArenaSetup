
package me.baileypayne.arenasetup;

import java.io.File;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Bailey
 */
public class ArenaSetup extends JavaPlugin {
    
    public void onEnable(){
        ArenaManager.getManager().loadArenas();
        loadConfigFile();
                
    }
    //random number generator
    public static int randint(){
	
		double randNumber = Math.random();
		double d;
		d = randNumber * 100;

		int randomInt = (int)d+1;
		return randomInt;
	}
    private void loadConfigFile() {
		saveDefaultConfig();
		getConfig().options();
		saveConfig();
	}
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
                                
        return false;

    }            
}
