package lab5.events.supermarket;

import lab5.state.SimState;
import lab5.events.Event;
import lab5.events.EventQueue;
import lab5.state.supermarket.TimeManager;
import lab5.state.supermarket.SupermarketState;
/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author ...
 * @author ...
 */
public class SupermarketArrivalEvent extends Event {

    //TODO: This class is completed for now!
    public SupermarketArrivalEvent(EventQueue eventQueue, SimState state, double executeTime){
        this.eventQueue = eventQueue;
        this.state = state;
        this.executeTime = executeTime;
    }

    @Override
    public void execute() {
        if (!(state instanceof SupermarketState)){
            throw new RuntimeException("Invalid State");
        }
        SupermarketState stateSuper = (SupermarketState) state;

        if(!stateSuper.isOpen()) {
            // Supermarket is closed and nothing happens (Customer dose not count as missed...)
            return;
        }
        // Supermarket is open

        TimeManager time = stateSuper.getTimeManager();

        // If the supermarket is not full
        if(stateSuper.hasRoom()){
            stateSuper.addCustomer();// Then increase amount of customers in the store
            // make a gatherEvent for this new customer
            eventQueue.addEvent(new SupermarketGatherEvent(eventQueue, state, time.gatherTime()));
        } else {
            // Supermarket was full and open
            stateSuper.missedCustomer(); // Then increase amount of missed customers.
        }

        // Add a new Arrival event for the next customer
        eventQueue.addEvent(new SupermarketArrivalEvent(eventQueue, state, time.arrivalTime()));
    }

}
