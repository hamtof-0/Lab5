package lab5.events;

import lab5.State.SimState;

/**
 * @author Hampus Toft
 * @author ...
 * @author ...
 * @author ...
 */
public class StopEvent extends Event {

    public StopEvent(EventQueue eventQueue, SimState state){
        this.eventQueue = eventQueue;
        this.state = state;
    }

    @Override
    public void execute() {
        //TODO: Add code to stop simulation
    }
}
