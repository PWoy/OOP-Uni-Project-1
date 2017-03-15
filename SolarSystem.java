import java.util.*;

class SolarSystem {
	String systemName;

	//Constructor for SolarSystem class
	SolarSystem(String name) {
		systemName = name;
	}

	//Getter method for Solar System Name
	public String getSystemName() {
		return systemName;
	}

	//Class for Planet
	class Planet {
		String name;
		double mass;
		double distance;

		//Constructor to create planets
		Planet(String _name, double _mass, double _distance) {
			name = _name;
			mass = _mass;
			distance = _distance;
		}

		//Getter method for Planet Name
		public String getPlanetName() {
			return name;
		}

		//Getter method for Planet Mass
		public double getPlanetMass() {
			return mass;
		}
		//Getter method for Planet Distance
		public double getPlanetDist() {
			return distance;
		}

		//Calculation and getter method to retrieve Orbit Period
		public double getPlanetOrbit(double mass, double distance) {
			double orbital = Math.sqrt(distance*distance*distance);
			return orbital;
		}

	}

	//Array List to store created planets
	public ArrayList<Planet> planets = new ArrayList<>();

	//Method to create planets and add them to planet array list
	public void addPlanet(String input, double  mass, double distance) {
			planets.add(new Planet(input, mass, distance));
		


	}

	//Method to form the list of summarised sentences for each planet
	public String toString() {
			String[] print = new String[planets.size()]; //String array to hold unique versions of summary for each planet
			String ret = ""; //String to hold all the formatted lines to then be returned 
			final double CONSTANT_1 = 1000.0;
			final int CONSTANT_2 = 1000;


			//iterator for planet array list and formats the 3 doubles to convenient sig figs
			//stores unique summary lines into string array
			for (int i = 0; i < planets.size(); i++) {
				String result1 = planets.get(i).getPlanetName();
				double rounded1 = Math.round(planets.get(i).getPlanetMass()*CONSTANT_2)/CONSTANT_1;
				double rounded2 = Math.round(planets.get(i).getPlanetDist()*CONSTANT_2)/CONSTANT_1;
				double rounded3 = Math.round(planets.get(i).getPlanetOrbit(planets.get(i).getPlanetMass(), 
					planets.get(i).getPlanetDist())*CONSTANT_2)/CONSTANT_1;

				print[i] = "Planet " + result1 + " has a mass of " + rounded1 + " Earths, is " + 
				rounded2 + "AU from its star, and orbits in " + rounded3 + " years";
			}

			//Strips unique lines from previous array and places them into one big string 
			for (int i = 0; i < print.length; i++) {
				ret += print[i] + "\n";
			}

			//returns the full string of summary lines
			return(getSystemName() + "\n" + ret);
	}

	

}
