package OrderAndDelivery;
import Food.*;
import User.*;
import System.*;

import java.io.Serializable ;

public class FastestDeliveryPolicy implements DeliveryPolicy,Serializable {

	private static final long serialVersionUID = 776446129127381700L;

	public FastestDeliveryPolicy() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Allocates a courier to the order according to the fastest delivery 
	 * @param myFoodora : MyFoodora system
	 * @param order : the order which need to be allocated to a courier
	 */

	@Override
	public void allocateCourier(MyFoodora myFoodora, Order order) {
		//the address of delivery
		double xOrder = order.getDeliveryAddress().getX();
		double yOrder = order.getDeliveryAddress().getY();
		
		Courier chosenCourier = null;
		//distanceMin is initiated to plus infinity
		double distanceMin = Double.POSITIVE_INFINITY;
		
		for (User user: myFoodora.getUsers()){
			if (user instanceof Courier){
				Courier courier = (Courier)user;
				double x = courier.getPosition().getX();
				double y = courier.getPosition().getY();
				//the distance between the address of delivery and the position of the courier 
				double distance = Math.pow(Math.pow(x-xOrder, 2)+Math.pow(y-yOrder, 2), 0.5);
				
				if (courier.isOnDuty()&& (distance < distanceMin)){
					chosenCourier = courier;
					distanceMin = distance ;
				}
			}
		}
		order.setCourier(chosenCourier);
	}
}
