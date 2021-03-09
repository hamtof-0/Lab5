package lab5.view;

import lab5.state.SimState;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 */
public abstract class SimView implements Observer {

    protected SimState state;

    public SimView(SimState state){
        this.state = state;
    }

    public abstract void update(Observable o, Object arg);
}
