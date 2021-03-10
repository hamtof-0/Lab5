package lab5.state.supermarket.Customer;

import lab5.state.supermarket.Customer.Customer;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 */

public class CustomerFactory {
	private int createdSoFar;
	
	public CustomerFactory(int maxNumberOfCustomers) {
		super();
		createdSoFar = 0;
	}

	public Customer newCustomer() {
		return new Customer(createdSoFar++);
	}
			
}