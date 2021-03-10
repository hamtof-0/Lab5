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
 */
public class RunSim {

    public static void main(String[] args) {
		SupermarketState state = new SupermarketState(
				2,
				5,
				1234,
				10,
				2.0,
				3.0,
				0.5,
				1.0,
				1.0);
		SupermarketView view = new SupermarketView(state);
		state.addObserver(view);
		Simulator sim = new Simulator(state);
		sim.run();
    }
}
