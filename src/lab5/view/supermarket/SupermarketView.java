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
		if (supermarketState.getStopped) { //Se till att den h�r g�rs
			
		} else if (supermarketState.getTime() ==  0d) {
			parameters(supermarketState);
		} else  { //Vill man g�ra s� h�r eller ha ett annat s�tt?
			running(supermarketState);
		}
	}
	
	private void parameters(SupermarketState supermarketState) {
		System.out.println("PARAMETRAR");
		System.out.println("__________________________");
		System.out.println("Antal kassor, N___________: " + supermarketState.getCheckoustsTotal()); //Checkout felstavat i supermarketState, v�rt att �ndra?
		System.out.println("Max personer i lokalen, M_: " + supermarketState.getMaxCostumers());
		System.out.println("Ankomst, M________________: " + supermarketState.getMaxCostumers());
		System.out.println("Ankomsthastighet, lambda__: " + supermarketState.getArrivalLambda());
		System.out.println("Plocktider, [Pmin, Pmax]__: [" + supermarketState.getGatherTimeLower() + "," + supermarketState.getGatherTimeUpper() + "]");
		System.out.println("Betaltider, [Bmin, Bmax]__: [" + supermarketState.getScanningTimeLower() + "," + supermarketState.getScanningTimeUpper() + "]");
		System.out.println("Fr�, f____________________: " + supermarketState.getSeed());
		System.out.println();
		System.out.println("F�RLOPP");
		System.out.println("_______");
		System.out.println(" TID H�NDELSE  KUND �PPET/ST�NGT FRIKASSOR FRIKASSETID KUNDANTAL KLARHANDLADE LEDSENKUNDER K�AT K�TID K�AR [K�N]");
		System.out.println("0,00 Start");
	}
	
	private void running(SupermarketState supermarketState) {
		String time = correctLengthDouble(supermarketState.getTime(), 5);
		String event = correctLengthString(supermarketState.getEvent(), 10); //Diskutera med andra s� getEvent finns och returnerar en str�ng
		String customer = correctLengthInt(supermarketState.getCostumer(), 5); //Kanske m�ste g�ra n�got annat f�r att f� ut numret?
		String open = correctLengthString((supermarketState.isOpen() ? "�ppet" : "St�ngt"), 13);
		String freeCheckouts = correctLengthInt(supermarketState.getCheckoutsTotal() - supermarketState.getCheckoutsOccupied(), 10);
		String freeTime = correctLengthDouble(supermarketState.getFreeTime(), 12); //Diskutera s� den ocks� finns
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
