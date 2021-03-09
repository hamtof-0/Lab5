package lab5.state;

import lab5.events.EventQueue;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 */
public abstract class SimState {
    protected boolean stopped;
    protected double time;
    protected EventQueue eventQueue;


    public SimState(EventQueue eventQueue) {
        this.eventQueue = eventQueue;
        stopped = false;
    }

    public SimState() {
        this.eventQueue = new EventQueue();
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
