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
        TimeManager time = stateSuper.getTimeManager();
        double newExecuteTime;
        if(!stateSuper.isOpen()) {
            return;
        }
        eventQueue.addEvent(new SupermarketArrivalEvent(eventQueue, state, time.arrivalTime()));

        if(stateSuper.hasRoom()){
            stateSuper.addCustomer();
            eventQueue.addEvent(new SupermarketGatherEvent(eventQueue, state, time.gatherTime()));
        } else {
            stateSuper.missedCoustomer();
        }
        // FIXME: Next event is always 10 time units away
        // TODO: Add code to add Event specific code
    }

}
