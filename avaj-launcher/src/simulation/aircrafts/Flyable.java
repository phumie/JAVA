package src.simulation.aircrafts;

import src.simulation.aircrafts.*;
import src.simulation.simulator.*;

public interface Flyable {
    public void updateConditions();
    public void registerTower( WeatherTower WeatherTower );
}
