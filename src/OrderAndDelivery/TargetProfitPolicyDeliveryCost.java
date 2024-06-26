package OrderAndDelivery;
import Food.*;
import System.MyFoodora;
import User.*;

import java.io.Serializable ;

import Exceptions.*;

public class TargetProfitPolicyDeliveryCost implements TargetProfitPolicy,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7262233904061450480L;

	/**
	 * Sets the delivery cost
	 * based on last month income
	 * to meet a target profit given the formula : profitForOneOrder = orderPrice * markupPercentage + serviceFee - deliveryCost 
	 * @param myFoodora : MyFoodora system
	 * @param targetProfit : the target profit to meet
	 */
	
	@Override
	public double meetTargetProfit (MyFoodora myFoodora, double targetProfit) throws NonReachableTargetProfitException {
		int numberOfOrders = myFoodora.getCompletedOrders().size();
		double totalIncome = myFoodora.totalIncomeLastMonth();
		double markupPercentage = myFoodora.getMarkupPercentage();
		double serviceFee = myFoodora.getServiceFee();
		
		double deliveryCost = - (targetProfit - totalIncome*markupPercentage)/numberOfOrders + serviceFee; 
		if (totalIncome==0){
			throw (new NonReachableTargetProfitException("This target profit can not be reached"));
		}
		if (markupPercentage >= 0){
			return(deliveryCost);
		}else{
			throw (new NonReachableTargetProfitException("This target profit can not be reached"));
		}
	}
}
