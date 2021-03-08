package lab5.events.supermarket;

import lab5.state.SimState;
import lab5.events.Event;
import lab5.events.EventQueue;
import lab5.state.supermarket.TimeManager;

/**
 * @author Hampus Toft
 * @author ...
 * @author ...
 * @author ...
 */
public class SupermarketPayEvent extends Event {

    public SupermarketPayEvent(EventQueue eventQueue, SimState state, double executeTime){
        this.eventQueue = eventQueue;
        this.state = state;
        this.executeTime = executeTime;
    }

    @Override
    public void execute() {
        // TODO: Should the next customer be reliant on current customer paying?
        eventQueue.addEvent(new SupermarketArrivalEvent(eventQueue, state, this.executeTime+10));
        // FIXME: Next event is always 10 time units away
        //TODO: Add code to add Event specific code
    }

}
