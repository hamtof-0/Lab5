package lab5.events;

import lab5.State.SimState;

/**
 * @author Hampus Toft
 * @author ...
 * @author ...
 * @author ...
 */
public class StopEvent extends Event {

    public StopEvent(EventQueue eventQueue, SimState state, double executeTime){
        this.eventQueue = eventQueue;
        this.state = state;
        this.executeTime = executeTime;
    }

    @Override
    public void execute() {
        //TODO: Add code to stop simulation
        state.stop();// Using the handbrake in State to stop
    }
}
