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
				2, 			// Antal kassor, N..........:
				5, 	// Max som ryms, M..........: 7
				1234, 			 	// Frö, f...................: 13
				10,			// -------------------------:
				2.0,		// Betaltider, [K_min]......:
				3.0,		// Betaltider, [K_max]......:
				0.5,	// Plocktider, [P_min]......:
				1.0,	// Plocktider, [P_max]......:
				1.0);		// Ankomshastighet, lambda..:
		SupermarketView view = new SupermarketView(state);
		state.addObserver(view);
		Simulator sim = new Simulator(state);
		sim.run();
    }
}
