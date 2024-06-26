package System;
import Food.*;
import OrderAndDelivery.*;
import User.*;

import java.io.Serializable ;

public class FidelityCardFactory implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4803058272557334495L;

	public FidelityCardFactory() {
	}
	
	/**
	 * creates a Fidelity Card of a given type : BasicFidelityCard, PointFidelityCard, LotteryFidelityCard or Null to unregister
	 * @param cardType : "basic", "point", "lottery" or "none" to unregister
	 * @return fidelityCard : the Fidelity Card created
	 */
	public FidelityCard createFidelityCard (String cardType){
		FidelityCard fidelityCard = null;
		
		switch(cardType){
			case("basic"):
				fidelityCard = new BasicFidelityCard();
				break;
			case("point"):
				fidelityCard = new PointFidelityCard();
				break;
			case("lottery"):
				fidelityCard = new LotteryFidelityCard();
				break;
			default: break;
		}
		return fidelityCard;
	}
}
