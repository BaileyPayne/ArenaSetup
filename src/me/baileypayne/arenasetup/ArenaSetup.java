
package me.baileypayne.arenasetup;

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
               
}
