package lab5.state.supermarket.Customer;

public class Customer {
	private final int myNumber;
	
	Customer(int number) {
		myNumber = number;
	}

	@Override
	public String toString() {
		return String.valueOf(myNumber);
	}
}
