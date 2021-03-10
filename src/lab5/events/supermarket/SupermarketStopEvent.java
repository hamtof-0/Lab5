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
    private final TimeManager time;

    public SupermarketStopEvent(EventQueue eventQueue, SimState state, double executeTime){
        super(eventQueue, state, executeTime);
        if (!(state instanceof SupermarketState)) throw new RuntimeException("Invalid State");
        this.stateSuper = ((SupermarketState) state);
        this.time = stateSuper.getTimeManager();
    }


    @Override
    public void execute() {
        if(DEBUG_EVENTS) System.out.println("\t[Stop Event] Running...");
        super.execute();
        stateSuper.stop();
        time.setTime(executeTime);
        if(DEBUG_EVENTS) System.out.println("\t[Stop Event] Finished!");
    }
}
