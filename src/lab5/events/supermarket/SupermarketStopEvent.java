package lab5.events.supermarket;

import lab5.state.SimState;
import lab5.events.EventQueue;
import lab5.state.supermarket.TimeManager;
import lab5.state.supermarket.SupermarketState;

/**
 * @author Hampus Toft
 * @author ...
 * @author ...
 * @author ...
 */
public class SupermarketStopEvent extends lab5.events.StopEvent {

    public SupermarketStopEvent(EventQueue eventQueue, SimState state, double executeTime){
        super(eventQueue, state, executeTime);
    }

    @Override
    public void execute() {
        super.execute();
        if (!(state instanceof SupermarketState)){
            throw new RuntimeException("Invalid State");
        }
        SupermarketState stateSuper = (SupermarketState) state;
        stateSuper.stop();
    }
}
