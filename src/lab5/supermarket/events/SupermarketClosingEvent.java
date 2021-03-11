package lab5.supermarket.events;

import lab5.generall.state.SimState;
import lab5.generall.events.EventQueue;

/**
 * This Event represent the store closing.
 *
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 */
public class SupermarketClosingEvent extends SupermarketEvent {

    private static final String NAME = "Stänger";

    public SupermarketClosingEvent(EventQueue eventQueue, SimState state, double executeTime) {
        super(eventQueue, state, executeTime, NAME);
    }

    @Override
    public void execute() {
        stateSuper.close();
    }

}
