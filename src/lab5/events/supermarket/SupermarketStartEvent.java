package lab5.events.supermarket;

import lab5.state.SimState;
import lab5.events.EventQueue;

/**
 * @author Hampus Toft
 * @author ...
 * @author ...
 * @author ...
 */
public class SupermarketStartEvent extends lab5.events.StartEvent {

    public SupermarketStartEvent(EventQueue eventQueue, SimState state, double executeTime){
        super(eventQueue, state, executeTime);
    }

    @Override
    public void execute() {
        setParameters();
        eventQueue.addEvent(new SupermarketArrivalEvent(eventQueue, state, this.executeTime+10));
        // FIXME: Next event is always 10 time units away
        // FIXME: Not sure if customer factory is used here or later

        // TODO: The rest of the startup
    }

    @Override
    protected void setParameters() {
        super.setParameters();
        //TODO: The parameters need to be set using get and Set methods from State
    }
}
