package lab5.events.supermarket;

import lab5.state.SimState;
import lab5.events.EventQueue;
import lab5.state.supermarket.Customer.Customer;
/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author ...
 * @author ...
 */
public class SupermarketArrivalEvent extends SupermarketEvent {

    private static final String NAME = "Ankomst";

    public SupermarketArrivalEvent(EventQueue eventQueue, SimState state, double executeTime, Customer customer) {
        super(eventQueue, state, executeTime, customer, NAME);
    }

    @Override
    public void execute() {
        super.execute();
        if(!stateSuper.isOpen()) {
            return;
        }
        if(stateSuper.hasRoom()){
            stateSuper.addCustomer();
            eventQueue.addEvent(new SupermarketGatherEvent(eventQueue, state, time.gatherTime(), super.customer));
        } else {
            stateSuper.missedCustomer();
        }
        eventQueue.addEvent(new SupermarketArrivalEvent(eventQueue, state, time.arrivalTime(), stateSuper.getCustomerFactory().newCustomer()));
    }

}
