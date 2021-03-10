package lab5.state.supermarket.TimeManager;

public class ArrivalTime {

    private ExponentialRandomStream random;
    private long seed;
    private double arrivalLambda;

    public ArrivalTime(long seed, double arrivalLambda){
        this.seed = seed;
        this.arrivalLambda = arrivalLambda;
        newRandom();
    }

    public double getArrivalTime(double time){
        return time + random.next();
    }

    public void newRandom() {
        random = new ExponentialRandomStream(arrivalLambda, seed);
    }

    public long getSeed() {
        return seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
        newRandom();
    }

    public double getArrivalLambda() {
        return arrivalLambda;
    }

    public void setArrivalLambda(double arrivalLambda) {
        this.arrivalLambda = arrivalLambda;
        newRandom();
    }
}
