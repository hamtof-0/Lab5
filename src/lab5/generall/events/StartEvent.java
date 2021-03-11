package lab5.generall.events;

import lab5.generall.state.SimState;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 *
 * The generic start event
 */
public class StartEvent extends Event {

    private static final String NAME = "Start";

    /**
     * Constructor
     *
     * @param eventQueue  a generic eventQueue object.
     * @param state       a generic simState object.
     * @param executeTime execute time. (?)
     */
    public StartEvent(EventQueue eventQueue, SimState state, double executeTime) {
        super(eventQueue, state, executeTime, NAME);
    }

    /**
     * Sends the name of THIS (start) event to the generic event super class.
     * Used to create dummy start events that don't affect any state
     */
    public StartEvent(){
        super(NAME);
    }

    /**
     * This will preform the actions that a event dose.
     */
    @Override
    public void execute() {
        // General start event dose nothing
    }
}
