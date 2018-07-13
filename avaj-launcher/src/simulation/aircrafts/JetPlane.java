package src.simulation.aircrafts;

import src.simulation.aircrafts.*;
import src.simulation.simulator.*;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane( String name, Coordinates coordinates ){
        super( name, coordinates );
    }

    public void updateConditions(){
        String weather = this.weatherTower.getWeather( this.coordinates );

        if ( weather.equals("SUN" ) ){
            this.coordinates.setLatitude( this.coordinates.getLongitude() + 10 );
            this.coordinates.setHeight( this.coordinates.getHeight() + 2 );
            WriteFile.writeToFile( "JetPlan#" + this.name + "(" + this.id + ") I feel blacker than Mugabe!" );
        }
        else if ( weather.equals("RAIN" ) ){
            this.coordinates.setHeight( this.coordinates.getHeight() - 5 );
            WriteFile.writeToFile( "JetPlan#" + this.name + "(" + this.id + ") Driizzzllleesss for Cape Town." );
        }
        else if ( weather.equals("FOG" ) ){
            this.coordinates.setHeight( this.coordinates.getHeight() - 1 );
            WriteFile.writeToFile( "JetPlan#" + this.name + "(" + this.id + ") Whoooaaaa fogging hell!?" );
        }
        else if ( weather.equals("SNOW" ) ){
            coordinates.setHeight( this.coordinates.getHeight() - 12 );
            WriteFile.writeToFile( "JetPlan#" + this.name + "(" + this.id + ") F-f-f-frreezzziiinnng!" );
        }
        if ( this.coordinates.getHeight() <= 0 ){
            WriteFile.writeToFile( "JetPlan#" + this.name + "(" + this.id + ") Landing..." );
            this.weatherTower.unregister( this );
            WriteFile.writeToFile( "Tower says: JetPlan#" + this.name + "(" + this.id + ") Unregistered from tower." );
        }
    }

    public void unregisterTower( WeatherTower weatherTower ){
        this.weatherTower = weatherTower;
        this.weatherTower.unregister( this );
    }

    public void registerTower( WeatherTower weatherTower ){
        this.weatherTower = weatherTower;
        this.weatherTower.register( this );
        WriteFile.writeToFile( "Tower says: JetPlan#" + this.name + "(" + this.id + ") Registered to tower." );
    }
}
