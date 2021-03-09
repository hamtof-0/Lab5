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
		EventQueue queue = new EventQueue();
		queue.addEvent(new SupermarketStartEvent(queue, state, 0d));
		queue.addEvent(new SupermarketClosingEvent(queue, state, 10.0));
		queue.addEvent(new SupermarketStopEvent(queue, state, 99.0));
		System.out.println("2");
		SupermarketView view = new SupermarketView(state);
		System.out.println("3");
		state.addObserver(view);
		System.out.println("4");
		Simulator sim = new Simulator(state, queue);
		sim.run();
		System.out.println("5");
    }
}
