package lab5;

import java.util.Random;

import lab5.generalsimulation.events.EventQueue;
import lab5.supermarketsimulation.events.SupermarketClosingEvent;
import lab5.supermarketsimulation.events.SupermarketStartEvent;
import lab5.supermarketsimulation.events.SupermarketStopEvent;
import lab5.supermarketsimulation.state.SupermarketState;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 * 
 * Used to optimize the supermarket so we can feed the capitalist world
 */
public class Optimize {

	public static void main(String[] args) {
		
//		System.out.println(leastCheckouts(K.M, K.L, K.LOW_COLLECTION_TIME, K.HIGH_COLLECTION_TIME, K.LOW_PAYMENT_TIME,
//				K.HIGH_PAYMENT_TIME, K.SEED, K.END_TIME));
		
		nicePrinting(K.M, K.L, K.LOW_COLLECTION_TIME, K.HIGH_COLLECTION_TIME, K.LOW_PAYMENT_TIME,
				K.HIGH_PAYMENT_TIME, K.SEED, K.END_TIME, 100);
		
//		nicePrinting(5, 1.0D, 0.5D, 1.0D, 2.D, 3.0D, 1234L, 10D, 100);
//		nicePrinting(1400, 2000.0D, 0.45D, 0.65D, 0.2D, 0.3D, 42L, 20D, 100);
	}
	
	private static void nicePrinting (int maxCustomers, double arrivalTime, double gatherMin, double gatherMax,
			double payMin, double payMax, long seed, double closingTime, int noChangeFor) {
		System.out.println("Max personer i lokalen, M_: " + maxCustomers);
		System.out.println("Ankomsthastighet, lambda__: " + arrivalTime);
		System.out.println("Plocktider, [Pmin, Pmax]__: [" + gatherMin + "," + gatherMax + "]");
		System.out.println("Betaltider, [Bmin, Bmax]__: [" + payMin + "," + payMax + "]");
		System.out.println("Frö, f____________________: " + seed);
		System.out.println("Stängning_________________: " + closingTime + " t.e.");
		System.out.println();
		System.out.println("Minsta antal kassor för minsta antal missade = " + varyLeastCheckouts(maxCustomers, arrivalTime, gatherMin, gatherMax, payMin, payMax, seed, closingTime, noChangeFor));
	}

	/**
	 * Runs simulation with the given parameters
	 * @param checkoutNum number of checkouts available
	 * @param maxCustomers max number of customer allowed in the store
	 * @param arrivalTime the random delay between customer arrivals
	 * @param gatherMin the minimum time needed to gather all merchandise
	 * @param gatherMax the maximum time needed to gather all merchandise
	 * @param payMin the minimum time needed to pay for the merchandise
	 * @param payMax the maximum time needed to pay for the merchandise
	 * @param seed the seed to create a new run each tim or the same if the same seed is given
	 * @param closingTime when the store will close
	 * @return returns the amount of customers we missed due to store being full.
	 */
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
	
	//Gammal metod, den nya �r lika effektiv med mycket mindre kod
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
		int optimalCheckouts = maxCustomers; // Bassfall alla kunder sliper köa
		int increase = maxCustomers / 2; // Förändring på halva
		int minMissed = RunSimReturnMissed(Integer.MAX_VALUE, maxCustomers, arrivalTime, gatherMin, gatherMax, payMin, payMax,
				seed, closingTime); // the minimum of missed customers if the store is given ALOT of checkouts
		for (int checkouts = 1; checkouts <= maxCustomers; checkouts = checkouts + increase) {
			// if checkouts are equal to max customers no need to increase.
			int missed = RunSimReturnMissed(checkouts, maxCustomers, arrivalTime, gatherMin, gatherMax, payMin, payMax,
					seed, closingTime);
			//System.out.println("1 " + checkouts + " " + increase + " " + missed + " " + minMissed);
			if (missed == minMissed) {
				if (increase == 1) { // if increase has reached 1 that means we are a maximum of 1 away from correct answerd
					optimalCheckouts = checkouts; // we will assume this is the optimal
					break;
				}
				checkouts = checkouts - increase; // if they missed is equal to minMissed
				// we can decrease the amount of checkouts
				increase = increase / 2; // decrease the increase to half of previous for binary search.
				if (increase == 0) { // ensure the minimum increase is always 1
					increase = 1;
				}
			}
		}
		//System.out.println("Optimal: " + optimalCheckouts);
		return optimalCheckouts;
	}

	private static int varyLeastCheckouts(int maxCustomers, double arrivalTime, double gatherMin, double gatherMax,
			double payMin, double payMax, long seed, double closingTime, int noChangeFor) {
		int loopsSinceLastChange = 0; // default to zero
		int leastCheckouts = Integer.MIN_VALUE;  // assume the least amount is Integer.Min_value because you cannot get any lower
		Random randSeed = new Random(seed); // generates the seed to use for the next simulation
		while (loopsSinceLastChange < noChangeFor) { // needs to be unchanged for at least 100 runs
			int checkouts = leastCheckouts(maxCustomers, arrivalTime, gatherMin, gatherMax, payMin, payMax,
					randSeed.nextLong(), closingTime); // gets the least required on this seed
			//System.out.println("Working... " + loopsSinceLastChange); // prints how many loops it has done so far
			if (checkouts > leastCheckouts) { // if checkouts are bigger than last
				leastCheckouts = checkouts; // update it
				loopsSinceLastChange = 0; // and reset
			} else {
				loopsSinceLastChange++; // leastCheckouts is bigger than the new so continue
			}
		}
		return leastCheckouts;
	}
}
