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

    public SupermarketArrivalEvent(EventQueue eventQueue, SimState state, double executeTime, Customer customer) {
        super(eventQueue, state, executeTime, customer, "Arrival");
    }

    @Override
    public void execute() {
        if(DEBUG_EVENTS) System.out.println("\t[Arrival Event] Running...");
        super.execute();
        if(!stateSuper.isOpen()) {
            if(DEBUG_EVENTS) System.out.println("\t[Arrival Event] store was closed");
            return;
        }
        if(stateSuper.hasRoom()){
            stateSuper.addCustomer();
            if(DEBUG_EVENTS) System.out.println("\t[Arrival Event] Added new \"Gather Event\"");
            eventQueue.addEvent(new SupermarketGatherEvent(eventQueue, state, time.gatherTime(), super.customer));
        } else {
            stateSuper.missedCustomer();
        }
        if (stateSuper.getCustomerFactory().canCreate()) {
            if(DEBUG_EVENTS) System.out.println("\t[Arrival Event] Factory can create");
            if(DEBUG_EVENTS) System.out.println("\t[Arrival Event] Added new \"Arrival Event\"");
            eventQueue.addEvent(new SupermarketArrivalEvent(eventQueue, state, time.arrivalTime(), stateSuper.getCustomerFactory().newCustomer()));
        }
        if(DEBUG_EVENTS) System.out.println("\t[Arrival Event] Finished!");
    }

}
