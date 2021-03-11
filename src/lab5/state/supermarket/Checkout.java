package lab5.state.supermarket;

import lab5.state.supermarket.Customer.Customer;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 * 
 * Used to keeps track of and hold most information about the checkouts  
 */

public class Checkout {

    private final int checkoutTotal;
    private int checkoutsOccupied;
    private final FIFO checkoutQueue;
    private int customersQueued = 0;
    
	/**
	 * Constructor 
	 * 
	 * Creates the checkout queue
	 * 
	 * @param checkoutTotal  the amount of checkouts in the simulation
	 */
    public Checkout(int checkoutTotal) {
        this.checkoutTotal = checkoutTotal;
        this.checkoutsOccupied = 0;
        this.checkoutQueue = new FIFO();
    }

    /**
     * Used to find if there is a empty checkout or not
     * @return true if empty, false otherwise
     */
    public boolean hasEmptyCheckout(){
        return checkoutsOccupied < checkoutTotal;
    }

    /**
     * Used to find if the checkoutQueue is empty or not
     * @return true if empty, false otherwise
     */
    public boolean queueIsEmpty(){
        return checkoutQueue.isEmpty();
    }

    /**
     * add a customer to the queue
     * @param customer the customer that should be placed in the checkout queue
     */
    public void addToQueue(Customer customer){
        checkoutQueue.add(customer);
        customersQueued++;
    }

    /**
     * add a customer to the queue
     * @param customer the customer that should be placed in the checkout queue
     */
    public Customer getFirstInQueue(){
        Customer firstInLine = (Customer) checkoutQueue.first();
        checkoutQueue.removeFirst();
        return firstInLine;
    }

    /**
     * Used if we don't track what customer is getting served.
     */
    public void serveCustomer(){
        if(!this.hasEmptyCheckout()) throw new RuntimeException("No empty checkouts to use!");
        // Occupied a checkout
        checkoutsOccupied ++;
    }

    /**
     * Used if we don't track what customer was served.
     */
    public void customerServed(){
        checkoutsOccupied --;
    }
    
	/**
	 * Returns the value of checkoutTotal
	 * 
	 * @return chechoutTotal The number of customers that has left the supermarket
	 */
    public int getCheckoutTotal() {
    	return checkoutTotal;
    }
    
	/**
	 * Returns the number of checkouts that are occupied
	 * 
	 * @return checkoutsOccupied The number of checkouts occupied
	 */
    public int getCheckoutsOccupied() {
    	return checkoutsOccupied;
    }
    
	/**
	 * Returns the number of customers queued
	 * 
	 * @return customersQueued The number of customers queued
	 */
    public int getCustomersQueued() {
    	return customersQueued;
    }
    
	/**
	 * Returns the checkout queue
	 * 
	 * @return checkoutQueue The checkoutQueue
	 */
    public FIFO getQueue() {
    	return checkoutQueue;
    }
}
