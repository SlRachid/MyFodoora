package SystemTests;
import User.*;
import Food.*;
import System.*;
import OrderAndDelivery.*;


public class MyFoodora_ini {

	public MyFoodora_ini() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
			//we create an empty myFoodora
			double serviceFee = 10;
			double markupPercentage = 0.05;
			double deliveryCost = 5;
			MyFoodora myFoodora = new MyFoodora(serviceFee, markupPercentage, deliveryCost);
			myFoodora.saveMyFoodora();

	}

}
