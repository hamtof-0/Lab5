package lab5.events;

import java.util.ArrayList;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 */
public class EventQueue {

    private ArrayList<Event> queue = new ArrayList<Event>();

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
            // checks from last event in queue to first event in queue
            for (int index = queue.size()-1; index >= 0; index--) {
                // assuming there are more events that execute before new than there are events that execute after
                // if this event executes after event at index place this event at index+1
                if (event.executeTime > queue.get(index).executeTime){
                    queue.add(index+1, event);
                    break;
                } else if (index == 0) { // if we reached the end of loop place it here
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

    /**
     * Gives the first event in the queue
     * @return The Event that is first in queue
     */
    public Event getFirst(){
        if(this.isEmpty())
            throw new RuntimeException("Queue is empty Unable to get next event");
        Event next = queue.get(0);
        removeFirst();
        return next;
    }

    /**
     * Removes the first event in the queue
     */
    public void removeFirst(){
        queue.remove(0);
    }

    /**
     * Gives the first event in the queue
     * @return The Event that is first in queue
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
