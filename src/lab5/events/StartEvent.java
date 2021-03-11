package lab5.events;

import lab5.state.SimState;

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
     */
    public StartEvent(){
        super(NAME);
    }

    @Override
    public void execute() {
        super.execute();
    }
}
