package lab5;

import lab5.events.Event;
import lab5.events.supermarket.SupermarketClosingEvent;
import lab5.events.supermarket.SupermarketStartEvent;
import lab5.events.supermarket.SupermarketStopEvent;
import lab5.state.SimState;
import lab5.events.EventQueue;
import lab5.view.SimView;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 */
public class Simulator {
    private SimState state;
    private EventQueue eventQueue;
    
    public Simulator(SimState state) {
    	this.state = state;
    }


    public void run(){
        eventQueue = new EventQueue();
        eventQueue.addEvent(new SupermarketStartEvent(eventQueue, state, 0d));
        eventQueue.addEvent(new SupermarketClosingEvent(eventQueue, state, 10.0));
        eventQueue.addEvent(new SupermarketStopEvent(eventQueue, state, 99.0));
        //System.out.println("\tNew Event queue: " + eventQueue.toString());
        while (!state.isStopped()){
            Event nextEvent = eventQueue.getNextEvent();
            nextEvent.execute();
            //System.out.println("\tNew Event queue: " + eventQueue.toString());
            state.update(); //FIXME: Descriptions says to update view before code changes State -.-
        }
    }
}
