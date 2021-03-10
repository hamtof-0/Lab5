package lab5.view.supermarket;

import java.util.Observable;

import lab5.events.Event;
import lab5.events.StopEvent;
import lab5.events.supermarket.SupermarketEvent;
import lab5.events.supermarket.SupermarketStopEvent;
import lab5.view.SimView;
import lab5.state.SimState;
import lab5.state.supermarket.SupermarketState;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 * 
 * Prints information about a supermarket and its events to the console.
 */

public class SupermarketView extends SimView{

	private boolean printParameters = true;
	private static final double FIX_DECIMALS = 100;
	
	public SupermarketView(SimState state) {
		super(state);
	}
	
	/** 
	 * Called whenever something is changed in the state and prints information about this change
	 */
	
	public void update(Observable o, Object arg) {
		SupermarketState state = (SupermarketState)super.state;
		if (state.getStopped()) {
			endscreen(state);
			printParameters = !printParameters;
		} else if (printParameters) {
			parameters(state);
			printParameters = !printParameters;
		} else  { 
			running(state);
		}
	}
	
	private void parameters(SupermarketState state) {
		System.out.println("PARAMETRAR");
		System.out.println("__________________________");
		System.out.println("Antal kassor, N___________: " + state.checkout().getCheckoutTotal()); 
		System.out.println("Max personer i lokalen, M_: " + state.getMaxCustomersInStore());
		System.out.println("Ankomsthastighet, lambda__: " + state.getTimeManager().getArrivalLambda());
		System.out.println("Plocktider, [Pmin, Pmax]__: [" + state.getTimeManager().getLowerGatherTime() + "," + state.getTimeManager().getUpperGatherTime() + "]");
		System.out.println("Betaltider, [Bmin, Bmax]__: [" + state.getTimeManager().getLowerScanningTime() + "," + state.getTimeManager().getUpperScanningTime() + "]");
		System.out.println("Frö, f____________________: " + state.getSeed());
		System.out.println();
		System.out.println("FÖRLOPP");
		System.out.println("_______");
		System.out.println(" TID  HÄNDELSE  KUND ÖPPET/STÄNGT FRIKASSOR FRIKASSETID KUNDANTAL KLARHANDLADE LEDSENKUNDER KÖAT KÖTID KÖAR [KÖN]");
		System.out.println("0.00  Start");
	}
	
	private void running(SupermarketState state) {
		String result = "";
		Event next = state.nextEvent();
		String time = correctLengthDouble(next.getExecuteTime(), 6);
		if(next.getName().equals(new StopEvent().getName())){
			return;
		}
		String event = correctLengthString(next.getName(), 10);
		String customer;
		if(next instanceof SupermarketEvent){
			customer = correctLengthString(((SupermarketEvent) next).getCustomerID(), 5);
		} else {
			customer = correctLengthString("", 5);
		}
		String open = correctLengthString((state.isOpen() ? "Öppet" : "Stängt"), 13);
		String freeCheckouts = correctLengthInt(state.checkout().getCheckoutTotal() - state.checkout().getCheckoutsOccupied(), 10);
		String freeTime = correctLengthDouble(state.getFreeTime(), 12); //Just nu en placeholder
		String custumersNumber = correctLengthInt(state.getNumCustomersInStore(), 10);
		String customersFinished = correctLengthInt(state.getCustomersServed(), 13);
		String customersSad = correctLengthInt(state.getMissedCustomers(), 13);
		String customersQueued = correctLengthInt(state.checkout().getCustomersQueued(), 5);
		String customersQueuetime = correctLengthDouble(state.getQueueTimeTotal(), 6);
		String customersQueing = correctLengthInt(state.checkout().getQueue().size(), 5);
		String queue = state.checkout().getQueue().toString();
		
		if (state.getEvent().equals("Stänger")) {
			result = time + event + correctLengthString("-", 5) + open + freeCheckouts + freeTime + custumersNumber +
					customersFinished + customersSad + customersQueued + customersQueuetime + customersQueing + queue;
		} else {
			result = time + event + customer + open + freeCheckouts + freeTime + custumersNumber +
					customersFinished + customersSad + customersQueued + customersQueuetime + customersQueing + queue;
		}
		
		System.out.println(result);
	}
	
	private void endscreen(SupermarketState state) {
		System.out.println(correctLengthDouble(state.getTimeManager().getTime(), 6) + "Stop");
		System.out.println();
		System.out.println("RESULTAT");
		System.out.println("__________________________");
		System.out.println();
		System.out.println("1. " + (state.getCustomersServed() + state.getMissedCustomers()) + " personer försökte handla och\n " + 
		state.getCustomersServed() + " av dem fick plats i affären medan " + state.getMissedCustomers() + " fick gå till en konkurrent istället.");
		System.out.println();
		System.out.println("2. Kassorna var lediga i totalt " + correctLengthDouble(state.getFreeTime(), 5) + "t.e. \n"
				+ "Detta är " + correctLengthDouble((state.getFreeTime() / state.checkout().getCheckoutTotal()), 5) + "t.e. per kassaapparat.");
		System.out.println();
		System.out.println("3. " + state.checkout().getCustomersQueued() + " kunder behövde köa i totalt " + correctLengthDouble(state.getQueueTimeTotal(), 6) + "t.e. \n"
				+ "Detta är " + correctLengthDouble((state.getQueueTimeTotal() / state.checkout().getCustomersQueued()), 6) + "t.e. per person.");
	}
	
	private String correctLengthDouble(double d, int len) {
		//Säkra två decimaler
		int truncated = (int) Math.round((d*FIX_DECIMALS));
		d = ((double) truncated) / FIX_DECIMALS;

		String s = Double.toString(d);
		
		int numAfterComma = (s.length()-1) - (s.indexOf("."));
		if (numAfterComma == 1) {
			s = s + "0";
		}
		
		return correctLengthString(s, len);
	}
	
	private String correctLengthInt(int in, int len) {
		String s = Integer.toString(in);
		
		return correctLengthString(s, len);
	}
	
	private String correctLengthString (String s, int len) {
		if (s.length() == len) {
			return s;
		} else if (s.length() < len) {
			while (s.length() < len) {
				s = s + " ";
			}
			return s;
		} else {
			String s2 = s;
			s = "";
			for (int i = 0; i < len; i++) {
				s = s + s2.charAt(i);
			}
			return s;
		}
	}
}
