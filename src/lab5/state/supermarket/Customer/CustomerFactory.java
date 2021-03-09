package lab5.state.supermarket.Customer;

import lab5.state.supermarket.Customer.Customer;

public class CustomerFactory {
	private int maxNumberOfCustomers;
	private int createdSoFar;
	
	public CustomerFactory(int maxNumberOfCustomers) {
		super();
		this.maxNumberOfCustomers = maxNumberOfCustomers;
		createdSoFar = 0;
	}

	public Customer newCustomer() {
		if(!canCreate()) throw new RuntimeException("Max amount of customers has been created, amount created: " + createdSoFar+1);
		return new Customer(createdSoFar++); // first customer is 0
		// and it will continue until createdSoFar = maxNumberOfCustomers -1
	}

	public int getMax() {
		return maxNumberOfCustomers;
	}

	public boolean canCreate() {
		return createdSoFar < maxNumberOfCustomers;
	}
			
}
