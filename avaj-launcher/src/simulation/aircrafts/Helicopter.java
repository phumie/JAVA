package src.simulation.aircrafts;

import src.simulation.aircrafts.*;
import src.simulation.simulator.*;

public class Helicopter  extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        String weather = this.weatherTower.getWeather( this.coordinates );

        if (weather.equals( "SUN")){
            this.coordinates.setLongitude( this.coordinates.getLongitude() + 10 );
            this.coordinates.setHeight( this.coordinates.getHeight() + 2 );
            WriteFile.writeToFile( "Helicopter#" + this.name + "(" + this.id + ") Yoh the sun never loved us." );
        }
        else if (weather.equals("RAIN")){
            this.coordinates.setHeight( this.coordinates.getHeight() - 5 );
            WriteFile.writeToFile( "Helicopter#" + this.name + "(" + this.id + ") Rain rain go away. Come again another day." );
        }
        else if (weather.equals("FOG")){
            this.coordinates.setHeight( this.coordinates.getHeight() - 1 );
            WriteFile.writeToFile( "Helicopter#" + this.name + "(" + this.id + "): I can't see anything." );
        }
        else if (weather.equals("SNOW")){
            this.coordinates.setHeight( this.coordinates.getHeight() - 12 );
            WriteFile.writeToFile( "Helicopter#" + this.name + "(" + this.id + ") I can't feel my toes!" );
        }
        if (this.coordinates.getHeight() <= 0){
            WriteFile.writeToFile( "Helicopter#" + this.name + "(" + this.id + ") Landing..." );
            // weatherTower = new WeatherTower();
            this.weatherTower.unregister( this );
            WriteFile.writeToFile( "Tower says: Helicopter#" + this.name + "(" + this.id + ") Unregistered from tower." );
        }
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        WriteFile.writeToFile( "Tower says: Helicopter#" + this.name + "(" + this.id + ") Registered to tower." );
    }
}
