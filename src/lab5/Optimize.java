package lab5;

import java.util.Random;

import lab5.events.EventQueue;
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
public class Optimize {

	public static void main(String[] args) {
		System.out.println(varyLeastCheckouts(5, 1.0D, 0.5D, 1.0D, 2.D, 3.0D, 1234L, 10D, 100));
	}

	private static int RunSimReturnMissed(int checkoutNum, int maxCustomers, double arrivalTime, double gatherMin,
			double gatherMax, double payMin, double payMax, long seed, double closingTime) {
		SupermarketState state = new SupermarketState(checkoutNum, maxCustomers, arrivalTime, gatherMin, gatherMax,
				payMin, payMax, seed);
		EventQueue queue = new EventQueue();
		queue.addEvent(new SupermarketStartEvent(queue, state, 0d));
		queue.addEvent(new SupermarketClosingEvent(queue, state, closingTime));
		queue.addEvent(new SupermarketStopEvent(queue, state, 999.0));
		Simulator sim = new Simulator(state, queue);
		sim.run();
		return state.getMissedCustomers();
	}

	private static int leastCheckouts(int maxCustomers, double arrivalTime, double gatherMin, double gatherMax, double payMin,
			double payMax, long seed, double closingTime) {
		int optimalCheckouts = maxCustomers; // Ifall man vill få en effektivare metod kan man ta reda på vad minimalt
												// missade kunder kommer vara genom att köra en runSim men maxvärde på
												// kassor
		int minMissed = Integer.MAX_VALUE;
		for (int checkouts = 1; checkouts < maxCustomers; checkouts++) {
			int missed = RunSimReturnMissed(checkouts, maxCustomers, arrivalTime, gatherMin, gatherMax, payMin, payMax,
					seed, closingTime);
			if (missed < minMissed) {
				minMissed = missed;
				optimalCheckouts = checkouts;
			}
		}
		return optimalCheckouts;
	}

	private static int varyLeastCheckouts(int maxCustomers, double arrivalTime, double gatherMin, double gatherMax,
			double payMin, double payMax, long seed, double closingTime, int noChangeFor) {
		int loopsSinceLastChange = 0;
		int leastCheckouts = Integer.MIN_VALUE;
		Random randSeed = new Random(seed);
		while (loopsSinceLastChange < noChangeFor) { // noChangeFor ska sättas till 100
			int checkouts = leastCheckouts(maxCustomers, arrivalTime, gatherMin, gatherMax, payMin, payMax,
					randSeed.nextLong(), closingTime);
			if (checkouts > leastCheckouts) {
				leastCheckouts = checkouts;
				loopsSinceLastChange = 0;
			} else {
				loopsSinceLastChange++;
			}
		}
		return leastCheckouts;
	}
}
