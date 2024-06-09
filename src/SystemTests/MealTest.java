package SystemTests;
import User.*;
import Food.*;
import System.*;
import OrderAndDelivery.*;

import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.*;

public class MealTest {
	
	private static MyFoodora myFoodora;
	private static Meal fullMeal;
	private static Meal halfMeal;
	private static Restaurant restaurant;
	
	@BeforeClass
	public static void importMyFoodora(){
		myFoodora = MyFoodora.loadMyFoodora();
		try{
			restaurant = (Restaurant) myFoodora.login("fo_pizza", "123");
			halfMeal = restaurant.findMealByName("Special Pizza Combo");
			fullMeal = restaurant.findMealByName("Family Pizza Feast");
		}catch(Exception e){}
	}
	
	@Test
	public void testMealString() {
		System.out.println(halfMeal);
		System.out.println(fullMeal);
	}	

	@Test
	public void testComputePrice() {
	    double price = fullMeal.getPrice();
	    String formattedPrice = String.format(Locale.US, "%.2f", price);
	    assertEquals("the price of meal \"Family Pizza Feast\" is 21.33", Double.parseDouble(formattedPrice), 21.33, 0);
	}

	@Test
	public void testUpdate() throws ItemNotFoundException {
		restaurant.setMealOfTheWeek("Family Pizza Feast", myFoodora);
		double price = fullMeal.getPrice();
	    String formattedPrice = String.format(Locale.US, "%.2f", price);
	    assertEquals("the price of meal \"Family Pizza Feast\" after update is 20.21", Double.parseDouble(formattedPrice), 20.21, 0);
	}
	
	@Test 
	public void testAddDish() throws MeallsCompleteException, ItemNotFoundException{
		Dish dish = restaurant.findDishByName("Cheesy Garlic Bread");
		FullMeal fullMeal = new FullMeal("Family Pizza Feast");
		fullMeal.addDish(dish);

		assertEquals("the dish has been added to the meal", fullMeal.getMainDish(), dish);
	}

	@Test(expected = MeallsCompleteException.class)
	public void testAddDishWhenMealFull() throws MeallsCompleteException, ItemNotFoundException{
		Dish dish = restaurant.findDishByName("Cheesy Garlic Bread");
		halfMeal.addDish(dish);
	}
}
