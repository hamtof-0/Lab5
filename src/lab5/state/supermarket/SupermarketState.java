package lab5.state.supermarket;

import lab5.state.SimState;
import lab5.state.supermarket.Customer.CustomerFactory;

public class SupermarketState extends SimState {
	
	private int numCustomersInStore = 0;
	private int customersServed = 0;
	private int missedCustomers = 0;
	private boolean open = true;
	private double queueTimeTotal = 0;
	private CustomerFactory customerFactory;
	private TimeManager timeManager;
	private Checkout checkout;
	private String currentEvent = "";
	private int currentCostumer;

	// Constructor
	public SupermarketState(int checkoutTotal,
							int maxCostumers,
							long seed,
							double closingTime,
							double scanningTimeLower,
							double scanningTimeUpper,
							double gatheringTimeLower,
							double gatheringTimeUpper,
							double arrivalLambda) {
		super();
		this.customerFactory = new CustomerFactory(maxCostumers);
		this.checkout = new Checkout(checkoutTotal);
		this.timeManager = new TimeManager(0D	, closingTime, seed	,
								scanningTimeLower	, scanningTimeUpper	,
								gatheringTimeLower	, gatheringTimeUpper,
								arrivalLambda);
	}
	
	//Here the toString goes or might be in the SimView thingy
	public String toString() {
		return null;
	}

	public boolean hasRoom(){
		return (this.customerFactory.getMax() - this.numCustomersInStore) > 0;
	}

	public void addCustomer(){
		numCustomersInStore += 1;
	}

	public void missedCustomer(){
		missedCustomers += 1;
	}

	public void close(){
		open = false;
	}

	public boolean isOpen() {
		return open;
	}

	public void stop(){
		super.stop();
	}

	public Checkout checkout(){
		return this.checkout;
	}

	/**
	 * Adds 1 customer to the customersServed Statistics.
	 * Also removes the Customer from the checkout.
	 */
	public void addSale(){
		customersServed++;
		checkout.customerServed();
	}

	/**
	 * Adds 1 customer to the customersMissed Statistics.
	 * Also removes the Customer from the checkout.
	 */
	public void addMissed(){
		missedCustomers++;
	}

	//There are only getters and setters beyond this point

	public int getNumCustomersInStore() {
		return numCustomersInStore;
	}

	public void setNumCustomersInStore(int numCustomersInStore) {
		this.numCustomersInStore = numCustomersInStore;
	}

	public int getCustomersServed() {
		return customersServed;
	}

	public void setCustomersServed(int customersServed) {
		this.customersServed = customersServed;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public int getMissedCustomers() {
		return missedCustomers;
	}

	public void setMissedCustomers(int missedCustomers) {
		this.missedCustomers = missedCustomers;
	}

	public double getQueueTimeTotal() {
		return queueTimeTotal;
	}

	public void setQueueTimeTotal(double queueTimeTotal) {
		this.queueTimeTotal = queueTimeTotal;
	}

	public long getSeed() {
		return timeManager.getSeed();
	}

	public void setSeed(long seed) {
		timeManager.setSeed(seed);
	}

	public void setCustomerFactory(CustomerFactory customerFactory) {
		this.customerFactory = customerFactory;
	}

	public CustomerFactory getCustomerFactory() {
		return this.customerFactory;
	}

	public TimeManager getTimeManager(){
		return timeManager;
	}
	
	public boolean getStopped() {
		return stopped;
	}
	
	public void setEvent(String event) {
		currentEvent = event;
	}
	
	public String getEvent() {
		return currentEvent;
	}
	
	public void setCustomer(int costumer) {
		currentCostumer = costumer;
	}
	
	public int getCustomer() {
		return currentCostumer;
	}
	
	public double getFreeTime() {
		return 0; //Placeholder f�r att view ska kunna k�ras
	}

}
