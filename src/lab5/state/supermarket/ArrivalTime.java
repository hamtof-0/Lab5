package lab5.state.supermarket;

public class ArrivalTime {
    private ExponentialRandomStream random;
    private long seed;
    private double arrivalLambda;

    public ArrivalTime(long seed, double arrivalLambda){
        this.seed = seed;
        this.arrivalLambda = arrivalLambda;
        random = new ExponentialRandomStream(arrivalLambda, seed);
    }

    public double getArrivalTime(double time){
        return time + random.next();
    }
}
