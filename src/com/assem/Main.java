package com.assem;
//Creating the Adventure Game

//HAVE DONE THIS ACCORDING TO A PICTURE, YOU CAN FIND THIS IN THE SAME FILE!!!!

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer,Location> locations =new HashMap<Integer,Location>();//to make the class immutable

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

                    //key        //value
        locations.put(0,new Location(0,"You are sitting in front of a computer learning Java"));
        locations.put(1,new Location(1,"You are standing at the end of a road before a small brick building"));
        locations.put(2,new Location(2,"You are at the top of a hill"));
        locations.put(3,new Location(3,"You are inside a building, a well house for a small spring"));
        locations.put(4,new Location(4,"You are in a vally beside a stream"));
        locations.put(5,new Location(5,"You are in the forest"));
        //these 0,1,2...HERE, they get converted to an integer object by autobxing



        locations.get(1).addExit("W",2);
        locations.get(1).addExit("E",3);
        locations.get(1).addExit("S",4);
        locations.get(1).addExit("N",5);
        locations.get(1).addExit("Q",0);//it is quit, which goes to location zero which is the special location to indicate that we are finishing. (So it goes to "you are sitting in front of a computer..") which indicates finishing the game

        locations.get(2).addExit("N",5);
        locations.get(2).addExit("Q",0);

        locations.get(3).addExit("W",1);
        locations.get(3).addExit("Q",0);

        locations.get(4).addExit("N",1);
        locations.get(4).addExit("W",2);
        locations.get(4).addExit("Q",0);

        locations.get(5).addExit("S",1);
        locations.get(5).addExit("Q",0);

        //you could have added "Q" to the Location instantance it self in Locaion class
        //because in all locations 0,1,2,3,4,5 "Q" exits and will save you some lines
        //you can add it by writing in to the constructor: this.exits.put("Q",0), and delete from the main class all the addExits"Q "lines

        Map<String,String>vocabulary=new HashMap<String, String>();
        vocabulary.put("QUIT","Q");
        vocabulary.put("NORTH","N");
        vocabulary.put("WEST","W");
        vocabulary.put("SOUTH","S");
        vocabulary.put("EAST","E");


     int loc=1;
     while(true){
         System.out.println(locations.get(loc).getDescription());
         if(loc==0){
             break;
         }
         Map<String,Integer>exits=locations.get(loc).getExit();//getting the exit for this particular location
         System.out.print("Available exits are ");
         for(String exit:exits.keySet()){
             System.out.print(exit+", ");//the key
         }
         System.out.println();//just for space
         String direction=scanner.nextLine().toUpperCase();

         if(direction.length()>1) {
             String[] words = direction.split(" ");
             for (String word : words) {
                 if(vocabulary.containsKey(word)){
                     direction=vocabulary.get(word);
                     break;
                 }

             }

         }
         if(exits.containsKey(direction)){
             loc=exits.get(direction);
         }

         else{
             System.out.println("You cannot go in that direction");
         }

     }

    }
}
