package lab5.events;

import java.util.ArrayList;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 */
public class EventQueue {

    private ArrayList<Event> queue;

    /**
     * Adds the given event to this EventQueue then sorts the list to place events in their correct spot
     * @param event the event that needs to be added
     */
    public void addEvent(Event event){
        queue.add(event);
        sortQueue();
        // TODO: Smart add, if we assume that all items in the list are sorted than we just need to find a spot
        // TODO: where the event at index n has a executeTime that is < than this event
        // TODO: but the event at index n+1 has a executeTime > than this event
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
     * Removes the first event in the queue
     */
    public void removeFirst(){
        queue.remove(0);
    }

    /**
     * sorts the queue in order of executeTime Low -> High
     */
    public void sortQueue(){
        // FIXME: This is not needed if the smartAdd is implemented (check above)
        // TODO: sort queue by using Event variable executeTime low -> high
    }

    /**
     * Gives the first event in the queue
     * @return The Event that is first in queue
     */
    public boolean isEmpty(){
        return queue.size() <= 0;
    }
}
