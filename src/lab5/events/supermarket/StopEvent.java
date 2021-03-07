package lab5.events.supermarket;

import lab5.State.SimState;

/**
 * @author Hampus Toft
 * @author ...
 * @author ...
 * @author ...
 */
public class StopEvent extends lab5.events.StopEvent {

    public StopEvent(SimState state) {
        super(state);
    }

    @Override
    public void execute() {
        super.execute();
         //TODO: The rest of the stop if any
    }
}
