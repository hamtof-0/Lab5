package lab5.state.supermarket;

public class Checkout {

    private int checkoutTotal;
    private int checkoutsOccupied;
    private FIFO checkoutQueue;

    public Checkout(int checkoutTotal) {
        this.checkoutTotal = checkoutTotal;
        this.checkoutsOccupied = 0;
        this.checkoutQueue = new FIFO();
    }

    public boolean isEmpty(){
        return checkoutsOccupied <= 0;
    }

    public boolean hasEmptyCheckout(){
        return checkoutsOccupied < checkoutTotal;
    }

    public void add(Customer customer){
        checkoutQueue.add(customer);
    }

    public void remove(){
        checkoutQueue.removeFirst();
    }
}
