package lab5.events;

import lab5.state.SimState;

/**
 * @author Hampus Toft
 * @author ...
 * @author ...
 * @author ...
 */
public class StartEvent extends Event {

    public StartEvent(EventQueue eventQueue, SimState state, double executeTime) {
        super(eventQueue, state, executeTime, "Start");
    }

    @Override
    public void execute() {
        super.execute();
    }
}
