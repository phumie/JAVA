package src.simulation.aircrafts;

import src.simulation.simulator.*;
import src.simulation.aircrafts.*;

import java.io.*;

public abstract class AircraftFactory{
    public static Flyable newAircraft( String type, String name, int longitude, int latitude, int height ){
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if(type.toUpperCase().equals("BALOON")){
            // System.out.println("BALOON created");
            return new Baloon(name, coordinates);
        }
        else if (type.toUpperCase().equals("HELICOPTER")){
            // System.out.println("HELICOPTER created");
            return new Helicopter(name, coordinates);
        }  
        else if (type.toUpperCase().equals("JETPLANE")){
            // System.out.println("JETPLANE created");
            return new JetPlane(name, coordinates);
        }
        else{
            return null;
        }
    }
}