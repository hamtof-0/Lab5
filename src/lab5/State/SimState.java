package lab5.State;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author ...
 * @author ...
 */
public abstract class SimState {
    protected boolean stopped;
    protected double time;

    SimState() {
        stopped = false;
    }

    public double getTime() {
        return time;
    }

    public void stop() {
        stopped = true;
    }

    public abstract String toString();
}
