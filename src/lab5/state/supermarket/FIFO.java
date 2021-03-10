package lab5.state.supermarket;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FIFO{
	private final List<Object> objectList;
	private int maxsize;

	public FIFO() {
		objectList = new ArrayList<Object>();
		maxsize = 0;
	}

	public void add(Object item) {
		objectList.add(item);
		if (objectList.size() > maxsize) {
			maxsize = objectList.size();
		}
	}

	public void removeFirst() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		objectList.remove(0);
	}

	public Object first() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return (objectList.get(0));
	}

	public int maxSize() {
		return maxsize;
	}

	public boolean isEmpty() {
		if (objectList.size() != 0) {
			return (false);
		}
		return (true);
	}

	public int size() {
		return (objectList.size());
	}
	
	public boolean equals(Object f) throws ClassCastException {
		if (f instanceof FIFO) {
			if (this.objectList.size() == ((FIFO) f).objectList.size()) {
				for (int i = 0; i < this.size(); i++) {
					if ((objectList.get(i) == null) && ((FIFO) f).objectList.get(i) == null) {
						continue;
					}
					if ((((FIFO) f).objectList.get(i) != null
						
							&& this.objectList.get(i) != null)
							
							&& (this.objectList.get(i).equals(((FIFO) f).objectList.get(i)))) {
						
						continue;
					}

					return (false);
				}
				return (true);
			}
		} else {
			throw new ClassCastException();
		}
		return (false);
	}

	public String toString() {
		StringBuilder output = new StringBuilder("[");
		for (int i = 0; i < objectList.size(); i++) {
			output.append(String.valueOf(objectList.get(i)));
			if(i == objectList.size()-1) break;
			output.append(", ");
		}
		output.append(']');
		return String.valueOf(output);
	}
}

