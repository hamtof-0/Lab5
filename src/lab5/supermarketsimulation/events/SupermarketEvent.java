package lab5.supermarketsimulation.events;

import lab5.generalsimulation.events.Event;
import lab5.generalsimulation.events.EventQueue;
import lab5.generalsimulation.state.SimState;
import lab5.supermarketsimulation.state.Customer.Customer;
import lab5.supermarketsimulation.state.SupermarketState;
import lab5.supermarketsimulation.state.TimeManager.TimeManager;

/**
 * This Event represent the general supermarket event.
 *
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 */
public abstract class SupermarketEvent extends Event {

	protected Customer customer;
	protected SupermarketState stateSuper;
	protected TimeManager time;

	public SupermarketEvent(EventQueue eventQueue, SimState state, double executeTime, Customer customer, String name) {
		this(eventQueue, state, executeTime, name);
		this.customer = customer;
	}

	public SupermarketEvent(EventQueue eventQueue, SimState state, double executeTime, String name) {
		super(eventQueue, state, executeTime, name);
		if (!(state instanceof SupermarketState)) {
			throw new RuntimeException("Invalid State");
		}
		this.stateSuper = ((SupermarketState) state);
		this.time = stateSuper.getTimeManager();
	}

	public abstract void execute();

	public String getCustomerID() {
		if (customer != null) {
			return customer.toString();
		}
		return "---";
	}
}
