package lab5.generall.events;

import lab5.generall.state.SimState;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 *
 * The generic stop event.
 */
public class StopEvent extends Event {

    private static final String NAME = "Stop";

    /**
     * Constructor
     *
     * @param eventQueue  a generic eventQueue object.
     * @param state       a generic simState object.
     * @param executeTime execute time. (?)
     */
    public StopEvent(EventQueue eventQueue, SimState state, double executeTime) {
        super(eventQueue, state, executeTime, NAME);
    }

    /**
     * Sends the name of THIS (stop) event to the generic event super class.
     */
    public StopEvent() {
        super(NAME);
    }

    /**
     * Calls the stop method in state to stop the simulation
     */
    @Override
    public void execute() {
        super.execute();
        state.stop();// Using the handbrake in State to stop
    }
}
