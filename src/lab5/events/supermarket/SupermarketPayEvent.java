package lab5.events.supermarket;

import lab5.state.SimState;
import lab5.events.Event;
import lab5.events.EventQueue;
import lab5.state.supermarket.TimeManager;
import lab5.state.supermarket.SupermarketState;

/**
 * @author Hampus Toft
 * @author ...
 * @author ...
 * @author ...
 */
public class SupermarketPayEvent extends Event {

    public SupermarketPayEvent(EventQueue eventQueue, SimState state, double executeTime){
        this.eventQueue = eventQueue;
        this.state = state;
        this.executeTime = executeTime;
    }

    @Override
    public void execute() {
        if (!(state instanceof SupermarketState)){
            throw new RuntimeException("Invalid State");
        }
        // acsses
        SupermarketState stateSuper = (SupermarketState) state;
        TimeManager time = stateSuper.getTimeManager();
        stateSuper.addSale(); // TODO: Implement this method which adds to sales and remove a customer
        stateSuper.checkout().customerServed(); // TODO: Implement this method which frees a checkout
        if(!stateSuper.checkout().queueIsEmpty()){
            eventQueue.addEvent(new SupermarketPayEvent(eventQueue, state, time.scanTime()));
            stateSuper.checkout().serveCustomer(); // TODO: Implement this method which occupies a checkout
        }

        // Is the eventQueue Empty?
        if(eventQueue.isEmpty()){
            // No events in the event queue left to process meaning it has reached its end
            eventQueue.addEvent(new SupermarketStopEvent(eventQueue, state, time.getTime()+1));
        }

        /*
        Alternative StopEvent code:

        // Is Supermarket closed?
        if(!stateSuper.isOpen()){
            // Is the number of customers in the store equal to 0?
            if(stateSuper.getNumberOfCustomers() == 0){
                // add stop event due to simulation not being able to schedule more tasks
                eventQueue.addEvent(new SupermarketStopEvent(eventQueue, state, time.getTime()+1));
            }
        }
        */
    }

}
