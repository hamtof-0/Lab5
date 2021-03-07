package lab5.events.supermarket;

import lab5.State.SimState;
import lab5.events.Event;
import lab5.events.EventQueue;

/**
 * @author Hampus Toft
 * @author ...
 * @author ...
 * @author ...
 */
public class ArrivalEvent extends Event {

    public ArrivalEvent(EventQueue eventQueue, SimState state){
        this.eventQueue = eventQueue;
        this.state = state;
    }

    @Override
    public void execute() {
        //TODO: Add code to add Event specific code
    }

}
