package lab5.supermarket.events;

import lab5.generall.events.StopEvent;
import lab5.generall.state.SimState;
import lab5.generall.events.EventQueue;
import lab5.supermarket.state.SupermarketState;

/**
 * This event stop the supermarket simulation
 *
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 */
public class SupermarketStopEvent extends StopEvent {

	private final SupermarketState stateSuper;

	public SupermarketStopEvent(EventQueue eventQueue, SimState state, double executeTime) {
		super(eventQueue, state, executeTime);
		if (!(state instanceof SupermarketState)) {
			throw new RuntimeException("Invalid State");
		}
		this.stateSuper = ((SupermarketState) state);
	}

	@Override
	public void execute() {
		super.execute();
		stateSuper.stop();
	}
}
