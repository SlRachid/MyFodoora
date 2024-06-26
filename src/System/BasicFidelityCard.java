package System;
import Food.*;
import OrderAndDelivery.*;
import User.*;

public class BasicFidelityCard extends FidelityCard {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7623597496037120413L;

	public BasicFidelityCard() {
		this.type = "basic" ;
	}
	
	/**
	 * computes the reduction of an order according to the fidelity points of the user
	 * @param order : the order submitted by the user
	 * @return reduction : the reduction which can be applied
	 */
	@Override
	public double computeReduction(Order order){
		double reduction = 0;
		return reduction;
	}
	/**
	 * applies the reduction calculated with computeReduction to the price of the order
	 * 		and remove the used fidelity points
	 * @param order : the order submitted by the user
	 */
	@Override
	public void applyReduction (Order order){
		double originalPrice = order.getPrice();
		double reduction = this.computeReduction(order);
		
		order.setPrice(originalPrice - reduction);
	}
	
	@Override
	public String toString(){
		return super.toString();
	}
}
