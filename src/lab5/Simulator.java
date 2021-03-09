package lab5;

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
    
    public Simulator(SimState state, EventQueue eventQueue) {
    	this.state = state;
    	this.eventQueue = eventQueue;
    }


    public void run(){
        while (!state.isStopped()){
            eventQueue.getNextEvent().execute();
            state.update();
        }
    }
}
