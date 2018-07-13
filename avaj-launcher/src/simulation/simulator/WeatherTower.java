package src.simulation.simulator;

import src.simulation.simulator.*;
import src.simulation.aircrafts.*;

public class WeatherTower extends Tower {

    public String getWeather( Coordinates coordinates) {
        String weather = WeatherProvider.getProvider().getCurrentWeather(coordinates);
        return (weather);
    }

    void changeWeather() {
        this.conditionsChanged();
    }
}