package lab5;

import lab5.events.*;
import lab5.events.supermarket.SupermarketClosingEvent;
import lab5.events.supermarket.SupermarketStartEvent;
import lab5.events.supermarket.SupermarketStopEvent;
import lab5.state.supermarket.SupermarketState;
import lab5.view.supermarket.SupermarketView;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 * 
 * Tells the simultaor to start the simulation
 */
public class RunSim {

	/**
	 * Creates a state for the supermarket and tells the simulator to run
	 */
    public static void main(String[] args) {
		SupermarketState state = new SupermarketState(
				2,
				5,
				1.0D,
				0.5D,1.0D,
				2.D,3.0D,
				1234L);
		SupermarketView view = new SupermarketView(state);
		state.addObserver(view);
		Simulator sim = new Simulator(state);
		sim.run();
    }
}
