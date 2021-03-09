package lab5.events.supermarket;

import lab5.state.SimState;
import lab5.events.Event;
import lab5.events.EventQueue;
import lab5.state.supermarket.Customer;
import lab5.state.supermarket.TimeManager;
import lab5.state.supermarket.SupermarketState;

/**
 * @author Hampus Toft
 * @author ...
 * @author ...
 * @author ...
 */
public class SupermarketPayEvent extends SupermarketEvent {

    public SupermarketPayEvent(EventQueue eventQueue, SimState state, double executeTime, Customer customer) {
        super(eventQueue, state, executeTime, customer);
    }

    @Override
    public void execute() {
        if (!(state instanceof SupermarketState)) throw new RuntimeException("Invalid State");
        SupermarketState stateSuper = (SupermarketState) state;
        TimeManager time = stateSuper.getTimeManager();
        stateSuper.addSale();
        stateSuper.checkout().customerServed();
        if(!stateSuper.checkout().queueIsEmpty()){
            eventQueue.addEvent(new SupermarketPayEvent(eventQueue, state, time.scanTime(),customer));
            stateSuper.checkout().serveCustomer();
        }

        if(!stateSuper.isOpen()){
            if(stateSuper.getNumCustomersInStore() == 0){
                eventQueue.addEvent(new SupermarketStopEvent(eventQueue, state, time.getTime()+1));
            }
        }
        /*
        Alternative StopEvent code:
        this will end when Queue is empty, however we want to end it when store is no longer serving customers due
        to us counting the time of checkouts being inactive

        if(eventQueue.isEmpty()){
            eventQueue.addEvent(new SupermarketStopEvent(eventQueue, state, time.getTime()+1));
        }
        */
    }

}
