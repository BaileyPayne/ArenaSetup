
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
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        Player player = (Player) sender;
        //Player Commands
        //join an arena
        if(commandLabel.equalsIgnoreCase("join")){
            if(args.length == 1){
                ArenaManager.getManager().addPlayers(player, args[0]);
            }
            else{
                player.sendMessage("Insufficient Arguments!");
            }
        }
        //leave an arena
        if(commandLabel.equalsIgnoreCase("leave")){
            if(args.length == 1){
                ArenaManager.getManager().removePlayer(player, args[0]);
            }
            else{
                player.sendMessage("Insufficient Arguments!");
            }
        }
        //Admin Commands
        //force start
        if(commandLabel.equalsIgnoreCase("forcestart")){
            if(args.length == 1){
                ArenaManager.getManager().startArena(args[0]);
            }
            else{
                player.sendMessage("Insufficient Arguments!");
            }
        }
        //force stop
        if(commandLabel.equalsIgnoreCase("forcestop")){
            if(args.length == 1){
                ArenaManager.getManager().endArena(args[0]);
            }
            else{
                player.sendMessage("Insufficient Arguments!");
            }
        }
        //create
        if(commandLabel.equalsIgnoreCase("create")){
            if(args.length == 2){
                int i = Integer.parseInt(args[1]);
                ArenaManager.getManager().createArena(args[0], i);
            }
            else{
                player.sendMessage("Insufficient Arguments!");
            }
        }
        //set lobby location
        if(commandLabel.equalsIgnoreCase("setlobbyspawn")){
            if(args.length == 1){
                ArenaManager.getManager().setLobbyLocation(args[0], player.getLocation());
                player.sendMessage("Set Lobby Location!");
            }
            else{
                player.sendMessage("Insufficient Arguments!");
            }
        }
        //set red spawn
        if(commandLabel.equalsIgnoreCase("setredspawn")){
            if(args.length == 1){
                ArenaManager.getManager().setRedSpawn(args[0], player.getLocation());
                player.sendMessage("Set Red Spawn!");
            }
            else{
                player.sendMessage("Insufficient Arguments!");
            }
        }
        //set blue spawn
        if(commandLabel.equalsIgnoreCase("setbluespawn")){
            if(args.length == 1){
                ArenaManager.getManager().setBlueSpawn(args[0], player.getLocation());
                player.sendMessage("Set Blue Location!");
            }
            else{
                player.sendMessage("Insufficient Arguments!");
            }
        }
        //set end loc
        if(commandLabel.equalsIgnoreCase("setendloc")){
            if(args.length == 1){
                ArenaManager.getManager().setEndLocation(args[0], player.getLocation());
                player.sendMessage("Set End Location!");
            }
            else{
                player.sendMessage("Insufficient Arguments!");
            }
        }
                return false;
    }
               
}
