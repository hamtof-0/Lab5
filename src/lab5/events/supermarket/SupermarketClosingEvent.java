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
public class SupermarketClosingEvent extends Event {

    //TODO: This class is completed for now!
    public SupermarketClosingEvent(EventQueue eventQueue, SimState state, double executeTime){
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
        stateSuper.close();
    }

}
