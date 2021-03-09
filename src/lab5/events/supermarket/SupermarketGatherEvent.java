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
        if (!(state instanceof SupermarketState)) throw new RuntimeException("Invalid State");
        SupermarketState stateSuper = (SupermarketState) state;
        if(stateSuper.checkout().hasEmptyCheckout()){
            TimeManager time = stateSuper.getTimeManager();
            eventQueue.addEvent(new SupermarketPayEvent(eventQueue, state, time.scanTime()));
            stateSuper.checkout().serveCustomer();
        } else {
            stateSuper.checkout().addToQueue(); // FIXME: customer Object from somewhere goes here
        }
    }

}
