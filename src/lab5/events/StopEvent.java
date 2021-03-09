package lab5.events;

import lab5.state.SimState;

/**
 * @author Hampus Toft
 * @author ...
 * @author ...
 * @author ...
 */
public class StopEvent extends Event {

    public StopEvent(EventQueue eventQueue, SimState state, double executeTime){
        super(eventQueue, state, executeTime);
    }

    @Override
    public void execute() {
        //TODO: Add code to stop simulation
        state.stop();// Using the handbrake in State to stop
    }
}
