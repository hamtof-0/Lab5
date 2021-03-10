package lab5.events.supermarket;

import lab5.events.EventQueue;
import lab5.state.SimState;
import lab5.state.supermarket.Customer.Customer;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author ...
 * @author ...
 */
public class SupermarketGatherEvent extends SupermarketEvent {

    private static final String NAME = "Gather";

    public SupermarketGatherEvent(EventQueue eventQueue, SimState state, double executeTime, Customer customer) {
        super(eventQueue, state, executeTime, customer, NAME);
    }

    @Override
    public void execute() {
        if(DEBUG_EVENTS) System.out.println("\t[Gather Event] Running...");
        super.execute();
        if(stateSuper.checkout().hasEmptyCheckout()){
            if(DEBUG_EVENTS) System.out.println("\t[Gather Event] Added new \"Pay Event\"");
            eventQueue.addEvent(new SupermarketPayEvent(eventQueue, state, time.scanTime(), customer));
            stateSuper.checkout().serveCustomer();
            if(DEBUG_EVENTS) System.out.println("\t[Gather Event] Checkout now in Use");
        } else {
            stateSuper.checkout().addToQueue(customer);
        }
        if(DEBUG_EVENTS) System.out.println("\t[Gather Event] Finished!");
    }

}
