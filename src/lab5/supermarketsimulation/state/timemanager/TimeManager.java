package lab5.supermarketsimulation.state.timemanager;

import lab5.supermarketsimulation.state.SupermarketState;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 * 
 * This is the TimeManager which manages when different events executes using ExponentialRandomStream and UniformRandomStream
 */

public class TimeManager {
	private final UniformRandomStream gatherRandom;
	private final UniformRandomStream scanningRandom;
	private final ExponentialRandomStream arrivalRandom;
	private final long seed;
	private final double arrivalLambda;
	private final double lowerScanningTime;
	private final double upperScanningTime;
	private final double lowerGatherTime;
	private final double upperGatherTime;
	private final SupermarketState state;
	
	/**
	 * Cunstructur
	 * 
	 * @param arrivalLambda How fast the customers arrive
	 * 
	 * @param lowerGatherTime The least amount of time a customer needs to gather their stuff in the supermarket
	 * @param upperGatherTime The greatest amount of time a customer needs to gather their stuff in the supermarket
	 * 
	 * @param lowerScanningTime The least amount of time a checkout needs to scan a customers stuff
	 * @param upperScanningTime The greatest amount of time a checkout needs to scan a customers stuff
	 * 
	 * @param seed A start value for the RandomStreams to get the same result when using the same parameters and seed
	 * @param state used to get the currentTime
	 * 
	 */
	public TimeManager(
					   double arrivalLambda,
					   double lowerGatherTime, double upperGatherTime,
					   double lowerScanningTime, double upperScanningTime,
					   long seed,
					   SupermarketState state) {
		this.seed = seed;
		this.arrivalLambda = arrivalLambda;
		this.lowerScanningTime = lowerScanningTime;
		this.upperScanningTime = upperScanningTime;
		this.lowerGatherTime = lowerGatherTime;
		this.upperGatherTime = upperGatherTime;
		this.arrivalRandom = new ExponentialRandomStream(arrivalLambda, seed);
		this.scanningRandom = new UniformRandomStream(lowerScanningTime, upperScanningTime, seed);
		this.gatherRandom = new UniformRandomStream(lowerGatherTime, upperGatherTime, seed);
		this.state = state;
	}

	/**
	 * Returns the arrival time for the next customer
	 * 
	 * @return The arrival time for the next customer
	 */
	public double arrivalTime(){
		return arrivalRandom.next() + state.getTime();
	}

	/**
	 * Returns the scanning time for the customer
	 * 
	 * @return The scanning time for the customer
	 */
	public double scanTime(){
		return scanningRandom.next() + state.getTime();
	}

	/**
	 * Returns the gather time for the customer
	 * 
	 * @return The gathering time for the customer
	 */
	public double gatherTime(){
		return gatherRandom.next() + state.getTime();
	}

	/**
	 *Returns the seed
	 *
	 *@return Seed The seed used for the RandomeStreams
	 */
	public long getSeed(){
		return seed;
	}
	
	/**
	 * Getter for customers per hour
	 * 
	 * @return arrivalLambda The number of customers per hour
	 */
	public double getArrivalLambda() {
		return arrivalLambda;
	}
	
	/**
	 * Getter for the shortest time to scan
	 * 
	 * @return lowerScanningTime The shortest time to scan
	 */
	public double getLowerScanningTime() {
		return lowerScanningTime;
	}

	/**
	 * Getter for the greatest time to scan
	 * 
	 * @return upperScanningTime The greatest time to scan
	 */
	public double getUpperScanningTime() {
		return upperScanningTime;
	}

	/**
	 * Getter for the shortest time to gather
	 * 
	 * @return lowerGatherTime The shortest time to gather
	 */
	public double getLowerGatherTime() {
		return lowerGatherTime;
	}

	/**
	 * Getter for the greatest time to gather
	 * 
	 * @return lowerGatherTime The greatest time to gather
	 */
	public double getUpperGatherTime() {
		return upperGatherTime;
	}
}
