package lab5.events;

import lab5.state.SimState;

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
    protected String name;
    protected static final boolean DEBUG_EVENTS = false;

    public Event(EventQueue eventQueue, SimState state, double executeTime, String name) {
        this.eventQueue = eventQueue;
        this.state = state;
        this.executeTime = executeTime;
        this.name = name;
    }

    protected Event(String name){
        this.name = name;
    }

    public void execute(){
        if(DEBUG_EVENTS) System.out.println("\t\tExecuting Event: " + name);
        //time.setTime(executeTime);
    }

    @Override
    public String toString() {
        return "\n\tEvent{" + "Event Type: " + name +
                ", State Type: " + state +
                ", executeTime: " + executeTime +
                "}";
    }

    public String getName() {
        return name;
    }

    public double getExecuteTime() {
        return executeTime;
    }
}
