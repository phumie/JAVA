package src.simulation.aircrafts;

import src.simulation.aircrafts.*;
import src.simulation.simulator.*;
import src.simulation.simulator.WriteFile;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon( String name, Coordinates coordinates ){
        super( name, coordinates );
    }

    public void updateConditions(){
        String weather = this.weatherTower.getWeather( this.coordinates );
        
        if ( weather.equals( "SUN" ) ){
            this.coordinates.setLongitude(2);
            this.coordinates.setHeight(4);
            WriteFile.writeToFile( "Baloon#" + this.name + "(" + this.id + "): Jah mahn, pass me some ttttropika!" );
        }
        else if ( weather.equals( "RAIN" ) ){
            this.coordinates.setHeight(-5);
            // this.coordinates.setHeight( this.coordinates.getHeight() - 5 );
            WriteFile.writeToFile( "Baloon#" + this.name + "(" + this.id + "): Is it possible to flood in the sky?" );
        }
        else if ( weather.equals( "FOG" ) ) {
            this.coordinates.setHeight(-3);
            // this.coordinates.setHeight( this.coordinates.getHeight() - 3 );
            WriteFile.writeToFile( "Baloon#" + this.name + "(" + this.id + "): Is everyone on land smoking?" );
        }
        else if ( weather.equals( "SNOW" ) ){
            this.coordinates.setHeight(-15);
            // this.coordinates.setHeight( this.coordinates.getHeight() - 15 );
            WriteFile.writeToFile( "Baloon#" + this.name + "(" + this.id + "): C-c-c-cooooollllldddddd." );
        }
        if ( this.coordinates.getHeight() <= 0 ){
            WriteFile.writeToFile( "Baloon#" + this.name + "(" + this.id + "): Landing..." );
            // weatherTower = new WeatherTower();
            this.weatherTower.unregister(this);
            WriteFile.writeToFile( "Tower says: Baloon#" + this.name + "(" + this.id + ") Unregistered from tower." );
        }

    }

    public void registerTower( WeatherTower weatherTower ){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        WriteFile.writeToFile("Tower says: Baloon#" + this.name + "(" + this.id + ") Registered to tower.");
    }
}