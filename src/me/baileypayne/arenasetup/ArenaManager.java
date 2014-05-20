
package me.baileypayne.arenasetup;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 *
 * @author Bailey
 */
public class ArenaManager {
    
    private ArenaSetup plugin;
    
    private static ArenaManager am = new ArenaManager();
    
    //to get the arena manager
    public static ArenaManager getManager(){
        return am;
    }
    private FileConfiguration config;
    
    
    //Getting a Arena
    public Arena getArena(String name){
        for(Arena a: Arena.arenaObjects){ // checks all arenas in the list
            if(a.getName().equals(name)){ // checks to see if the name is in the list
                return a; //return that arena
            }
        }
        return null; //nothing was found
    }
    //Adding Players
    public void addPlayers(Player player, String arenaName){
        if(getArena(arenaName) != null){ //if there is an arena under the name
            Arena arena = getArena(arenaName);
            if(arena.getLobbyLocation() != null){
            if(arena.getRedSpawn() != null){
            if(arena.getBlueSpawn() != null){   
            if(arena.getEndLocation() != null){    
            if(!arena.isFull()){ //if the arena isnt full
                if(!arena.isInGame()){ //if the arena isnt ingame
                    //check complete, arena joinable
                    player.getInventory().clear(); //clears inv
                    player.setHealth(player.getMaxHealth()); //heals player
                    player.setFireTicks(0);
                    
                    //Teleport player to lobby
                    player.teleport(arena.getLobbyLocation());
                    
                    //Adds player to arena list
                    arena.getPlayers().add(player.getName());
                    
                    int playersLeft = arena.getMaxPlayers() - arena.getPlayers().size(); //how many players left
                    //sends a message to everyone in arena
                    arena.sendMessage(ChatColor.DARK_RED + player.getName() + " Has Joined the game! We need " + playersLeft + " more to start the game!");
                    
                    //starting arena
                    if(playersLeft == 0){ //if there is no one left to join
                        startArena(arenaName); //starts arena
                    }
                }
                
            }
            
        }
        
    }
    }
    }
    }
    }
    //Method for Removing Players
    public void removePlayer(Player player, String arenaName){
        if(getArena(arenaName) != null){
            //if arena exists
            Arena arena = getArena(arenaName);
            if(arena.getPlayers().contains(player.getName())){
                //if the arena has the player in
                player.getInventory().clear();
                player.setHealth(player.getMaxHealth());
                player.setFireTicks(0);
                
                //teleport player to end location
                player.teleport(arena.getEndLocation());
                
                //remove player from arena listt
                arena.getPlayers().remove(player.getName());
                
                //sends all players in arena a message
                arena.sendMessage(ChatColor.RED + player.getName() + " has left the arena!");
                
            }
            else{
                //player not in the arena
                player.sendMessage(ChatColor.RED + "You are not in this arena!");
            }
        }
        else{
            //arena doesnt exist
            player.sendMessage(ChatColor.RED + "This Arena isn't Real!");
        }
    }
    //Method for starting Arena
    public void startArena(String arenaName){
        int Chance = ArenaSetup.randint();
        if(getArena(arenaName) != null){
            //if arena exists
            Arena arena = getArena(arenaName);
            arena.sendMessage(ChatColor.GREEN + "The Arena has started! Good Luck!");
            
            //set ingame
            arena.setInGame(true);
            
            for(String s: arena.getPlayers()){ //loops through all players
                //Put players in correct spawn place
                if(Chance >0 && Chance <=50){
                    Bukkit.getPlayer(s).teleport(arena.getRedSpawn());
                    Bukkit.getPlayer(s).sendMessage(ChatColor.RED + "You are on Red Team!");
                }
                else{
                    Bukkit.getPlayer(s).teleport(arena.getBlueSpawn());
                    Bukkit.getPlayer(s).sendMessage(ChatColor.BLUE + "You are on Blue Team!");
                }
                
                
                //set armor and weapons
            }
            
        }
    }
    //Method for ending Arena
    public void endArena(String arenaName){
        if(getArena(arenaName) != null){
            //if arena exists
            Arena arena = getArena(arenaName);
            
            //sends message
            arena.sendMessage(ChatColor.RED + "The Arena has ended!");
            
            //set ingame to false
            arena.setInGame(false);
            
            for(String s: arena.getPlayers()){
                //loops through players
                //teleport them back
                Player player = Bukkit.getPlayer(s);
                player.teleport(arena.getEndLocation());
                
                //sets inv back to normal
                player.getInventory().clear();
                player.setHealth(player.getMaxHealth());
                player.setFireTicks(0);
                
                //remove players frm the list
                arena.getPlayers().remove(player.getName());
                
            }
        }
        
    }
    //Loading Arenas
    public void loadArenas(){
        //config file
        FileConfiguration fc = plugin.getConfig();
        
        for(String keys: fc.getConfigurationSection("arenas").getKeys(false)){
            
            //Arena Object
            World world = Bukkit.getWorld("arenas." + keys + ".world");
            
            //Locations
            double joinX = fc.getDouble("arenas." + "keys." + ".lobbyX");
            double joinY = fc.getDouble("arenas." + "keys." + ".lobbyY");
            double joinZ = fc.getDouble("arenas." + "keys." + ".lobbyZ");
            Location lobbyLocation = new Location(world, joinX, joinY, joinZ);
            
            double redX = fc.getDouble("arenas." + "keys." + ".redX");
            double redY = fc.getDouble("arenas." + "keys." + ".redY");
            double redZ = fc.getDouble("arenas." + "keys." + ".redZ");
            Location redSpawn = new Location(world, redX, redY, redZ);
            
            double blueX = fc.getDouble("arenas." + "keys." + ".blueX");
            double blueY = fc.getDouble("arenas." + "keys." + ".blueY");
            double blueZ = fc.getDouble("arenas." + "keys." + ".blueZ");
            Location blueSpawn = new Location(world, blueX, blueY, blueZ);
            
            double endX = fc.getDouble("arenas." + "keys." + ".endX");
            double endY = fc.getDouble("arenas." + "keys." + ".endY");
            double endZ = fc.getDouble("arenas." + "keys." + ".endZ");
            Location endLocation = new Location(world, endX, endY, endZ);
 
 
            int maxPlayers = fc.getInt("arenas." + keys + ".maxPlayers");
            
            //object creation
            Arena arena = new Arena(keys, lobbyLocation, redSpawn, blueSpawn, endLocation, 17);
        }
    }
    public void createArena(String arenaName, int maxPlayers){
        
        //arena object to represent it
        Arena arena = new Arena(arenaName, null, null, null, null, maxPlayers);
        
        FileConfiguration fc = plugin.getConfig();
        
        fc.set("arenas." + arenaName, null); //set name
        
        String path = "arenas." + arenaName + ".";
        
        //set max players        
        fc.set(path + ".maxPlayers", maxPlayers);
        
        //need to save config
        plugin.saveConfig();
    }
    public void setLobbyLocation(String arenaName, Location lobbyLocation){
        FileConfiguration fc = plugin.getConfig();
        String path = "arenas." + arenaName + ".";
        fc.set(path + ".lobbyX", lobbyLocation.getX());
        fc.set(path + ".lobbyY", lobbyLocation.getY());
        fc.set(path + ".lobbyZ", lobbyLocation.getZ());
        Arena arena = getArena(arenaName);
        arena.setLobbyLocation(lobbyLocation);
        plugin.saveConfig();
    }
    public void setRedSpawn(String arenaName, Location redSpawn){
        FileConfiguration fc = plugin.getConfig();
        String path = "arenas." + arenaName + ".";
        fc.set(path + ".redX", redSpawn.getX());
        fc.set(path + ".redY", redSpawn.getY());
        fc.set(path + ".redZ", redSpawn.getZ());
        Arena arena = getArena(arenaName);
        arena.setRedSpawn(redSpawn);
        plugin.saveConfig();
    }
    public void setBlueSpawn(String arenaName, Location blueSpawn){
        FileConfiguration fc = plugin.getConfig();
        String path = "arenas." + arenaName + ".";
        fc.set(path + ".blueX", blueSpawn.getX());
        fc.set(path + ".blueY", blueSpawn.getY());
        fc.set(path + ".blueZ", blueSpawn.getZ());
        Arena arena = getArena(arenaName);
        arena.setBlueSpawn(blueSpawn);
        plugin.saveConfig();
    }
    public void setEndLocation(String arenaName, Location endLocation){
        FileConfiguration fc = plugin.getConfig();
        String path = "arenas." + arenaName + ".";
        fc.set(path + ".endX", endLocation.getX());
        fc.set(path + ".endY", endLocation.getY());
        fc.set(path + ".endZ", endLocation.getZ());
        Arena arena = getArena(arenaName);
        arena.setEndLocation(endLocation);
        plugin.saveConfig();
    }
    public void RemoveArena(Player player, String arenaName){
        FileConfiguration fc = plugin.getConfig();
        String path = "arenas." + arenaName;
        fc.set(path, null);
        plugin.saveConfig();
        player.sendMessage("Arena Removed!");
        Arena.arenaObjects.remove(getArena(arenaName));
    }
}
