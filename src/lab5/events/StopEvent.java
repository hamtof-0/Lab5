package lab5.events;

import lab5.State.SimState;

/**
 * @author Hampus Toft
 * @author ...
 * @author ...
 * @author ...
 */
public class StopEvent extends Event {

    public StopEvent(SimState state){
        this.state = state;
    }

    @Override
    public void execute() {
        //TODO: Add code to stop simulation
    }
}
