package lab5.supermarketsimulation.events;

import lab5.generalsimulation.state.SimState;
import lab5.supermarketsimulation.state.customer.Customer;
import lab5.generalsimulation.events.EventQueue;

/**
 * The event that is executed when a customer has payed for their supplies
 *
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
        stateSuper.addSale();
        if(!stateSuper.checkout().queueIsEmpty()){
            eventQueue.addEvent(new SupermarketPayEvent(eventQueue, state, time.scanTime(),stateSuper.checkout().getFirstInQueue()));
            stateSuper.checkout().serveCustomer();
        }
    }

}
