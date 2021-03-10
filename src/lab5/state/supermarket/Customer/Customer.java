package lab5.state.supermarket.Customer;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 */

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
