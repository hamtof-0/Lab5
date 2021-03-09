package lab5.events.supermarket;

import lab5.events.StartEvent;
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
public class SupermarketStartEvent extends StartEvent{

    private final SupermarketState stateSuper;
    private final TimeManager time;

    public SupermarketStartEvent(EventQueue eventQueue, SimState state, double executeTime){
        super(eventQueue, state, executeTime);
        if (!(state instanceof SupermarketState)) throw new RuntimeException("Invalid State");
        this.stateSuper = ((SupermarketState) state);
        this.time = stateSuper.getTimeManager();
    }

    @Override
    public void execute() {
    	stateSuper.getTimeManager().setTime(executeTime);
        setParameters();
        /*
        TODO "A) Simuleringen startar (starthändelse)
            Denna klass får ärva den generella starthändelsen, sättas till att inträffa tiden 0 och ha 
            som enda effekt att en första ankomsthändelse för en ny kund läggs till händelsekön.
            Sida 6 under Rubrik 5.1 Händlser http://www.sm.luth.se/csee/courses/d0010e/labs/lab5/lab5.pdf
        */
        eventQueue.addEvent(new SupermarketArrivalEvent(eventQueue, state, time.arrivalTime(), stateSuper.getCustomerFactory().newCustomer()));
    }

    @Override
    protected void setParameters() {
        super.setParameters();
        //TODO: The parameters need to be set using get and Set methods from State
    }
}
