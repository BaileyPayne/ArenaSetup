
package me.baileypayne.arenasetup;

import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Bailey
 */
public class ArenaSetup extends JavaPlugin {
    
    public void onEnable(){
        ArenaManager.getManager().loadArenas();
        
    }
    //random number generator
    public static int randint(){
	
		double randNumber = Math.random();
		double d;
		d = randNumber * 100;

		int randomInt = (int)d+1;
		return randomInt;
	}
}
