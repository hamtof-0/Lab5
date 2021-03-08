package lab5.state.supermarket;

public class TimeManager {
	private ArivvalTime arrivalTime;
	private ScanningTime scanningTime;
	private GatherTime gathertime;
	private double time;
	private double closingTime;
	
	public TimeManager(ArivvalTime arrivalTime, ScanningTime scanningTime, GatherTime gathertime, double time,
			double closingTime) {
		super();
		this.arrivalTime = arrivalTime;
		this.scanningTime = scanningTime;
		this.gathertime = gathertime;
		this.time = time;
		this.closingTime = closingTime;
	}

	public ArivvalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(ArivvalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public ScanningTime getScanningTime() {
		return scanningTime;
	}

	public void setScanningTime(ScanningTime scanningTime) {
		this.scanningTime = scanningTime;
	}

	public GatherTime getGathertime() {
		return gathertime;
	}

	public void setGathertime(GatherTime gathertime) {
		this.gathertime = gathertime;
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
	

}
