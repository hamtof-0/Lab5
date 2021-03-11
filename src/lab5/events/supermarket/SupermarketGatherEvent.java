package lab5.events.supermarket;

import lab5.events.EventQueue;
import lab5.state.SimState;
import lab5.state.supermarket.Customer.Customer;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 * 
 *         The event that is executed when a customer is done gathering their
 *         stuff
 */
public class SupermarketGatherEvent extends SupermarketEvent {

	private static final String NAME = "Plock";

	/**
	 * Constructor
	 * 
	 * @param eventQueue  The general queue that hold the events in the order they
	 *                    should be executed
	 * @param state       The general state of the simulation
	 * @param executeTime The time that the event will be executed
	 * @param customer    The customer that the event is executed for
	 */
	public SupermarketGatherEvent(EventQueue eventQueue, SimState state, double executeTime, Customer customer) {
		super(eventQueue, state, executeTime, customer, NAME);
	}

	/**
	 * 
	 */
	@Override
	public void execute() {
		super.execute();
		if (stateSuper.checkout().hasEmptyCheckout()) {
			eventQueue.addEvent(new SupermarketPayEvent(eventQueue, state, time.scanTime(), customer));
			stateSuper.checkout().serveCustomer();
		} else {
			stateSuper.checkout().addToQueue(customer);
		}
	}

}
