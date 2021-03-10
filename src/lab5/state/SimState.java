package lab5.state;

import lab5.events.EventQueue;

import java.util.Observable;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 */
public abstract class SimState extends Observable {
    protected boolean stopped;
    protected double time;
    protected String currentEvent;
    protected EventQueue eventQueue;


    public SimState(EventQueue eventQueue) {
        this.eventQueue = eventQueue;
        stopped = false;
    }

    public SimState() {
        this.eventQueue = new EventQueue();
        stopped = false;
        time = 0D;
    }

    public SimState(double time) {
        this();
        this.time = time;
    }

    public double getTime() {
        return time;
    }

    public void stop() {
        stopped = true;
    }

    public abstract String toString();

    public boolean isStopped(){
        return stopped;
    }

    public void update() {
    	setChanged();
    	notifyObservers();
    }

    public void setEvent(String event) {
        currentEvent = event;
    }

    public String getEvent() {
        return currentEvent;
    }
}
