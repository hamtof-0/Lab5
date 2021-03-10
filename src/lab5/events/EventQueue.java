package lab5.events;

import java.util.ArrayList;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 *
 * The generic event queue
 */
public class EventQueue {

    private final ArrayList<Event> queue = new ArrayList<Event>();

    /**
     * Adds the given event to this EventQueue in its correct place
     * by looping and comparing when the event shall execute.
     * @param event the event that needs to be added.
     */
    public void addEvent(Event event){
    	if (isEmpty()){
    	    queue.add(event);
        } else if (event.executeTime > queue.get(queue.size()-1).executeTime) {
            queue.add(event);
        } else {
            for (int index = queue.size()-1; index >= 0; index--) {
                if (event.executeTime > queue.get(index).executeTime){
                    queue.add(index+1, event);
                    break;
                } else if (index == 0) {
                    queue.add(index, event);
                    break;
                }
            }
    	}
    }

    /**
     * Gives the first event in the queue
     * @return The Event that is first in queue
     */
    public Event getNextEvent(){
        if(this.isEmpty())
            throw new RuntimeException("Queue is empty Unable to get next event");
        Event next = queue.get(0);
        removeFirst();
        return next;
    }

    /* Verkar vara exakt likadan som ovanstående metod och tror aldrig den används(?)
    public Event getFirst(){
        if(this.isEmpty())
            throw new RuntimeException("Queue is empty Unable to get next event");
        Event next = queue.get(0);
        removeFirst();
        return next;
    }*/

    /**
     * Removes the first event in the queue
     */
    public void removeFirst(){
        queue.remove(0);
    }

    /**
     * Returns if the queue is empty or not
     * @return returns true if the size of the queue is 0, else returns false
     */
    public boolean isEmpty(){
        return queue.size() <= 0;
    }

    @Override
    public String toString() {
        return "EventQueue{" +
                "queue=" + queue.toString() +
                '}';
    }
}
