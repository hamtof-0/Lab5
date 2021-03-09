package lab5.state.supermarket;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FIFO{
	private List<Object> listaObject;
	private int maxsize;

	public FIFO() {
		listaObject = new ArrayList<Object>();
		maxsize = 0;
	}

	public void add(Object item) {
		listaObject.add(item);
		if (listaObject.size() > maxsize) {
			maxsize = listaObject.size();
		}
	}

	public void removeFirst() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		listaObject.remove(0);
	}

	public Object first() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return (listaObject.get(0));
	}

	public int maxSize() {
		return maxsize;
	}

	public boolean isEmpty() {
		if (listaObject.size() != 0) {
			return (false);
		}
		return (true);
	}

	public int size() {
		return (listaObject.size());
	}
	
	/* other version
	public boolean equals(Object f) {
        if (f instanceof FIFO) {
            FIFO argument = (FIFO) f;
            if (this.size() != argument.size()) { return false; }       // Not equal size
 
            for (int index = 0; index < this.size(); index++) {         // Loop values
 
                boolean thisNull = this.FIFOList.get(index) == null;            // improve readability
                boolean argumentNull = argument.FIFOList.get(index) == null;    // improve readability
 
                if (thisNull != argumentNull) {
                    return false; // Not equal (One is null other is a instantiated Object)
                } // Both are instantiated Object OR both are null
 
                if (!thisNull) { // Neither are null
 
                    if (!this.FIFOList.get(index).equals(argument.FIFOList.get(index))) {
                        return false; // false due to them not being equal
                    }
 
                } // both values are equal (either both null or both are the same object)
            }
        } else { // Not a FIFO Queue
            throw new ClassCastException("");
        }
        return true; // if this statement is reached it means that the FIFO Queues are equal to each other
    }
	*/
	
	public boolean equals(Object f) throws ClassCastException {
		if (f instanceof FIFO) {
			if (this.listaObject.size() == ((FIFO) f).listaObject.size()) {
				for (int i = 0; i < this.size(); i++) {
					if ((listaObject.get(i) == null) && ((FIFO) f).listaObject.get(i) == null) {
						continue;
					}
					if ((((FIFO) f).listaObject.get(i) != null
						
							&& this.listaObject.get(i) != null)
							
							&& (this.listaObject.get(i).equals(((FIFO) f).listaObject.get(i)))) {
						
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
		String leString = "Queue: ";
		for (Object elem : listaObject) {
			leString += ("(" + String.valueOf(elem) + ") ");
		}
		return leString;
	}
}

