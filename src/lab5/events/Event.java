package lab5.events;

import lab5.state.SimState;
import lab5.state.supermarket.Customer;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 */
public abstract class Event {
    protected EventQueue eventQueue;
    protected SimState state;
    protected double executeTime;

    public Event(EventQueue eventQueue, SimState state, double executeTime) {
        this.eventQueue = eventQueue;
        this.state = state;
        this.executeTime = executeTime;
    }

    public abstract void execute();
}
