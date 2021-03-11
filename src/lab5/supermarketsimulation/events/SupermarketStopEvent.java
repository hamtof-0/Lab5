package lab5.supermarketsimulation.events;

import lab5.generalsimulation.events.StopEvent;
import lab5.generalsimulation.state.SimState;
import lab5.generalsimulation.events.EventQueue;
import lab5.supermarketsimulation.state.SupermarketState;

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
