package src.simulation.simulator;

import src.simulation.simulator.*;
import src.simulation.aircrafts.*;

import java.util.Random;

public class WeatherProvider 
{
    private static WeatherProvider weatherProvider = null;
    private static String weather[] = {"RAIN", "FOG", "SUN","SNOW"};

    private WeatherProvider(){
    }

    public static WeatherProvider getProvider(){
        if (weatherProvider == null){
            weatherProvider = new WeatherProvider();
        }
        return (weatherProvider); 
    }

    public String getCurrentWeather(Coordinates coordinates){
        Random rand = new Random();
        int randWeather = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight() + rand.nextInt(100);
        return (weather[randWeather % 4]);
    }
}
