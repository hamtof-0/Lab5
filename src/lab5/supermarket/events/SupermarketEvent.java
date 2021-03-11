package lab5.supermarket.events;

import lab5.generall.events.Event;
import lab5.generall.events.EventQueue;
import lab5.generall.state.SimState;
import lab5.supermarket.state.Customer.Customer;
import lab5.supermarket.state.SupermarketState;
import lab5.supermarket.state.TimeManager.TimeManager;

/**
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

	@Override
	public void execute() {
		super.execute();
	}

	public String getCustomerID() {
		if (customer != null) {
			return customer.toString();
		}
		return "---";
	}
}
