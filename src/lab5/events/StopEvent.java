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
    	super(eventQueue, state, executeTime, "Stop");
    }

    @Override
    public void execute() {
        super.execute();
        state.stop();// Using the handbrake in State to stop
    }
}
