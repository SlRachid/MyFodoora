package OrderAndDelivery;
import Food.*;
import User.*;
import System.*;

import java.io.Serializable ;

public class FairOccupationDeliveryPolicy implements DeliveryPolicy,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6928498192380082879L;

	public FairOccupationDeliveryPolicy() {
	}

	@Override
	public void allocateCourier(MyFoodora myFoodora, Order order) {

		Courier chosenCourier = null;
		//nbOfCompletedDeliveriesMin is initiated to infinite
		int nbOfCompletedDeliveriesMin = 999999999;
		
		for (User user: myFoodora.getUsers()){
			if (user instanceof Courier){
				Courier courier = (Courier)user;
				int nbOfCompletedDeliveries = courier.getNumOfDeliveries();
				
				if (courier.isOnDuty()&&(nbOfCompletedDeliveries < nbOfCompletedDeliveriesMin)){
					chosenCourier = courier;
					nbOfCompletedDeliveriesMin = nbOfCompletedDeliveries ;
				}
			}
		}
		order.setCourier(chosenCourier);
	}
}
