package lab5.state.supermarket;

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
		Customer customer = new Customer(totalNumberOfCustomers);
		return customer;
	}
			
}
