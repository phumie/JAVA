package src.simulation.simulator;

import src.simulation.simulator.*;
import src.simulation.aircrafts.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Tower{
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();
    

    public void register(Flyable flyable){
        if(!observers.contains(flyable))  
            observers.add(flyable);
        // System.out.println("aircrafts registered");
    }

    public void unregister(Flyable flyable){
        if(observers.contains(flyable))
            observers.remove(flyable);
        // System.out.println("aircrafts removed");
    }

    protected void conditionsChanged(){
        int size = observers.size();
        // System.out.println(size);

        if (size <= 0){
            WriteFile.writeToFile("Tower says: All aircrafts have landed");
            // System.out.println("aircrafts have landed");
            System.exit(0);
        }

        for (int i = 0; i < observers.size(); i++)
        {
            Flyable temp = observers.get(i);
            observers.get(i).updateConditions();
            if (observers.contains(temp) == false)
                i = i - 1;
		}
    }
}