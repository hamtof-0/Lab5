package lab5.events.supermarket;

import lab5.events.EventQueue;
import lab5.state.SimState;
import lab5.state.supermarket.Customer;
import lab5.state.supermarket.TimeManager;
import lab5.state.supermarket.SupermarketState;

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
        if (!(state instanceof SupermarketState)) throw new RuntimeException("Invalid State");
        SupermarketState stateSuper = (SupermarketState) state;
        if(stateSuper.checkout().hasEmptyCheckout()){
            TimeManager time = stateSuper.getTimeManager();
            eventQueue.addEvent(new SupermarketPayEvent(eventQueue, state, time.scanTime(), customer));
            stateSuper.checkout().serveCustomer();
        } else {
            stateSuper.checkout().addToQueue(customer);
        }
    }

}
