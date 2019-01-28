/**
 * The RoachMotel class is the client class that instantiates objects of the RoachPopulation class.
 * This class calls methods in the RoachPopulation class and implements only the main() method.
 * @author Nisha P. Chandra
 */

// import the Scanner class
import java.util.Scanner;

public class RoachMotel 
{
	public static void main(String[] args) 
	{
		/*
		 * 70-point version
		 */

		// Using the default constructor, declare and instantiate a 
		// RoachPopulation object to represent the roach population 
		// in the computer lab. 
		// Display the initial population using the accessor method.
		RoachPopulation roachesInLab = new RoachPopulation ();
		int labInitRoaches = roachesInLab.getRoaches();
		System.out.println("My lab has an initial population of " + labInitRoaches + " roaches");
		System.out.println();

		// Using the starting population provided by the user and 1-parameter
		// constructor, declare and instantiate a RoachPopulation object to
		// represent the roach population in your kitchen. 
		// Display initial population using the accessor method.
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter starting population of the kitchen (an integer): ");
		int initialPopulation = scan.nextInt();
		RoachPopulation kitchenRoaches = new RoachPopulation (initialPopulation);
		int initialKitchenRoachPopulation = kitchenRoaches.getRoaches();
		System.out.println ("My kitchen has an initial population of " + initialKitchenRoachPopulation + " roaches");
		System.out.println();

		/*
		 * 85-point version
		 */

		// Wait for the kitchen population to double and display the results
		kitchenRoaches.waitForDoubling();
		int doubleKitchenPopulation = kitchenRoaches.getRoaches();
		System.out.println ("Waiting for the kitchen population to grow....");
		System.out.println ("My kitchen now has " + doubleKitchenPopulation + " roaches");
		System.out.println ();

		// Wait for the lab population to double and display the results
		roachesInLab.waitForDoubling();
		int doubleLabPopulation = roachesInLab.getRoaches();
		System.out.println ("Waiting for the lab population to grow....");
		System.out.println ("My lab now has " + doubleLabPopulation + " roaches");
		System.out.println ();

		/*
		 * 100-point version (uncomment section below)
		 */

		// Spray insecticide in the kitchen and display the results
		System.out.print("Enter strength of kitchen insecticide used (ex, 22.75): ");
		double kitchenSpray = scan.nextDouble();
		int killedKitchenRoaches = kitchenRoaches.spray(kitchenSpray);
		System.out.println ("My kitchen now has " + kitchenRoaches.getRoaches() + " roaches after killing " + killedKitchenRoaches + " roaches");
		System.out.println ();



		// Spray insecticide in the lab and display the results
		System.out.print("Enter strength of lab insecticide used (ex, 22.75): ");
		double labSpray = scan.nextDouble();
		int killedLabRoaches = roachesInLab.spray(labSpray);
		System.out.println ("My lab now has " + roachesInLab.getRoaches() + " roaches after killing " + killedLabRoaches + " roaches");
		System.out.println ();
		
	}
}
		
		