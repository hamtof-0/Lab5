package lab5.state.supermarket;

import com.sun.istack.internal.NotNull;
import lab5.state.supermarket.Customer.Customer;

public class Checkout {

    private int checkoutTotal;
    private int checkoutsOccupied;
    private FIFO checkoutQueue;

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
    public void addToQueue(@NotNull Customer customer){
        checkoutQueue.add(customer);
    }

    /**
     * Used if at anypoint it is important to know what customer is getting served
     * @param customer the customer object getting served
     */
    public void serveCustomer(@NotNull Customer customer){
        serveCustomer(); // TODO: Change if actually needed
    }

    /**
     * Used if we don't track what customer is getting served.
     */
    public void serveCustomer(){
        if(!this.hasEmptyCheckout()) throw new RuntimeException("No empty checkouts to use!");
        if(!this.queueIsEmpty()) this.remove(); // someone is in the queue serve the first
        // Occupied a checkout
        checkoutsOccupied ++;
    }

    /**
     * Used if at anypoint it is important to know what customer was served
     * @param customer the customer object getting served
     */
    public void customerServed(@NotNull Customer customer){
        customerServed(); // TODO: Change if actually needed
    }

    /**
     * Used if we don't track what customer was served.
     */
    public void customerServed(){
        checkoutsOccupied --;
    }

    /**
     * Remove the first person from the queue
     */
    private void remove(){
        checkoutQueue.removeFirst();
    }
}
