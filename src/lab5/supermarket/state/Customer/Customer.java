package lab5.supermarket.state.Customer;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 * 
 * A customer object that holds an id number
 */

public class Customer {
	private final int myNumber;
	
	/**
	 * Constructor 
	 * 
	 * Makes a new customer
	 */
	Customer(int number) {
		myNumber = number;
	}

	/**
	 * toString for the customers number
	 * 
	 * @return Returns the value of the customer id as a String
	 */
	@Override
	public String toString() {
		return String.valueOf(myNumber);
	}
}
