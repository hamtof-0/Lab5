package lab5.events.supermarket;

import lab5.events.Event;
import lab5.events.EventQueue;
import lab5.state.SimState;
import lab5.state.supermarket.Customer;
import lab5.state.supermarket.SupermarketState;
import lab5.state.supermarket.TimeManager;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 */
public abstract class SupermarketEvent extends Event {

        protected Customer customer;
        protected SupermarketState stateSuper;
        protected TimeManager time;

        public SupermarketEvent(EventQueue eventQueue, SimState state, double executeTime, Customer customer) {
                super(eventQueue, state, executeTime);
                this.customer = customer;
                if (!(state instanceof SupermarketState)) throw new RuntimeException("Invalid State");
                this.stateSuper = ((SupermarketState) state);
                this.time = stateSuper.getTimeManager();
        }
        public SupermarketEvent(EventQueue eventQueue, SimState state, double executeTime) {
                super(eventQueue, state, executeTime);
                if (!(state instanceof SupermarketState)) throw new RuntimeException("Invalid State");
                this.stateSuper = ((SupermarketState) state);
                this.time = stateSuper.getTimeManager();
        }
}
