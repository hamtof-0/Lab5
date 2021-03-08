package lab5.events.supermarket;

import lab5.state.SimState;
import lab5.events.Event;
import lab5.events.EventQueue;
import lab5.state.supermarket.TimeManager;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author ...
 * @author ...
 */
public class SupermarketClosingEvent extends Event {

    public SupermarketClosingEvent(EventQueue eventQueue, SimState state, double executeTime){
        this.eventQueue = eventQueue;
        this.state = state;
        this.executeTime = executeTime;
    }

    @Override
    public void execute() {
        eventQueue.addEvent(new SupermarketStopEvent(eventQueue, state, this.executeTime+10));
        // FIXME: Next event is always 10 time units away
        //TODO: Add code to add Event specific code

    }

}
