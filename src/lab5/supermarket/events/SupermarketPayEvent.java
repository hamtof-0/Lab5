package lab5.supermarket.events;

import lab5.generall.state.SimState;
import lab5.generall.events.EventQueue;
import lab5.supermarket.state.Customer.Customer;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 */
public class SupermarketPayEvent extends SupermarketEvent {

    private static final String NAME = "Betalning";

    SupermarketPayEvent(EventQueue eventQueue, SimState state, double executeTime, Customer customer) {
        super(eventQueue, state, executeTime, customer, NAME);
    }

    @Override
    public void execute() {
        super.execute();
        stateSuper.addSale();
        if(!stateSuper.checkout().queueIsEmpty()){
            eventQueue.addEvent(new SupermarketPayEvent(eventQueue, state, time.scanTime(),stateSuper.checkout().getFirstInQueue()));
            stateSuper.checkout().serveCustomer();
        }
    }

}
