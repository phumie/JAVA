package src.simulation.aircrafts;

import src.simulation.simulator.*;
import src.simulation.aircrafts.*;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft( String name, Coordinates coordinates ){
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId(); 
        
    }

    private long nextId(){
        idCounter += 1;
        return idCounter;
    }
}
