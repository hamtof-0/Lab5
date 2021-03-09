package lab5.state.supermarket;

public class GatherTime {

    private UniformRandomStream random;
    private long seed;
    private double lowerGatherTime;
    private double upperGatherTime;

    public GatherTime(long seed, double lowerGatherTime, double upperGatherTime){
        this.seed = seed;
        this.lowerGatherTime = lowerGatherTime;
        this.upperGatherTime = upperGatherTime;
        random = new UniformRandomStream(lowerGatherTime, upperGatherTime, seed);
    }

    public double getGatherTime(double time){
        return time + random.next();
    }
}
