package src.simulation.simulator;

import src.simulation.simulator.*;
import src.simulation.aircrafts.*;

import java.io.BufferedReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public	class	Simulator {
	private static WeatherTower weatherTower;
	private static List<Flyable> flyables = new ArrayList<Flyable>();

	public static void main(String[] arg) throws InterruptedException {
		try
		{
			if (ErrorCheck.checkLine(arg[0]) == true)
			{
				WriteFile.createFile();
				BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
				String line = reader.readLine();
				if (line != null)
				{
					line =  line.trim();
					weatherTower = new WeatherTower();
					int simulations = Integer.parseInt(line);
					
					while ((line = reader.readLine()) != null) 
					{
						String items[] = line.split("\\s"); 

						Flyable flyable = AircraftFactory.newAircraft(items[0], items[1],
							Integer.parseInt(items[2]), Integer.parseInt(items[3]),
							Integer.parseInt(items[4]));
							flyable.registerTower(weatherTower);                     
					}

					for (int i = 1; i <= simulations; i++)
					{
						// WriteFile.writeToFile("\n\t\t Simulation " + i);
						weatherTower.changeWeather();
					}
				}
			}
			else
				return;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Couldn't find file " + arg[0]);
		}
		catch (IOException e)
		{
			System.out.println("There was an error while reading the file " + arg[0]);
		}
		finally {
			WriteFile.closeFile();
		}
	}
}
