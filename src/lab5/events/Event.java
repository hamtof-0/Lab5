package lab5.events;

import lab5.State.SimState;

/**
 * @author Hampus Toft
 * @author ...
 * @author ...
 * @author ...
 */
public abstract class Event {
    protected double executeTime;
    protected SimState state;
    public abstract void execute();
}
