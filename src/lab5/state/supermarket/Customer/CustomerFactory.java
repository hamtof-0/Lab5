package lab5.state.supermarket.Customer;

import lab5.state.supermarket.Customer.Customer;

public class CustomerFactory {
	private int maxNumberOfCustomers;
	private int totalNumberOfCustomers;
	
	public CustomerFactory(int maxNumberOfCustomers) {
		super();
		this.maxNumberOfCustomers = maxNumberOfCustomers;
		totalNumberOfCustomers = 0;
	}

	public Customer newCustomer() {
		totalNumberOfCustomers++;
		return new Customer(totalNumberOfCustomers);
	}

	public int getMax() {
		return maxNumberOfCustomers;
	}
			
}
