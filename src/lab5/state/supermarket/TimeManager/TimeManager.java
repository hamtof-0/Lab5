package lab5.state.supermarket.TimeManager;

import lab5.state.supermarket.SupermarketState;

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
	 * 
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

	public double arrivalTime(){
		return arrivalRandom.next() + state.getTime();
	}

	public double scanTime(){
		return scanningRandom.next() + state.getTime();
	}

	public double gatherTime(){
		return gatherRandom.next() + state.getTime();
	}

	public long getSeed(){
		return seed;
	}

	public double getArrivalLambda() {
		return arrivalLambda;
	}

	public double getLowerScanningTime() {
		return lowerScanningTime;
	}

	public double getUpperScanningTime() {
		return upperScanningTime;
	}

	public double getLowerGatherTime() {
		return lowerGatherTime;
	}

	public double getUpperGatherTime() {
		return upperGatherTime;
	}
}
