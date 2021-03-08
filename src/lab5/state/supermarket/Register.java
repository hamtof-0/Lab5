package lab5.state.supermarket;

public class Register {

    private int checkoutTotal;
    private int checkoutsOccupied;
    private FIFO checkoutQueue;

    public Register(int checkoutTotal) {
        this.checkoutTotal = checkoutTotal;
        this.checkoutsOccupied = 0;
        this.checkoutQueue = new FIFO();
    }

    public boolean isEmpty(){
        return checkoutsOccupied <= 0;
    }

    public void add(Customer customer){
        checkoutQueue.add(customer);
    }

    public void remove(){
        checkoutQueue.removeFirst();
    }
}
