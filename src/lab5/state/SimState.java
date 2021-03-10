package lab5.state;

import lab5.events.Event;
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
    protected double closingTime;
    protected Event nextEvent;
    protected EventQueue eventQueue = new EventQueue();

    private SimState() {
        stopped = false;
        time = 0D;
    }

    public SimState(double closingTime) {
        this();
        this.closingTime = closingTime;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = Math.max(this.time, time);
    }

    public double getClosingTime() {
        return closingTime;
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

    public String getEvent() {
        return nextEvent.getName();
    }

    public void nextEvent(Event nextEvent){
        this.nextEvent = nextEvent;
    }
}
