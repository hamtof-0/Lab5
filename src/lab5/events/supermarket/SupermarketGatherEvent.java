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
        super.execute();
        if(stateSuper.checkout().hasEmptyCheckout()){
            eventQueue.addEvent(new SupermarketPayEvent(eventQueue, state, time.scanTime(), customer));
            stateSuper.checkout().serveCustomer();
        } else {
            stateSuper.checkout().addToQueue(customer);
        }
    }

}
