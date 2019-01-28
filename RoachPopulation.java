/**
 * The RoachPopulation class implements the data and methods for use in client RoachMotel class.
 * This class does not have a main method.
 * @author Nisha P. Chandra
 */

public class RoachPopulation 
{
	private static final int DEFAULT_POPULATION = 10;
	private static final int CONVERT_TO_PERCENTAGE = 100;	
	
	private int numRoaches;		// The roach population
	
	/** Default constructor, initializes the population to 10 
	 */
	public RoachPopulation() 
	{
		numRoaches = DEFAULT_POPULATION;
	}
	
	/** Constructor that initializes the number of roaches based on user input
	 *  Takes one argument (user input)
	 */
	public RoachPopulation(int numOfRoaches) 
	{
		numRoaches = numOfRoaches;
	}


	/** Provides the current roach population
	 *  @return number of roaches remaining
	 */
	public int getRoaches() 
	{
		return numRoaches;
	}


	/** Public method for doubling the population of roaches when called in the client class
	 *  non-return method.
	 */
	public void waitForDoubling() 
	{
		numRoaches = numRoaches + numRoaches;
	}
	
	/** Public method for killing the roaches based on user input on the strength of the insecticide
	 *  @return is a rounded value of the number of roaches killed
	 */
	public int spray(double killPercent) 
	{
		int roachesKilled = (int) Math.ceil ((killPercent/CONVERT_TO_PERCENTAGE) * numRoaches);
		numRoaches = numRoaches - roachesKilled; 
		return roachesKilled;
	}
}
	