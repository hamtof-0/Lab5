package lab5.events.supermarket;

import lab5.events.Event;
import lab5.events.EventQueue;
import lab5.state.SimState;
import lab5.state.supermarket.TimeManager;
import lab5.state.supermarket.SupermarketState;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author ...
 * @author ...
 */
public class SupermarketGatherEvent extends Event {

    public SupermarketGatherEvent(EventQueue eventQueue, SimState state, double executeTime){
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

        // Is there a empty checkout?
        if(stateSuper.checkout().hasEmptyCheckout()){
            // There is add this customer to a empty checkout

            TimeManager time = stateSuper.getTimeManager();
            eventQueue.addEvent(new SupermarketPayEvent(eventQueue, state, time.scanTime()));
            stateSuper.checkout().serveCustomer(); // TODO: Implement this method which occupies a checkout
            // TODO: Something to fill one of the checkouts here with the new customer
        } else {
            // There is not add this customer to the checkout queue
            stateSuper.checkout().addToQueue(); // TODO: customer Object from somewhere goes here
        }
    }

}
