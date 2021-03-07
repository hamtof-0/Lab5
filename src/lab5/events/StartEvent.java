package lab5.events;

import lab5.State.SimState;

/**
 * @author Hampus Toft
 * @author ...
 * @author ...
 * @author ...
 */
public class StartEvent extends Event {

    public StartEvent(EventQueue eventQueue, SimState state, double executeTime){
        this.eventQueue = eventQueue;
        this.state = state;
        this.executeTime = executeTime;
    }

    @Override
    public void execute() {
        setParameters();
        //TODO: Add code to add to first Event
    }

    protected void setParameters(){
        //TODO: Add code to set the parameters of the simulation state
    }
}
