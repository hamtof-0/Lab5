package lab5.state.supermarket;

public class ScanningTime {

    private UniformRandomStream random;
    private long seed;
    private double lowerScanningTime;
    private double upperScanningTime;

    public ScanningTime(long seed, double lowerScanningTime, double upperScanningTime){
        this.seed = seed;
        this.lowerScanningTime = lowerScanningTime;
        this.upperScanningTime = upperScanningTime;
        random = new UniformRandomStream(lowerScanningTime, upperScanningTime, seed);
    }

    public double getScanningTime(double time){
        return time + random.next();
    }
}
