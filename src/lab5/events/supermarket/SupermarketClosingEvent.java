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

    public SupermarketClosingEvent(EventQueue eventQueue, SimState state, double executeTime) {
        super(eventQueue, state, executeTime, "Closing");
    }

    @Override
    public void execute() {
        if(DEBUG_EVENTS) System.out.println("\t[Closing Event] Running...");
        super.execute();
        stateSuper.close();
        if(DEBUG_EVENTS) System.out.println("\t[Closing Event] Finished!");
    }

}
