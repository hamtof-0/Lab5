package lab5.view.supermarket;

import java.util.Observable;

import lab5.view.SimView;
import lab5.state.SimState;
import lab5.state.supermarket.SupermarketState;

public class SupermarketView extends SimView{

	private boolean printParameters = true;
	
	public SupermarketView(SimState state) {
		super(state);
	}
	
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
		System.out.println("Max personer i lokalen, M_: " + state.getCustomerFactory().getMax());
		System.out.println("Ankomsthastighet, lambda__: " + state.getTimeManager().getArrivalTime().getArrivalLambda());
		System.out.println("Plocktider, [Pmin, Pmax]__: [" + state.getTimeManager().getGatherTime().getLowerGatherTime() + "," + state.getTimeManager().getGatherTime().getUpperGatherTime() + "]");
		System.out.println("Betaltider, [Bmin, Bmax]__: [" + state.getTimeManager().getScanningTime().getLowerScanningTime() + "," + state.getTimeManager().getScanningTime().getUpperScanningTime() + "]");
		System.out.println("Frö, f____________________: " + state.getSeed());
		System.out.println();
		System.out.println("FÖRLOPP");
		System.out.println("_______");
		System.out.println("   Tid Händlese  Kund  ?  led    ledT    I    $    :-(    köat    köT    köar    [Kassakö..]");
		System.out.println("  0,00 Start");
	}
	
	private void running(SupermarketState state) {
		String result = "";
		String time = correctLengthDouble(state.getTimeManager().getTime(), 7);
		String event = correctLengthString(state.getEvent(), 13);
		String customer = correctLengthString(state.getCustomer().toString(), 3);
		String open = correctLengthString((state.isOpen() ? "Ö" : "S"), 5);
		String freeCheckouts = correctLengthInt(state.checkout().getCheckoutTotal() - state.checkout().getCheckoutsOccupied(), 5);
		String freeTime = correctLengthDouble(state.getFreeTime(), 8); //Just nu en placeholder
		String custumersNumber = correctLengthInt(state.getNumCustomersInStore(), 5);
		String customersFinished = correctLengthInt(state.getCustomersServed(), 6);
		String customersSad = correctLengthInt(state.getMissedCustomers(), 8);
		String customersQueued = correctLengthInt(state.checkout().getCustomersQueued(), 5);
		String customersQueuetime = correctLengthDouble(state.getQueueTimeTotal(), 11);
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
		System.out.println(correctLengthDouble(state.getTimeManager().getTime(), 5) + "Stop");
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
		//FIXME: Alltid 2 decimaler, samt numret ska förskutas åt vänster inte höger (tiondelar alltid på samma position)
		String s = Double.toString(d);
		String s2 = s;
		
		int numAfterComma = (s.length()-1) - s.indexOf(",");
		/*if (numAfterComma > 2) {
			s = "";
			for (int i = 0; i < s2.length() - numAfterComma + 2; i++) {
				s = s + s2.charAt(i);
			}
		}*/
		
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
