package lab5.events;

import lab5.State.SimState;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author ...
 * @author ...
 */
public abstract class Event {
    protected double executeTime;
    protected SimState state;
    protected EventQueue eventQueue;
    public abstract void execute();
}
