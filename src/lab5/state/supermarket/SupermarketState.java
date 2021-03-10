package lab5.state.supermarket;

import lab5.events.Event;
import lab5.events.supermarket.SupermarketEvent;
import lab5.state.SimState;
import lab5.state.supermarket.Customer.Customer;
import lab5.state.supermarket.Customer.CustomerFactory;
import lab5.state.supermarket.TimeManager.TimeManager;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 * 
 * The specific state of the simulation
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
	 * @param checkoutTotal The amount of customers that have checked out
	 * @param maxCustomersInStore The maximum amount of customers allowed in the store rhona u know
	 * 
	 * @param arrivalLambda The number of customers per hour
	 * 
	 * @param gatheringTimeLower The least amount of time a customer needs to gather their stuff in the supermarket
	 * @param gatheringTimeUpper The greatest amount of time a customer needs to gather their stuff in the supermarket
	 * 
	 * @param scanningTimeLower The least amount of time a checkout needs to scan a customers stuff
	 * @param scanningTimeUpper The greatest amount of time a checkout needs to scan a customers stuff
	 * 
	 * @param seed A start value for the RandomStreams to get the same result when using the same parameters and seed
	 */
	public SupermarketState(int checkoutTotal, int maxCustomersInStore, double arrivalLambda, double gatheringTimeLower,
			double gatheringTimeUpper, double scanningTimeLower, double scanningTimeUpper, long seed) {
		super();
		this.maxCustomersInStore = maxCustomersInStore;
		this.customerFactory = new CustomerFactory(1000);
		this.checkout = new Checkout(checkoutTotal);
		this.timeManager = new TimeManager(arrivalLambda, gatheringTimeLower, gatheringTimeUpper, scanningTimeLower,
				scanningTimeUpper, seed, this);
	}
	
	/**
	 * checks if there is room for a customer in the supermarket
	 * 
	 * @return True if there is room, otherwise false
	 */
	public boolean hasRoom() {
		return (this.maxCustomersInStore - this.numCustomersInStore) > 0;
	}

	/**
	 * Adds 1 customer to the customer in store statistic
	 */
	public void addCustomer() {
		numCustomersInStore += 1;
	}

	/**
	 * Adds 1 customer to the customersMissed Statistics. Also removes the Customer
	 * from the checkout.
	 */
	public void missedCustomer() {
		missedCustomers += 1;
	}

	/**
	 * Sets open to false so that the store closes
	 */
	public void close() {
		open = false;
	}

	/**
	 * checks if the store is open
	 * 
	 * @return open Returns true if open, otherwise false
	 */
	public boolean isOpen() {
		return open;
	}

	/**
	 * if called calls the stop method in simState
	 */
	public void stop() {
		super.stop();
	}
	
	/**
	 * Used by the view to get information about the checkouts
	 * 
	 * @return checkout Returns the checkout object 
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
	 * Returns the number of customers in the store
	 * 
	 * @return numCustomersInStore 
	 */
	public int getNumCustomersInStore() {
		return numCustomersInStore;
	}

	/**
	 * Returns the maximum amount of customers allowed in the store
	 * 
	 * @return maxCustomers 
	 */
	public int getMaxCustomersInStore() {
		return maxCustomersInStore;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public int getCustomersServed() {
		return customersServed;
	}

	public int getMissedCustomers() {
		return missedCustomers;
	}

	public double getQueueTimeTotal() {
		return queueTimeTotal;
	}

	public long getSeed() {
		return timeManager.getSeed();
	}

	public CustomerFactory getCustomerFactory() {
		return this.customerFactory;
	}

	public TimeManager getTimeManager() {
		return timeManager;
	}

	public boolean getStopped() {
		return stopped;
	}

	public Event nextEvent() {
		return nextEvent;
	}

	public double getFreeTime() {
		return freeTime; // Placeholder f�r att view ska kunna k�ras
	}

	private void setFreeTime(double addTime) {
		if(isOpen() || (!isOpen() && getNumCustomersInStore() != 0)){
            freeTime = freeTime + (addTime * (checkout.getCheckoutTotal() - checkout.getCheckoutsOccupied()));
        }
	}

	private void setQueueTimeTotal(double addTime) {
		if (!this.stopped) {
			queueTimeTotal = queueTimeTotal + (addTime * (checkout.getQueue().size()));
		}
	}

	public void update() {
		setFreeTime(time - previousTime);
		setQueueTimeTotal(time - previousTime);
		super.update();

	}

}
