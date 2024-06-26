package OrderAndDelivery;
import Food.*;
import User.*;
import System.*;



public interface DeliveryPolicy {
	
	/**
	 * Allocates a courier to the order according to one of the two policy : fastest delivery or fair-occupation delivery
	 * @param myFoodora : MyFoodora system
	 * @param order : the order which need to be allocated to a courier
	 */
	public abstract void allocateCourier(MyFoodora myFoodora, Order order);
}
