package lab5.view;

import lab5.state.SimState;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 * 
 * 
 */
public abstract class SimView implements Observer {

    protected SimState state;

    /**
     * Constructor
     * 
     * @param state The general state of the simulation
     */
    public SimView(SimState state){
        this.state = state;
    }

    /**
     * Defined in children to update notify observers
     */
    public abstract void update(Observable o, Object arg);
}
