package lab5.view.supermarket;

import java.util.Observable;

import lab5.state.SimState;
import lab5.view.SimView;
import lab5.state.supermakrket.SupermakrketState;

public class SupermarketView extends SimView{

	public SupermarketView(SimState state) {
		super(state);
	}

	public void update(Observable o, Object arg) {
		if (state instanceof SupermakrketState)
		SupermarketState supermarketState = (SupermarketState) state;
		if (supermarketState.getStopped) { //Se till att den här görs
			
		} else if (supermarketState.getTime() ==  0d) {
			parameters(supermarketState);
		} else  { //Vill man göra så här eller ha ett annat sätt?
			running(supermarketState);
		}
	}
	
	private void parameters(SupermarketState supermarketState) {
		System.out.println("PARAMETRAR");
		System.out.println("__________________________");
		System.out.println("Antal kassor, N___________: " + supermarketState.getCheckoustsTotal()); //Checkout felstavat i supermarketState, värt att ändra?
		System.out.println("Max personer i lokalen, M_: " + supermarketState.getMaxCostumers());
		System.out.println("Ankomst, M________________: " + supermarketState.getMaxCostumers());
		System.out.println("Ankomsthastighet, lambda__: " + supermarketState.getArrivalLambda());
		System.out.println("Plocktider, [Pmin, Pmax]__: [" + supermarketState.getGatherTimeLower() + "," + supermarketState.getGatherTimeUpper() + "]");
		System.out.println("Betaltider, [Bmin, Bmax]__: [" + supermarketState.getScanningTimeLower() + "," + supermarketState.getScanningTimeUpper() + "]");
		System.out.println("Frö, f____________________: " + supermarketState.getSeed());
		System.out.println();
		System.out.println("FÖRLOPP");
		System.out.println("_______");
		System.out.println(" TID HÄNDELSE  KUND ÖPPET/STÄNGT FRIKASSOR FRIKASSETID KUNDANTAL KLARHANDLADE LEDSENKUNDER KÖAT KÖTID KÖAR [KÖN]");
		System.out.println("0,00 Start");
	}
	
	private void running(SupermarketState supermarketState) {
		String time = correctLengthDouble(supermarketState.getTime(), 5);
		String event = correctLengthString(supermarketState.getEvent(), 10); //Diskutera med andra så getEvent finns och returnerar en sträng
		String customer = correctLengthInt(supermarketState.getCostumer(), 5); //Kanske måste göra något annat för att få ut numret?
		String open = correctLengthString((supermarketState.isOpen() ? "Öppet" : "Stängt"), 13);
		String freeCheckouts = correctLengthInt(supermarketState.getCheckoutsTotal() - supermarketState.getCheckoutsOccupied(), 10);
		String freeTime = correctLengthDouble(supermarketState.getFreeTime(), 12); //Diskutera så den också finns
		String custumersNumber = correctLengthInt(supermarketState.getNumberOfCustomers(), 10);
		String customersFinished = correctLengthInt(supermarketState.getCostumersServed(), 13);
		String customersSad = correctLengthInt(supermarketState.getMissedCustomers(), 13);
		String customersQueued = correctLengthInt(supermarketState.getCustomersQueued(), 5);
		String customersQueuetime = correctLengthDouble(supermarketState.getQueueTimeTotal(), 6);
		String customersQueing = correctLengthInt(supermarketState.getQueue().size(), 5);
		String queue = supermarketState.getQueue().toString();
		
		String result = time + event + customer + open + freeCheckouts + freeTime + custumersNumber +
				customersFinished + customersSad + customersQueued + customersQueuetime + customersQueing + queue;
		
		System.out.println(result);
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
