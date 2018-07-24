package com.assem;

import java.util.HashMap;
import java.util.Map;
//this class is the location in the adventure game
public class Location {
    private final int locationID;
    private final String description;
    private final Map<String,Integer> exits;

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits=new HashMap<String, Integer>();// this stores the values of exits from the location
    }

    //this method allows directions to be added to this map, so that we cn define the details from the main program
    public void addExit(String direction, int location){
        exits.put(direction,location);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExit() {
        //instead of just returning exist map, i am creating a new HasMap and passing out exit in the constructor, so new map is created that has all the mapping from the exits map
        //the reason this would be useful technique is that nothing outside of the class can change exits, so the getter returns a copy of
        //the exits, so if the program wants to add or remove mapping from it, then the exit mapping field wont be affected
        //so there will no chance to change the internal map
        return new HashMap<String, Integer>(exits);
    }
}
