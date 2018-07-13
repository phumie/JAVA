package src.simulation.simulator;

import src.simulation.simulator.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.lang.model.util.ElementScanner6;

public class ErrorCheck {
    private static BufferedReader reader;
    private static String line;

    private static boolean isNumber(String line)
    {
        for (char c : line.toCharArray()){
            if (Character.isDigit(c) != true)
                return false;
        }
        return true;
    }

    private static boolean isAircraft(String line)
    {
        if (line.toUpperCase().equals("BALOON"))
            return (true);
        else if (line.toUpperCase().equals("JETPLANE"))
            return (true);
        else if (line.toUpperCase().equals("HELICOPTER"))
            return (true);
        else
            return (false);
    }
    public static boolean checkLine(String args){
        try{
            reader = new BufferedReader(new FileReader(args));
            line = reader.readLine();

            if (line != null){
                line = line.trim();
                if (isNumber(line)== false)
                {
                    System.out.println("Invalid: Simulation count not an integer (has non numeric characters): " + line);
                    return (false); 
                }
            }
            while ((line = reader.readLine()) != null){
                line.trim();
                String items[] = line.split("\\s"); 
    
                if (isAircraft(items[0]) == false)
                {
                    System.out.println("Invalid: Non-existing aircraft detected: " + items[0]);
                    return (false); 
                }  
                if (isNumber(items[2])== false)
                {
                    System.out.println("Invalid: Latitude not a numeric value: " + items[2]);
                    return (false); 
                }            
                
                if (isNumber(items[3])== false)
                {
                    System.out.println("Invalid: Longitude not a numeric value: " + items[3]);
                    return (false); 
                }
                            
                
                if (isNumber(items[4])== false)
                {
                    System.out.println("Invalid: Height not a numeric value: " + items[4]);
                    return (false); 
                }
            }
            return (true);
        }
        catch (Exception e){
            System.out.println("Error: Invalid file");
            return (false);
        }
    }
}