package lab5.events.supermarket;

import lab5.State.SimState;
import lab5.events.EventQueue;

/**
 * @author Hampus Toft
 * @author ...
 * @author ...
 * @author ...
 */
public class StartEvent extends lab5.events.StartEvent {

    public StartEvent(EventQueue eventQueue, SimState state){
        super(eventQueue, state);
    }

    @Override
    public void execute() {
        setParameters();
        //TODO: The rest of the startup which would be add the next event
    }

    @Override
    protected void setParameters() {
        super.setParameters();
        //TODO: The parameters need to be set using get and Set methods from State
    }
}
