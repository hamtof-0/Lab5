package lab5.generall.events;

import lab5.generall.state.SimState;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 * 
 * Defines a general event, children specifies specific events
 */
public abstract class Event {
    protected EventQueue eventQueue;
    protected SimState state;
    protected double executeTime;
    protected String name;
    protected static final boolean DEBUG_EVENTS = false;

    /**
     * Constructor
     *
     * @param eventQueue  a generic eventQueue object.
     * @param state       a generic simState object.
     * @param executeTime execute time. (?)
     * @param name        the name of the event.
     */
    public Event(EventQueue eventQueue, SimState state, double executeTime, String name) {
        this.eventQueue = eventQueue;
        this.state = state;
        this.executeTime = executeTime;
        this.name = name;
    }

    /**
     * Changes the name of the event.
     *
     * @param name the name of the event.
     */
    protected Event(String name) {
        this.name = name;
    }

    /**
     * This will preform the actions that a event dose.
     */
    public abstract void execute();

    /**
     * Returns all the info stored about the event in Event.
     *
     * @return a string describing the event.
     */
    @Override
    public String toString() {
        return "\n\tEvent{" + "Event Type: " + name +
                ", State Type: " + state +
                ", executeTime: " + executeTime +
                "}";
    }

    /**
     * Returns the name of the event.
     *
     * @return event name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the execute time.
     *
     * @return execute time.
     */
    public double getExecuteTime() {
        return executeTime;
    }
}
