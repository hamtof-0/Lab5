package lab5.events;

import lab5.state.SimState;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 */
public abstract class Event {
    protected double executeTime;
    protected SimState state;
    protected EventQueue eventQueue;
    public abstract void execute();
}
