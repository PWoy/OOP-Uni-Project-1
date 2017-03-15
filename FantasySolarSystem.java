import java.util.*;

//Student Number: 919998
//Feedback and Reflection since previous coursework:
	// 1) I have managed to significantly trim down the number of lines since my last coursework
	// 2) I have made an effort to keep the solution as simple as I could
	// 3) My program passes the auto-testing with no hickups


public class FantasySolarSystem {
	public static void inputSolarSystemName() {
		
		Scanner sc = new Scanner(System.in); //initialisation of scanner
		System.out.print("Enter the name of the solar system: "); //prompt for solar system name
		String name = sc.nextLine();
		SolarSystem sys = new SolarSystem(name); //initialisation of Solar System object
		
		//initialising strings to be used in the planet input loop
		String done = "done"; 
		String input = "";


		System.out.println("Now enter planet names - type 'done' to finish"); //prompt for planet input
		
		//initialising masses and distance to be created below
		double mass;
		double distance;

		//planet input loop
		while (!input.equals(done)) {
			System.out.print("Enter name: ");
			input = sc.nextLine();
			//break to ensure the word 'done' is not inluded in planet list
			if (input.equals(done)) {
				break;
			}
			
			//assigning mass and distance
			mass = Math.random() * 10 + 1;
			distance = Math.random() * 2 + 1;
			
			//creates planet
			sys.addPlanet(input, mass, distance);
		}

		//prints out toString method
		System.out.print(sys.toString());	
		
		//table of information
		System.out.println("Name\tMass\tDistance\tPeriod");
		for (int i = 0; i < sys.planets.size(); i++) {
			String result1 = sys.planets.get(i).getPlanetName();
			String result2 = String.format("%.3f", sys.planets.get(i).getPlanetMass());
			String result3 = String.format("%.3f", sys.planets.get(i).getPlanetDist());
			String result4 = String.format("%.3f", sys.planets.get(i).getPlanetOrbit(sys.planets.get(i).getPlanetMass(), 
				sys.planets.get(i).getPlanetDist()));	

			System.out.println(result1 + "\t" + result2 + "\t" + result3 + "\t" + "\t" + result4);
			}

		}

	//main method to run program
	public static void main(String[] args) {
		inputSolarSystemName();
	}
	}


	

