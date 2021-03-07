package lab5.events.supermarket;

import lab5.State.SimState;
import lab5.events.Event;

/**
 * @author Hampus Toft
 * @author ...
 * @author ...
 * @author ...
 */
public class PayEvent extends Event {

    public PayEvent(SimState state) {
        this.state = state;
    }

    @Override
    public void execute() {
        //TODO: Add code to add Event specific code
    }

}
