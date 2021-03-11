package lab5.supermarketsimulation.events;

import lab5.generalsimulation.state.SimState;
import lab5.supermarketsimulation.state.customer.Customer;
import lab5.generalsimulation.events.EventQueue;

/**
 * This Event represent a customer arriving to the store.
 *
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 */
public class SupermarketArrivalEvent extends SupermarketEvent {

	private static final String NAME = "Ankomst";

	SupermarketArrivalEvent(EventQueue eventQueue, SimState state, double executeTime, Customer customer) {
		super(eventQueue, state, executeTime, customer, NAME);
	}

	@Override
	public void execute() {
		if (!stateSuper.isOpen()) {
			return;
		}
		if (stateSuper.hasRoom()) {
			stateSuper.addCustomer();
			eventQueue.addEvent(new SupermarketGatherEvent(eventQueue, state, time.gatherTime(), super.customer));
		} else {
			stateSuper.missedCustomer();
		}
		eventQueue.addEvent(new SupermarketArrivalEvent(eventQueue, state, time.arrivalTime(),
				stateSuper.getCustomerFactory().newCustomer()));
	}

}
