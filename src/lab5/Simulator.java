package lab5;

import lab5.events.Event;
import lab5.events.supermarket.SupermarketClosingEvent;
import lab5.events.supermarket.SupermarketStartEvent;
import lab5.events.supermarket.SupermarketStopEvent;
import lab5.state.SimState;
import lab5.events.EventQueue;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 */
public class Simulator {
    private final SimState state;

    public Simulator(SimState state) {
    	this.state = state;
    }


    public void run(){
        EventQueue eventQueue = new EventQueue();
        eventQueue.addEvent(new SupermarketStartEvent(eventQueue, state, 0d));
        eventQueue.addEvent(new SupermarketClosingEvent(eventQueue, state, 10D));
        eventQueue.addEvent(new SupermarketStopEvent(eventQueue, state, 999.0));
        //System.out.println("\tNew Event queue: " + eventQueue.toString());
        while (!state.isStopped()){
            Event eventToRun = eventQueue.getNextEvent();
            state.nextEvent(eventToRun);
            state.setTime(eventToRun.getExecuteTime());
            state.update();
            eventToRun.execute();
        }
        state.update();
    }
}
