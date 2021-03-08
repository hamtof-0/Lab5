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
public class ClosingEvent extends Event {

    public ClosingEvent(EventQueue eventQueue, SimState state, double executeTime){
        this.eventQueue = eventQueue;
        this.state = state;
        this.executeTime = executeTime;
    }

    @Override
    public void execute() {
        eventQueue.addEvent(new StopEvent(eventQueue, state, this.executeTime+10));
        // FIXME: Next event is always 10 time units away
        //TODO: Add code to add Event specific code

    }

}