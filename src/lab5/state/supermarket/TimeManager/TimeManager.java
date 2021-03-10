package lab5.state.supermarket.TimeManager;

import lab5.state.supermarket.SupermarketState;

public class TimeManager {
	private UniformRandomStream gatherRandom;
	private UniformRandomStream scanningRandom;
	private ExponentialRandomStream arrivalRandom;
	private long seed;
	private double arrivalLambda;
	private double lowerScanningTime;
	private double upperScanningTime;
	private double lowerGatherTime;
	private double upperGatherTime;
	private double closingTime;
	private SupermarketState state;
	
	public TimeManager(
					   double arrivalLambda,
					   double lowerGatherTime, double upperGatherTime,
					   double lowerScanningTime, double upperScanningTime,
					   long seed,
					   double closingTime, SupermarketState state) {
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
		this.closingTime = closingTime;
	}

	public double getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(double closingTime) {
		this.closingTime = closingTime;
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

	public void setSeed(long seed) {
		this.arrivalRandom = new ExponentialRandomStream(arrivalLambda, seed);
		this.scanningRandom = new UniformRandomStream(lowerScanningTime, upperScanningTime, seed);
		this.gatherRandom = new UniformRandomStream(lowerGatherTime, upperGatherTime, seed);
	}

	public double getArrivalLambda() {
		return arrivalLambda;
	}

	public void setArrivalLambda(double arrivalLambda) {
		this.arrivalLambda = arrivalLambda;
	}

	public double getLowerScanningTime() {
		return lowerScanningTime;
	}

	public void setLowerScanningTime(double lowerScanningTime) {
		this.lowerScanningTime = lowerScanningTime;
	}

	public double getUpperScanningTime() {
		return upperScanningTime;
	}

	public void setUpperScanningTime(double upperScanningTime) {
		this.upperScanningTime = upperScanningTime;
	}

	public double getLowerGatherTime() {
		return lowerGatherTime;
	}

	public void setLowerGatherTime(double lowerGatherTime) {
		this.lowerGatherTime = lowerGatherTime;
	}

	public double getUpperGatherTime() {
		return upperGatherTime;
	}

	public void setUpperGatherTime(double upperGatherTime) {
		this.upperGatherTime = upperGatherTime;
	}
}
