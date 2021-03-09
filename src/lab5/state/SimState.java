package lab5.state;

import java.util.Observable;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 */
public abstract class SimState extends Observable{
    protected boolean stopped;
    protected double time;

    public SimState() {
        stopped = false;
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
}
