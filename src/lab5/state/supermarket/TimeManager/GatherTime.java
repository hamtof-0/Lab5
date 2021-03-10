package lab5.state.supermarket.TimeManager;

public class GatherTime {

    private UniformRandomStream random;
    private long seed;
    private double lowerGatherTime;
    private double upperGatherTime;

    public GatherTime(long seed, double lowerGatherTime, double upperGatherTime){
        this.seed = seed;
        this.lowerGatherTime = lowerGatherTime;
        this.upperGatherTime = upperGatherTime;
        newRandom();
    }

    public double getGatherTime(double time){
        return time + random.next();
    }

    public void newRandom() {
        random = new UniformRandomStream(lowerGatherTime, upperGatherTime, seed);
    }

    public long getSeed() {
        return seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
        newRandom();
    }

    public double getLowerGatherTime() {
        return lowerGatherTime;
    }

    public void setLowerGatherTime(double lowerGatherTime) {
        this.lowerGatherTime = lowerGatherTime;
        newRandom();
    }

    public double getUpperGatherTime() {
        return upperGatherTime;
    }

    public void setUpperGatherTime(double upperGatherTime) {
        this.upperGatherTime = upperGatherTime;
        newRandom();
    }
}
