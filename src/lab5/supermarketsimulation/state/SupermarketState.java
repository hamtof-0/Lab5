package lab5.supermarketsimulation.state;

import lab5.generalsimulation.events.Event;
import lab5.generalsimulation.state.SimState;
import lab5.supermarketsimulation.state.customer.CustomerFactory;
import lab5.supermarketsimulation.state.timemanager.TimeManager;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 * 
 * The specific state of the simulation.
 */

public class SupermarketState extends SimState {

	private int numCustomersInStore = 0;
	private final int maxCustomersInStore;
	private int customersServed = 0;
	private int missedCustomers = 0;
	private boolean open = true;
	private double queueTimeTotal = 0;
	private final CustomerFactory customerFactory;
	private final TimeManager timeManager;
	private final Checkout checkout;
	private double freeTime;

	/**
	 * Constructor
	 * 
	 * @param checkoutTotal The amount of customers that have checked out.
	 * @param maxCustomersInStore The maximum amount of customers allowed in the store, rhona u know.
	 * 
	 * @param arrivalLambda The number of customers per hour.
	 * 
	 * @param gatheringTimeLower The least amount of time a customer needs to gather their stuff in the supermarket.
	 * @param gatheringTimeUpper The greatest amount of time a customer needs to gather their stuff in the supermarket.
	 * 
	 * @param scanningTimeLower The least amount of time a checkout needs to scan a customers stuff.
	 * @param scanningTimeUpper The greatest amount of time a checkout needs to scan a customers stuff.
	 * 
	 * @param seed A start value for the RandomStreams to get the same result when using the same parameters and seed.
	 */
	public SupermarketState(int checkoutTotal, int maxCustomersInStore, double arrivalLambda, double gatheringTimeLower,
			double gatheringTimeUpper, double scanningTimeLower, double scanningTimeUpper, long seed) {
		super();
		this.maxCustomersInStore = maxCustomersInStore;
		this.customerFactory = new CustomerFactory();
		this.checkout = new Checkout(checkoutTotal);
		this.timeManager = new TimeManager(arrivalLambda, gatheringTimeLower, gatheringTimeUpper, scanningTimeLower,
				scanningTimeUpper, seed, this);
	}
	
	/**
	 * Checks if there is room for a customer in the supermarket.
	 * 
	 * @return True if there is room, otherwise false.
	 */
	public boolean hasRoom() {
		return (this.maxCustomersInStore - this.numCustomersInStore) > 0;
	}

	/**
	 * Adds 1 to the customer in store counter.
	 */
	public void addCustomer() {
		numCustomersInStore += 1;
	}

	/**
	 * Adds 1 to the customers missed counter.
	 */
	public void missedCustomer() {
		missedCustomers += 1;
	}

	/**
	 * Sets open to false so that the store closes.
	 */
	public void close() {
		open = false;
	}

	/**
	 * checks if the store is open.
	 * 
	 * @return open Returns true if open, otherwise false.
	 */
	public boolean isOpen() {
		return open;
	}
	
	/**
	 * Used by the view to get information about the checkouts.
	 * 
	 * @return the checkout object.
	 */
	public Checkout checkout() {
		return this.checkout;
	}

	/**
	 * Adds 1 customer to the customersServed Statistics. Also removes the Customer
	 * from the checkout.
	 */
	public void addSale() {
		customersServed++;
		checkout.customerServed();
		numCustomersInStore--;
	}
	
	/**
	 * Returns the number of customers in the store.
	 * 
	 * @return number of customers in the store.
	 */
	public int getNumCustomersInStore() {
		return numCustomersInStore;
	}

	/**
	 * Returns the maximum amount of customers allowed in the store
	 * 
	 * @return maximum allowed customers in the store.
	 */
	public int getMaxCustomersInStore() {
		return maxCustomersInStore;
	}

	/**
	 * Returns the amount of customers served.
	 * 
	 * @return customers served.
	 */
	public int getCustomersServed() {
		return customersServed;
	}

	/**
	 * Returns the amount of customers missed.
	 *
	 * @return customers missed.
	 */
	public int getMissedCustomers() {
		return missedCustomers;
	}

	/**
	 * Returns the total time queued.
	 *
	 * @return total queue time.
	 */
	public double getQueueTimeTotal() {
		return queueTimeTotal;
	}

	/**
	 * Returns the specified seed.
	 *
	 * @return the seed.
	 */
	public long getSeed() {
		return timeManager.getSeed();
	}

	/**
	 * Returns this supermarkets customer factory.
	 *
	 * @return this customer factory.
	 */
	public CustomerFactory getCustomerFactory() {
		return this.customerFactory;
	}

	/**
	 * Returns the time manager object.
	 *
	 * @return the timeManager.
	 */
	public TimeManager getTimeManager() {
		return timeManager;
	}

	/**
	 * Returns the boolean value of the variable stopped.
	 *
	 * @return the value of stopped.
	 */
	public boolean getStopped() {
		return stopped;
	}

	/**
	 * Returns the next event.
	 *
	 * @return the next event.
	 */
	public Event nextEvent() {
		return nextEvent;
	}

	public double getFreeTime() {
		return freeTime; // Placeholder f�r att view ska kunna k�ras
	}

	/**
	 * Sets the free time.
	 *
	 * @param addTime the time to add.
	 */
	private void setFreeTime(double addTime) {
		if(isOpen() || (!isOpen() && getNumCustomersInStore() != 0)){
            freeTime = freeTime + (addTime * (checkout.getCheckoutTotal() - checkout.getCheckoutsOccupied()));
        }
	}

	/**
	 * Sets the total queue time.
	 *
	 * @param addTime the time to add.
	 */
	private void setQueueTimeTotal(double addTime) {
		if (!this.stopped) {
			queueTimeTotal = queueTimeTotal + (addTime * (checkout.getQueue().size()));
		}
	}

	/**
	 * Updates the times
	 */
	public void update() {
		setFreeTime(time - previousTime);
		setQueueTimeTotal(time - previousTime);
		super.update();
	}

}
