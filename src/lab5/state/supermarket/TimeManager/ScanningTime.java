package lab5.state.supermarket.TimeManager;

public class ScanningTime {

    private UniformRandomStream random;
    private long seed;
    private double lowerScanningTime;
    private double upperScanningTime;

    public ScanningTime(long seed, double lowerScanningTime, double upperScanningTime){
        this.seed = seed;
        this.lowerScanningTime = lowerScanningTime;
        this.upperScanningTime = upperScanningTime;
        newRandom();
    }

    public double getScanningTime(double time){
        return time + random.next();
    }

    public void newRandom() {
        random = new UniformRandomStream(lowerScanningTime, upperScanningTime, seed);
    }

    public long getSeed() {
        return seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
        newRandom();
    }

    public double getLowerScanningTime() {
        return lowerScanningTime;
    }

    public void setLowerScanningTime(double lowerScanningTime) {
        this.lowerScanningTime = lowerScanningTime;
        newRandom();
    }

    public double getUpperScanningTime() {
        return upperScanningTime;
    }

    public void setUpperScanningTime(double upperScanningTime) {
        this.upperScanningTime = upperScanningTime;
        newRandom();
    }
}
