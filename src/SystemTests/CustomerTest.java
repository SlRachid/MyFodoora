package SystemTests;
import User.*;
import Food.*;
import System.*;
import OrderAndDelivery.*;

import static org.junit.Assert.*;

import org.junit.*;

import java.util.ArrayList;

public class CustomerTest {
	private static MyFoodora myFoodora;
	/**
	 * we create an example of restaurant that will be used in the following tests
	 */
	private static Restaurant restaurant;
	/**
	 * we create an example of customer that will be used in the following tests
	 */
	private static Customer customer;
	/**
	 * we create an example of order that will be used in the following tests
	 */
	private static Order order;

	@BeforeClass
	public static void importMyFoodora(){
		myFoodora = MyFoodora.loadMyFoodora();
		try{
			restaurant = (Restaurant) myFoodora.login("fo_pizza", "123");
			customer = (Customer) myFoodora.login("AG", "password1");
			
			//we create an order
			order = new Order("Ali",customer,new Location(1.0,2.0) , restaurant);
			//we fill the order with food items
			Dish dish = restaurant.findDishByName("Veggie pizza");
			order.addDish(dish);
			Meal meal = restaurant.findMealByName("Family Pizza Feast");
			order.addMeal(meal);
			
		}catch(Exception e){}
	}
		
	@Test
	public void testDisplayFidelityInfo() {
		customer.displayFidelityInfo();
	}

	@Test
	public void testGetHistoryOfOrders() {
		ArrayList<Order> pastOrders = customer.getHistoryOfOrders(myFoodora);
		System.out.println(pastOrders);
	}

	@Test
	public void testSubmitOrder() {
		//the customer submit the order
		customer.addOrder(order, true, myFoodora);
		System.out.println(order);
	}

	@Test
	public void testPayOrder() {
		//the courier accept the delivery call
		order.getCourier().acceptDeliveryCall(true, order, myFoodora);
		//the customer pays the price of the order
		customer.payOrder(order);
		//we check that the order is in completed orders of myFoodora
		assertTrue(myFoodora.getCompletedOrders().contains(order));
		
	}
	
	@Test
	public void testRegisterFidelityCard() {
		//the customer change of Fidelity Card Plan
		customer.registerFidelityCard("lottery");
		customer.displayFidelityInfo();
	}

}
