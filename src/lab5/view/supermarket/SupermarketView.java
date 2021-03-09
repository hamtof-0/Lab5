package lab5.view.supermarket;

import java.util.Observable;

import lab5.view.SimView;
import lab5.state.supermarket.SupermarketState;

public class SupermarketView extends SimView{

	
	public SupermarketView(SimState state) {
		super(state);
	}
	
	public void update(Observable o, Object arg) {
		if (!(o instanceof SupermarketState)) {
			throw new RuntimeException("Invalid State!");
		}
		SupermarketState state = (SupermarketState)o;
		if (state.getStopped) { //Se till att den h�r g�rs
			endscreen(state);
		} else if (state.getTime() ==  0d) {
			parameters(state);
		} else  { //Vill man g�ra s� h�r eller ha ett annat s�tt?
			running(state);
		}
	}
	
	private void parameters(SupermarketState state) {
		System.out.println("PARAMETRAR");
		System.out.println("__________________________");
		System.out.println("Antal kassor, N___________: " + state.getCheckoustsTotal()); //Checkout felstavat i state, v�rt att �ndra?
		System.out.println("Max personer i lokalen, M_: " + state.getMaxCostumers());
		System.out.println("Ankomst, M________________: " + state.getMaxCostumers());
		System.out.println("Ankomsthastighet, lambda__: " + state.getArrivalLambda());
		System.out.println("Plocktider, [Pmin, Pmax]__: [" + state.getGatherTimeLower() + "," + state.getGatherTimeUpper() + "]");
		System.out.println("Betaltider, [Bmin, Bmax]__: [" + state.getScanningTimeLower() + "," + state.getScanningTimeUpper() + "]");
		System.out.println("Fr�, f____________________: " + state.getSeed());
		System.out.println();
		System.out.println("F�RLOPP");
		System.out.println("_______");
		System.out.println(" TID H�NDELSE  KUND �PPET/ST�NGT FRIKASSOR FRIKASSETID KUNDANTAL KLARHANDLADE LEDSENKUNDER K�AT K�TID K�AR [K�N]");
		System.out.println("0,00 Start");
	}
	
	private void running(SupermarketState state) {
		String result = "";
		String time = correctLengthDouble(state.getTime(), 5);
		String event = correctLengthString(state.getEvent(), 10); //Diskutera med andra s� getEvent finns och returnerar en str�ng
		String customer = correctLengthInt(state.getCostumer(), 5); //Kanske m�ste g�ra n�got annat f�r att f� ut numret?
		String open = correctLengthString((state.isOpen() ? "�ppet" : "St�ngt"), 13);
		String freeCheckouts = correctLengthInt(state.getCheckoutsTotal() - state.getCheckoutsOccupied(), 10);
		String freeTime = correctLengthDouble(state.getFreeTime(), 12); //Diskutera s� den ocks� finns
		String custumersNumber = correctLengthInt(state.getNumberOfCustomers(), 10);
		String customersFinished = correctLengthInt(state.getCostumersServed(), 13);
		String customersSad = correctLengthInt(state.getMissedCustomers(), 13);
		String customersQueued = correctLengthInt(state.getCustomersQueued(), 5);
		String customersQueuetime = correctLengthDouble(state.getQueueTimeTotal(), 6);
		String customersQueing = correctLengthInt(state.getQueue().size(), 5);
		String queue = state.getQueue().toString();
		
		if (state.getEvent == "St�nger") {
			result = time + event + correctLengthString("-", 5) + open + freeCheckouts + freeTime + custumersNumber +
					customersFinished + customersSad + customersQueued + customersQueuetime + customersQueing + queue;
		} else {
			result = time + event + customer + open + freeCheckouts + freeTime + custumersNumber +
					customersFinished + customersSad + customersQueued + customersQueuetime + customersQueing + queue;
		}
		
		System.out.println(result);
	}
	
	private void endscreen(SupermarketState state) {
		System.out.println(correctLengthDouble(state.getTime(), 5) + "Stop");
		System.out.println();
		System.out.println("RESULTAT");
		System.out.println("__________________________");
		System.out.println();
		System.out.println("1. " + (state.getCostumersServed() + state.getMissedCostumers()) + " personer f�rs�kte handla och\n " + 
		state.getCostumersServed() + " av dem fick plats i aff�ren medan " + state.getCosumersMissed() + " fick g� till en konkurrent ist�llet.");
		System.out.println();
		System.out.println("2. Kassorna var lediga i totalt " + correctLengthDouble(state.getFreeTime(), 5) + "t.e. \n"
				+ "Detta �r " + correctLengthDouble((state.getFreeTime() / state.checkout.totalCheckouts()), 5) + "t.e. per kassaapparat."); //Fixa s� att checkout har den metoden
		System.out.println();
		System.out.println("3. " + state.getCustomersQueued() + " kunder beh�vde k�a i totalt " + correctLengthDouble(state.getQueueTimeTotal(), 6) + "t.e. \n"
				+ "Detta �r " + correctLengthDouble((state.getQueueTimeTotal() / state.getCustomersQueued()), 6) + "t.e. per person.");
	}
	
	private String correctLengthDouble(double d, int len) {
		String s = Double.toString(d);
		String s2 = s;
		
		int numAfterComma = (s.length()-1) - s.indexOf(",");
		if (numAfterComma > 2) {
			s = "";
			for (int i = 0; i < s2.length() - numAfterComma + 2; i++) {
				s = s + s2.charAt(i);
			}
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