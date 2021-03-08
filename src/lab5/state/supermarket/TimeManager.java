package lab5.state.supermarket;

public class TimeManager {
	private ArivvalTime arrivalTime;
	private ScanningTime scanningTime;
	private GatherTime gathertime;
	private double time;
	private double closingTime;
	
	public TimeManager(int seed, int time, int closingTime) {
		super();
		this.arrivalTime = new ArrivalTime();
		this.scanningTime = new ScanningTime();
		this.gathertime = new GatherTime();
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
