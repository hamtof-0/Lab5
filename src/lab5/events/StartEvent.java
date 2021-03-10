package lab5.events;

import lab5.state.SimState;

/**
 * @author Hampus Toft
 * @author ...
 * @author ...
 * @author ...
 */
public class StartEvent extends Event {

    private static final String NAME = "Start";

    public StartEvent(EventQueue eventQueue, SimState state, double executeTime) {
        super(eventQueue, state, executeTime, NAME);
    }

    public StartEvent(){
        super(NAME);
    }

    @Override
    public void execute() {
        super.execute();
    }
}
