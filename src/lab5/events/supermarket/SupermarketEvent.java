package lab5.events.supermarket;

import lab5.events.Event;
import lab5.events.EventQueue;
import lab5.state.SimState;
import lab5.state.supermarket.Customer;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 */
public abstract class SupermarketEvent extends Event {

        protected Customer customer;

        public SupermarketEvent(EventQueue eventQueue, SimState state, double executeTime, Customer customer) {
                super(eventQueue, state, executeTime);
                this.customer = customer;
        }
}
