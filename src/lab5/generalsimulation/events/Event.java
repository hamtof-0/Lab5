package lab5.generalsimulation.events;

import lab5.generalsimulation.state.SimState;

/**
 * Defines a general event, children specifies specific events
 * 
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 * 
 * 
 */
public abstract class Event {
    protected EventQueue eventQueue;
    protected SimState state;
    protected double executeTime;
    protected String name;

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
