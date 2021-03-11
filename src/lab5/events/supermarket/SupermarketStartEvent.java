package lab5.events.supermarket;

import lab5.events.StartEvent;
import lab5.state.SimState;
import lab5.events.EventQueue;
import lab5.state.supermarket.TimeManager.TimeManager;
import lab5.state.supermarket.SupermarketState;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 */
public class SupermarketStartEvent extends StartEvent {

	private final SupermarketState stateSuper;
	private final TimeManager time;

	public SupermarketStartEvent(EventQueue eventQueue, SimState state, double executeTime) {
		super(eventQueue, state, executeTime);
		if (!(state instanceof SupermarketState)) {
			throw new RuntimeException("Invalid State");
		}
		this.stateSuper = ((SupermarketState) state);
		this.time = stateSuper.getTimeManager();
	}

	@Override
	public void execute() {
		super.execute();
		eventQueue.addEvent(new SupermarketArrivalEvent(eventQueue, state, time.arrivalTime(),
				stateSuper.getCustomerFactory().newCustomer()));
	}
}
