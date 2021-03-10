package lab5.state.supermarket.Customer;

import lab5.state.supermarket.Customer.Customer;

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