package lab5.events.supermarket;

import lab5.events.StopEvent;
import lab5.state.SimState;
import lab5.events.EventQueue;
import lab5.state.supermarket.SupermarketState;
import lab5.state.supermarket.TimeManager.TimeManager;

/**
 * @author Hampus Toft
 * @author ...
 * @author ...
 * @author ...
 */
public class SupermarketStopEvent extends StopEvent {

    private final SupermarketState stateSuper;

    public SupermarketStopEvent(EventQueue eventQueue, SimState state, double executeTime){
        super(eventQueue, state, executeTime);
        if (!(state instanceof SupermarketState)) throw new RuntimeException("Invalid State");
        this.stateSuper = ((SupermarketState) state);
    }


    @Override
    public void execute() {
        super.execute();
        stateSuper.stop();
    }
}
