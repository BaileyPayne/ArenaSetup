
package me.baileypayne.arenasetup;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Location;

/**
 *
 * @author Bailey
 */
public class Arena {
    
    //listing arena objects
    public static ArrayList<Arena> arenaObjects = new ArrayList<Arena>();
        
    //info for arenas to store
    private Location lobbyLocation, redSpawn, blueSpawn, endLocation; //Locations
    private String name; //Arena Names
    private ArrayList<String> players = new ArrayList<String>();//list of players
    private int maxPlayers; //amount of players arena can hold
    private boolean inGame = false; //whether an arena is ingame or not.
    
    //Constructor
    public Arena(String arenaName, Location lobbyLocation, Location redSpawn, Location blueSpawn, Location endLocation, int maxPlayers){
        //initalizing all arguements
        this.name = arenaName;
        this.lobbyLocation = lobbyLocation;
        this.redSpawn = redSpawn;
        this.blueSpawn = blueSpawn;
        this.endLocation = endLocation;
        this.maxPlayers = maxPlayers;
        
        //add all these to the list of objects
        arenaObjects.add(this);
    }
    //General getters and setters
    
    //Lobby Location
    public Location getLobbyLocation(){
        return this.lobbyLocation;
    }
    public void setLobbyLocation(Location lobbyLocation){
        this.lobbyLocation = lobbyLocation;
    }
    //Red Spawn Location
    public Location getRedSpawn(){
        return this.redSpawn;
    }
    public void setRedSpawn(Location redSpawn){
        this.redSpawn = redSpawn;
    }
    //Blue Spawn Location
    public Location getBlueSpawn(){
        return this.blueSpawn;
    }
    public void setBlueSpawn(Location blueSpawn){
        this.blueSpawn = blueSpawn;
    }
    //End Location
    public Location getEndLocation(){
        return this.endLocation;
    }
    public void setEndLocation(Location endLocation){
        this.endLocation = endLocation;
    }
    //Get and Set Name
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    //Get and Set Max Players
    public int getMaxPlayers(){
        return this.maxPlayers;
    }
    public void setMaxPlayers(int maxPlayers){
        this.maxPlayers = maxPlayers;
    }
    //List of Players
    public ArrayList<String> getPlayers(){
        return this.players;
    }
    
    //Booleans
    //returns if arena is full or not
    public boolean isFull(){
        if(players.size() >= maxPlayers){
            return true;
        }
        else{
        return false;
        
    }
    }
    public boolean isInGame(){
        return inGame;
    }
    public void setInGame(boolean inGame){
        this.inGame = inGame;
    }
    //Sends each player in the arena a message
    public void sendMessage(String message){
        for(String s: players){
            Bukkit.getPlayer(s).sendMessage(message);
        }
    }
}
