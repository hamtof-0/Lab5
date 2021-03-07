package lab5.events.supermarket;

import lab5.State.SimState;
import lab5.events.EventQueue;

/**
 * @author Hampus Toft
 * @author ...
 * @author ...
 * @author ...
 */
public class StopEvent extends lab5.events.StopEvent {

    public StopEvent(EventQueue eventQueue, SimState state, double executeTime){
        super(eventQueue, state, executeTime);
    }

    @Override
    public void execute() {
        super.execute();
         //TODO: The rest of the stop if any
    }
}
