package lab5.supermarketsimulation.state;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 * 
 * This is a simple FIFO queue
 */

public class FIFO{
	private final List<Object> objectList;
	private int maxsize;

	/**
	 * Constructor  
	 * 
	 * Makes a FIFO queue
	 */
	public FIFO() {
		objectList = new ArrayList<>();
		maxsize = 0;
	}
	
	/**
	 * Adds an object to the queue
	 * 
	 * @param item The object to put in the queue
	 */
	public void add(Object item) {
		objectList.add(item);
		if (objectList.size() > maxsize) {
			maxsize = objectList.size();
		}
	}
	/**
	 * Removes the first object in the queue
	 * 
	 * @throws NoSuchElementException exception if the queue is empty
	 */
	public void removeFirst() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		objectList.remove(0);
	}
	
	/**
	 * Gets the first object in the queue
	 * 
	 * @return Returns the first object in the queue
	 */
	public Object first() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return (objectList.get(0));
	}

	/**
	 * Checks if the queue is empty
	 * 
	 * @return Returns true if the queue is empty otherwise false
	 */
	public boolean isEmpty() {
		return objectList.size() == 0;
	}
	
	/**
	 * Returns the size of the queue
	 * 
	 * @return Returns the size of the queue
	 */
	public int size() {
		return (objectList.size());
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder("[");
		for (int i = 0; i < size(); i++) {
			string.append(objectList.get(i));
			if (i == objectList.size()-1){
				break;
			}
			string.append(",");
		}
		string.append("]");
		return string.toString();
	}
}

