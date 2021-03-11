package lab5.supermarketsimulation.state.customer;

/**
 * A customer factory that creates new customers
 * 
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 * 
 * 
 */

public class CustomerFactory {
	private int createdSoFar;
	
	/**
	 * Constructor
	 *
	 */
	public CustomerFactory() {
		super();
		createdSoFar = 0;
	}

	/**
	 * Creates a new customer
	 * 
	 * @return Returns the new customer
	 */
	public Customer newCustomer() {
		return new Customer(createdSoFar++);
	}
			
}