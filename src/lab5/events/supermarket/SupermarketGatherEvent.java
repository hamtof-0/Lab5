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

    public SupermarketGatherEvent(EventQueue eventQueue, SimState state, double executeTime, Customer customer) {
        super(eventQueue, state, executeTime, customer);
    }

    @Override
    public void execute() {
    	stateSuper.getTimeManager().setTime(executeTime);
        if(stateSuper.checkout().hasEmptyCheckout()){
            eventQueue.addEvent(new SupermarketPayEvent(eventQueue, state, time.scanTime(), customer));
            stateSuper.checkout().serveCustomer();
        } else {
            stateSuper.checkout().addToQueue(customer);
        }
    }

}
