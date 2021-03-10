package lab5.state.supermarket;

import lab5.state.SimState;
import lab5.state.supermarket.Customer.Customer;
import lab5.state.supermarket.Customer.CustomerFactory;
import lab5.state.supermarket.TimeManager.TimeManager;

public class SupermarketState extends SimState {

	private int numCustomersInStore = 0;
	private int maxCustomersInStore;
	private int customersServed = 0;
	private int missedCustomers = 0;
	private boolean open = true;
	private double queueTimeTotal = 0;
	private CustomerFactory customerFactory;
	private TimeManager timeManager;
	private Checkout checkout;
	private Customer currentCostumer;

	// Constructor
	public SupermarketState(int checkoutTotal,
							int maxCustomersInStore,
							double arrivalLambda,
							double gatheringTimeLower, double gatheringTimeUpper,
							double scanningTimeLower, double scanningTimeUpper,
							long seed,
							double closingTime) {
		super();
		this.maxCustomersInStore = maxCustomersInStore;
		this.customerFactory = new CustomerFactory(1000);
		this.checkout = new Checkout(checkoutTotal);
		this.timeManager = new TimeManager(arrivalLambda,
				gatheringTimeLower, gatheringTimeUpper,
				scanningTimeLower, scanningTimeUpper,
				seed,
				closingTime, time);
	}
	
	//Here the toString goes or might be in the SimView thingy
	public String toString() {
		return "SupermarketState";
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
		numCustomersInStore--;
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

	public int getMaxCustomersInStore() {
		return maxCustomersInStore;
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
	
	public void setCustomer(Customer costumer) {
		currentCostumer = costumer;
	}
	
	public String getCustomer() {
		if(currentCostumer != null) return currentCostumer.toString();
		else return "---";
	}
	
	public double getFreeTime() {
		return 0; //Placeholder f�r att view ska kunna k�ras
	}

}
