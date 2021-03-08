package lab5.state.supermarket;

public class TimeManager {
	private ArrivalTime arrivalTime;
	private ScanningTime scanningTime;
	private GatherTime gatherTime;
	private double time;
	private double closingTime;
	
	public TimeManager(double time,
					   double closingTime,
					   long seed,
					   double arrivalLambda,
					   double lowerScanningTime,
					   double upperScanningTime,
					   double lowerGatherTime,
					   double upperGatherTime) {
		this.arrivalTime = new ArrivalTime(seed, arrivalLambda);
		this.scanningTime = new ScanningTime(seed, lowerScanningTime, upperScanningTime);
		this.gatherTime = new GatherTime(seed, lowerGatherTime, upperGatherTime);
		this.time = time;
		this.closingTime = closingTime;
	}

	public ArrivalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(ArrivalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public ScanningTime getScanningTime() {
		return scanningTime;
	}

	public void setScanningTime(ScanningTime scanningTime) {
		this.scanningTime = scanningTime;
	}

	public GatherTime getGatherTime() {
		return gatherTime;
	}

	public void setGatherTime(GatherTime gathertime) {
		this.gatherTime = gathertime;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(double closingTime) {
		this.closingTime = closingTime;
	}

	public double arrivalTime(){
		return arrivalTime.getArrivalTime(time);
	}

	public double scanTime(){
		return scanningTime.getScanningTime(time);
	}

	public double gatherTime(){
		return gatherTime.getGatherTime(time);
	}

}
