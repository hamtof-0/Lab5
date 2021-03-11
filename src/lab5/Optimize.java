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
		System.out.println(varyLeastCheckouts(1400, 2000.0D, 0.45D, 0.65D, 0.2D, 0.3D, 42L, 20D, 100));
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
	
	//Gammal metod, den nya är lika effektiv med mycket mindre kod
	/*private static int leastCheckouts(int maxCustomers, double arrivalTime, double gatherMin, double gatherMax, double payMin,
			double payMax, long seed, double closingTime) {
		int optimalCheckouts = maxCustomers; 
		int increase = maxCustomers;
		int minMissed = RunSimReturnMissed(Integer.MAX_VALUE, maxCustomers, arrivalTime, gatherMin, gatherMax, payMin, payMax,
				seed, closingTime);
		//System.out.println(minMissed);
		for (int checkouts = 1; checkouts <= maxCustomers; checkouts = checkouts + increase) { //int checkouts = maxCustomers; checkouts > 1; checkouts--
			int oldIncrease = increase;
			while((checkouts + increase) > maxCustomers) {
				increase = (increase / 8);
			}
			if (increase == 0) {
				increase = 1;
			}
			int missed = RunSimReturnMissed(checkouts, maxCustomers, arrivalTime, gatherMin, gatherMax, payMin, payMax,
					seed, closingTime);
			System.out.println("1 " + checkouts + " " + increase + " " + missed + " " + minMissed);
			if (missed == minMissed) {
				int increase2 = increase / 8;
				if (increase2 == 0) {
					increase2 = 1;
				}
				for (int checkouts2 = (checkouts - oldIncrease) - 1; checkouts2 < maxCustomers; checkouts2 = checkouts2 + increase2) {
					if (checkouts2 < 0) {
						checkouts2 = 0;
					}
					System.out.println("2 " + checkouts2 + " " + increase2 + " " + missed + " " + minMissed);
					missed = RunSimReturnMissed(checkouts2, maxCustomers, arrivalTime, gatherMin, gatherMax, payMin, payMax,
							seed, closingTime);
					if (missed == minMissed) {
						for (int checkouts3 = (checkouts2 - increase2) - 2; checkouts3 < maxCustomers; checkouts3++) {
							if (checkouts3 < 0) {
								checkouts3 = 0;
							}
							missed = RunSimReturnMissed(checkouts3, maxCustomers, arrivalTime, gatherMin, gatherMax, payMin, payMax,
									seed, closingTime);
							System.out.println("3 " + checkouts3 + " " + increase2 + " " + missed + " " + minMissed);
							if (missed == minMissed) {
								optimalCheckouts = checkouts3;
								System.out.println(optimalCheckouts);
								break;
							}
						}
						break;
					}
				}
				break;
			}
		}
		System.out.println("Optimal: " + optimalCheckouts);
		return optimalCheckouts;
	}*/
	
	private static int leastCheckouts(int maxCustomers, double arrivalTime, double gatherMin, double gatherMax, double payMin,
			double payMax, long seed, double closingTime) {
		int optimalCheckouts = maxCustomers; 
		int increase = maxCustomers / 2;
		int minMissed = RunSimReturnMissed(Integer.MAX_VALUE, maxCustomers, arrivalTime, gatherMin, gatherMax, payMin, payMax,
				seed, closingTime);
		for (int checkouts = 1; checkouts <= maxCustomers; checkouts = checkouts + increase) {
			int missed = RunSimReturnMissed(checkouts, maxCustomers, arrivalTime, gatherMin, gatherMax, payMin, payMax,
					seed, closingTime);
			System.out.println("1 " + checkouts + " " + increase + " " + missed + " " + minMissed);
			if (missed == minMissed) {
				if (increase == 1) {
					optimalCheckouts = checkouts;
					break;
				}
				checkouts = checkouts - increase;
				increase = increase / 2;
				if (increase == 0) {
					increase = 1;
				}
			}
		}
		System.out.println("Optimal: " + optimalCheckouts);
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
			System.out.println("Working... " + loopsSinceLastChange);
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
