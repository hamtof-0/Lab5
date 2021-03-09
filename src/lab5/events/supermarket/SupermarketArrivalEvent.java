package lab5.events.supermarket;

import lab5.state.SimState;
import lab5.events.EventQueue;
import lab5.state.supermarket.Customer;
import lab5.state.supermarket.TimeManager;
import lab5.state.supermarket.SupermarketState;
/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author ...
 * @author ...
 */
public class SupermarketArrivalEvent extends SupermarketEvent {

    public SupermarketArrivalEvent(EventQueue eventQueue, SimState state, double executeTime, Customer customer) {
        super(eventQueue, state, executeTime, customer);
    }

    @Override
    public void execute() {
        if(!stateSuper.isOpen()) return;
        if(stateSuper.hasRoom()){
            stateSuper.addCustomer();
            eventQueue.addEvent(new SupermarketGatherEvent(eventQueue, state, time.gatherTime(), super.customer));
        } else {
            stateSuper.missedCustomer();
        }
        if (stateSuper.getCustomerFactory().canCreate())
            eventQueue.addEvent(new SupermarketArrivalEvent(eventQueue, state, time.arrivalTime(), stateSuper.getCustomerFactory().newCustomer()));
    }

}
