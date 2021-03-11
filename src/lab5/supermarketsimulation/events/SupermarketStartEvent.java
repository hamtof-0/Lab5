package lab5.supermarketsimulation.events;

import lab5.generalsimulation.events.StartEvent;
import lab5.generalsimulation.state.SimState;
import lab5.generalsimulation.events.EventQueue;
import lab5.supermarketsimulation.state.SupermarketState;
import lab5.supermarketsimulation.state.timemanager.TimeManager;

/**
 * This event starts the supermarket simulation by adding the first customer
 *
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
		eventQueue.addEvent(new SupermarketArrivalEvent(eventQueue, state, time.arrivalTime(),
				stateSuper.getCustomerFactory().newCustomer()));
	}
}
