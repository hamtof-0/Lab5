package lab5.events;

import lab5.state.SimState;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 */
public class StopEvent extends Event {

    private static final String NAME = "Stop";

    public StopEvent(EventQueue eventQueue, SimState state, double executeTime){
    	super(eventQueue, state, executeTime, NAME);
    }

    public StopEvent(){
        super(NAME);
    }

    @Override
    public void execute() {
        super.execute();
        state.stop();// Using the handbrake in State to stop
    }
}
