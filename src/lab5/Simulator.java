package lab5;

import lab5.events.Event;
import lab5.state.SimState;
import lab5.events.EventQueue;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 * 
 * The general simulator
 */
public class Simulator {
    private final SimState state;
    private EventQueue eventQueue;

    /**
	 * The constructor
	 * 
	 * @param state The general state used to keep track of the general state of the simulation
	 */
    public Simulator(SimState state, EventQueue queue) {
    	this.state = state;
    	eventQueue = queue;
    }

    /**
	 * Starts the simulation nad runs the simulation
	 */
    public void run(){
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
