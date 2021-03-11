package lab5;

import lab5.supermarketsimulation.events.SupermarketClosingEvent;
import lab5.supermarketsimulation.events.SupermarketStartEvent;
import lab5.supermarketsimulation.events.SupermarketStopEvent;
import lab5.generalsimulation.events.EventQueue;
import lab5.supermarketsimulation.state.SupermarketState;
import lab5.supermarketsimulation.view.SupermarketView;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 * 
 * Tells the simulator to start the simulation
 */
public class RunSim {

	/**
	 * Creates a state for the supermarket and tells the simulator to run
	 */
    public static void main(String[] args) {
    	///*/
		SupermarketState state = new SupermarketState(
				2,
				5,
				1.0D,
				0.5D,1.0D,
				2.D,3.0D,
				1234L);
    	/*/
    	SupermarketState state = new SupermarketState(
				2,
				7,
				3.0D,
				0.6D,0.9D,
				0.35,0.6,
				13L);

    	 /*/
    	EventQueue queue = new EventQueue();
    	queue.addEvent(new SupermarketStartEvent(queue, state, 0d));
    	queue.addEvent(new SupermarketClosingEvent(queue, state, 8D));
    	queue.addEvent(new SupermarketStopEvent(queue, state, 999.0));
		SupermarketView view = new SupermarketView(state);
		state.addObserver(view);
		Simulator sim = new Simulator(state, queue);
		sim.run();
    }
}
