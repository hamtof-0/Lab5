package lab5.generalsimulation.state;

import lab5.generalsimulation.events.Event;
import lab5.generalsimulation.events.EventQueue;

import java.util.Observable;

/**
 * The general state, keeps track of the general state of the simulation
 * 
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 * 
 * 
 */
public abstract class SimState extends Observable {
    protected boolean stopped;
    protected double time;
    protected double previousTime;
    protected Event nextEvent;
    protected EventQueue eventQueue = new EventQueue();

    
    /**
	 * Constructor 
	 * 
	 * Hold the general parameters for a simulation
	 */
    public SimState() {
        stopped = false;
        time = 0D;
    }
    
    /**
	 * Getter for for the current time of the simulation
	 * 
	 * @return time The current time of the simulation
	 */
    public double getTime() {
        return time;
    }
    
    /**
	 * Setter for the new current time
	 */
    public void setTime(double time) {
    	previousTime = this.time;
        this.time = Math.max(this.time, time);
    }
    
    /**
	 * Handbrake for the simulation
	 */
    public void stop() {
        stopped = true;
    }
    
    /**
	 * Used to check if the simulation is to stop
	 * 
	 * @return stopped Hold the value if the simulation is stopped or not
	 */
    public boolean isStopped(){
        return stopped;
    }
    
    /**
	 * Notify any observers
	 */
    public void update() {
    	setChanged();
    	notifyObservers();
    }
    
    /**
	 * 
	 */
    public String getEvent() {
        return nextEvent.getName();
    }
    
    /**
	 * Sets the updates the variable nextEvent
	 * 
	 * @param nextEvent updates old nextEvent to the new nextEvent
	 */
    public void nextEvent(Event nextEvent){
        this.nextEvent = nextEvent;
    }
}
