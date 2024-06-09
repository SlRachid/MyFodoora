package SystemTests;
import User.*;
import Food.*;
import System.*;
import OrderAndDelivery.*;

import static org.junit.Assert.*;

import org.junit.*;


public class CourierTest {
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
	
	private static Courier courier;

	@BeforeClass
	public static void importMyFoodora(){
		myFoodora = MyFoodora.loadMyFoodora();
		try{
			restaurant = (Restaurant) myFoodora.login("hoki", "password");
			customer = (Customer) myFoodora.login("chaperouge", "qsdfghjkl");
			
			//we create an order
			order = new Order("Rachid",customer,new Location(1.0,2.0) , restaurant);
			//we fill the order with food items
			Dish dish = restaurant.findDishByName("brochettes boeuf");
			order.addDish(dish);
			Meal meal = restaurant.findMealByName("M3");
			order.addMeal(meal);
			//the customer submit the order
			order.submit(true, myFoodora);
			
			courier = order.getCourier();
		}catch(Exception e){}
	}

	@Test
	public void testGetBoard() {
		Interface board = courier.getBoard() ;
		
		//we check that the order is on the board
		System.out.println(board);
		System.out.println(courier);
	}
	
	@Test
	public void testAcceptDeliveryCall() throws OrderNotFoundException{
		courier = order.getCourier();
		//we store the previous counter of the courier
		int previousCounter = courier.getNumOfDeliveries();
				
		//the courier gets the call on his board : order of uniqueID 0
		Interface<Order> board = courier.getBoard();
		Order order = board.findObsById(1);
		
		//the courier accept the delivery call
		courier.acceptDeliveryCall(true, order, myFoodora);
		
		//we check that the counter of the courier has increased
		int currentCounter = courier.getNumOfDeliveries();
		assertEquals(previousCounter+1, currentCounter, 0);
		
		//we check that the board is now cleared
		System.out.println(board);
	}
	
	@Test
	public void testRefuseDeliveryCall() throws OrderNotFoundException{
		//we store the previous counter of the courier
		int previousCounter = courier.getNumOfDeliveries();
				
		//the courier gets the call on his board : order of uniqueID 0
		Interface<Order> board = courier.getBoard();
		Order order = board.findObsById(1);
		
		//the courier refuse the delivery call
		courier.acceptDeliveryCall(false, order, myFoodora);
		
		//we check that the counter of the courier has not increased
		int currentCounter = courier.getNumOfDeliveries();
		assertEquals (previousCounter, currentCounter, 0);
		
		//we check that the board is now cleared
		System.out.println(board);
		
		//we check that another courier has been allocated to the order
		Courier newCourier = order.getCourier();
		System.out.println(newCourier);
		assertTrue(!(newCourier.equals(courier))&&!(newCourier.equals(null)));
	}	
}
