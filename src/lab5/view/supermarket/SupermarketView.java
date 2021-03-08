package lab5.view.supermarket;

import java.util.Observable;

import lab5.view.SimView;
import lab5.state.SupermarketState;

public class SupermarketView extends SimView{

	public void update(Observable o, Object arg) {
		SupermarketState state = (SupermarketState)o;
		
		if (state.getTime() ==  0d) {
			parameters(state);
		}
	}
	
	private void parameters(SupermarketState state) {
		System.out.println("PARAMETRAR");
		System.out.println("__________________________");
		System.out.println("Antal kassor, N___________: " + state.getCheckoustsTotal()); //Checkout felstavat i state, värt att ändra?
		System.out.println("Max personer i lokalen, M_: " + state.getMaxCostumers());
		System.out.println("Ankomst, M________________: " + state.getMaxCostumers());
		System.out.println("Ankomsthastighet, lambda__: " + state.getArrivalLambda());
		System.out.println("Plocktider, [Pmin, Pmax]__: [" + state.getGatherTimeLower() + "," + state.getGatherTimeUpper() + "]");
		System.out.println("Betaltider, [Bmin, Bmax]__: [" + state.getScanningTimeLower() + "," + state.getScanningTimeUpper() + "]");
		System.out.println("Frö, f____________________: " + state.getSeed());
		System.out.println();
		System.out.println("FÖRLOPP");
		System.out.println("_______");
		System.out.println(" TID HÄNDELSE KUND ÖPPET/STÄNGT FRIKASSOR FRIKASSETID KUNDANTAL KLARHANDLADE LEDSENKUNDER KÖAT KÖTID KÖAR [KÖN]");
		System.out.println("0,00");
	}
}
