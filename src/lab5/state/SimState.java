package lab5.state;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author ...
 */
public abstract class SimState {
    protected boolean stopped;
    protected double time;

    public SimState() {
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
