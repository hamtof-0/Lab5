package lab5.events.supermarket;

import lab5.state.SimState;
import lab5.events.EventQueue;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author ...
 * @author ...
 */
public class SupermarketClosingEvent extends SupermarketEvent {

    private static final String NAME = "Stänger";

    public SupermarketClosingEvent(EventQueue eventQueue, SimState state, double executeTime) {
        super(eventQueue, state, executeTime, NAME);
    }

    @Override
    public void execute() {
        super.execute();
        stateSuper.close();
    }

}
