package src.simulation.simulator;

import src.simulation.simulator.*;
import src.simulation.aircrafts.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.lang.*;

public class WriteFile {
    public static File file;
    private static FileWriter fWriter;

    public static void createFile(){
        try{
            file = new File("simulation.txt");
            file.createNewFile();
            
            fWriter = new FileWriter(file);
            // System.out.println("File created");
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        } 
    }

    public static void writeToFile(String str){
        try{
            fWriter.write(str);
            fWriter.write('\n');
            // System.out.println("Written to file");
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        } 
    }

    public static void closeFile(){
        try{
            if (fWriter != null)
                fWriter.close();
            else
                return;
            // System.out.println("File closed");
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
