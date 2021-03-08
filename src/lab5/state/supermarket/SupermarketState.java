package lab5.state.supermarket;

import lab5.state.SimState;

public class SupermarketState extends SimState {
	
	private int numberOfCustomers;
	private int checkoutTotal;
	private int checkoutsOccupied;
	private int costumersServed;
	private boolean open;
	private int missedCustomers;
	private int customersQueued;
	private double queueTimeTotal;
	private int maxCostumers;
	private int seed;
	private CustomerFactory Costumer;
	private TimeManager timeManager;
	private Checkout checkout;
	
	public SupermarketState(int numberOfCustomers, int checkoutTotal, int costumersServed,
			boolean open, int missedCustomers, int customersQueued, double queueTimeTotal, int maxCostumers,
			int seed, ArrivalTime arrivalTime, GatherTime gatherTime, ScanningTime scanningTime,
			CustomerFactory costumer, double closingTime) {
		super();
		this.numberOfCustomers = numberOfCustomers;
		this.costumersServed = costumersServed;
		this.open = open;
		this.missedCustomers = missedCustomers;
		this.customersQueued = customersQueued;
		this.queueTimeTotal = queueTimeTotal;
		this.maxCostumers = maxCostumers;
		this.seed = seed;
		Costumer = costumer;
		this.checkout = new Checkout(checkoutTotal);
		this.timeManager = new TimeManager(0D, closingTime, seed);
	}
	
	//Here the TOString goes or might be in the SimView thingy
	@Override
	public String toString() {
		String leString = null;
		
		return leString;
	}
	
	//There are only getters and setters beyond this point

	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}

	public void setNumberOfCustomers(int numberOfCustomers) {
		this.numberOfCustomers = numberOfCustomers;
	}

	public int getCheckoutTotal() {
		return checkoutTotal;
	}

	public void setCheckoutTotal(int checkoutTotal) {
		this.checkoutTotal = checkoutTotal;
	}

	public int getCheckoutsOccupied() {
		return checkoutsOccupied;
	}

	public void setCheckoutsOccupied(int checkoutsOccupied) {
		this.checkoutsOccupied = checkoutsOccupied;
	}

	public int getCostumersServed() {
		return costumersServed;
	}

	public void setCostumersServed(int costumersServed) {
		this.costumersServed = costumersServed;
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

	public int getCustomersQueued() {
		return customersQueued;
	}

	public void setCustomersQueued(int customersQueued) {
		this.customersQueued = customersQueued;
	}

	public double getQueueTimeTotal() {
		return queueTimeTotal;
	}

	public void setQueueTimeTotal(double queueTimeTotal) {
		this.queueTimeTotal = queueTimeTotal;
	}

	public int getMaxCostumers() {
		return maxCostumers;
	}

	public void setMaxCostumers(int maxCostumers) {
		this.maxCostumers = maxCostumers;
	}

	public int getSeed() {
		return seed;
	}

	public void setSeed(int seed) {
		this.seed = seed;
	}

	public CustomerFactory getCostumer() {
		return Costumer;
	}

	public void setCostumer(CustomerFactory costumer) {
		Costumer = costumer;
	}

	public TimeManager getTimeManager(){
		return timeManager;
	}

	public boolean hasRoom(){
		return (this.maxCostumers - this.numberOfCustomers) > 0;
	}

	public void addCustomer(){
		numberOfCustomers += 1;
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

}
