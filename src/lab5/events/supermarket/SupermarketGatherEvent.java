package lab5.events.supermarket;

import lab5.events.Event;
import lab5.events.EventQueue;
import lab5.state.SimState;
import lab5.state.supermarket.TimeManager;

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
        if(!(state instanceof SimState)) {
            throw new RuntimeException("Wrong state was used");
        }
        SimState simState = (SimState) state;
        TimeManager time = simState.getTimeManager();
        double newExecuteTime;
        if (simState.isOpen()) {
            newExecuteTime = time.arrivalTime();
            eventQueue.addEvent(new SupermarketGatherEvent(eventQueue, state, newExecuteTime));
        }
        if(state.checkout().empty() > 0){
            newExecuteTime = time.scanTime();
            eventQueue.addEvent(new SupermarketPayEvent(eventQueue, state, newExecuteTime);
        }
        // TODO: Add code to for cashier queue and payment
    }

}
