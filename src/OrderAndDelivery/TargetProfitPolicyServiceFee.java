package OrderAndDelivery;
import Food.*;
import System.MyFoodora;
import User.*;

import java.io.Serializable ;

import Exceptions.*;
public class TargetProfitPolicyServiceFee implements TargetProfitPolicy,Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1270042720937004154L;

	/**
	 * Sets the service fee
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
		double deliveryCost = myFoodora.getDeliveryCost();
		
		double serviceFee = (targetProfit - totalIncome*markupPercentage)/numberOfOrders + deliveryCost; 
		if (totalIncome==0){
			throw (new NonReachableTargetProfitException("This target profit can not be reached"));
		}
		if (markupPercentage >= 0){
			return(serviceFee);
		}else{
			throw (new NonReachableTargetProfitException("This target profit can not be reached"));
		}
	}
}
