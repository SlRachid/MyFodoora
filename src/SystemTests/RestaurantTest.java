package SystemTests;
import User.*;
import Food.*;
import System.*;
import OrderAndDelivery.*;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


public class RestaurantTest {
	
	private static MyFoodora myFoodora;
	/**
	 * we create an example of restaurant that will be used in the following tests
	 */
	private static Restaurant restaurant;

	@BeforeClass
	public static void importMyFoodora(){
		myFoodora = MyFoodora.loadMyFoodora();
		try{
			restaurant = (Restaurant) myFoodora.login("hoki", "password");
		}catch(Exception e){}
	}
	
	@Test
	public void testFindDishByNameWhenInMenu() throws ItemNotFoundException {
		restaurant.addDish(DishType.main, "maki crevette", 4.5, DietType.standard);
		//when the user misspells a word for example : "crevette" != "crevete"
		Dish dish = restaurant.findDishByName("maki crevette");
		assertEquals("maki crevette", dish.getName());
	}
	
	@Test (expected = ItemNotFoundException.class)
	public void testFindDishByNameWhenNotInMenu() throws ItemNotFoundException {
		restaurant.addDish(DishType.main, "maki crevette", 4.5, DietType.standard);
		//when the user misspells a word for example : "crevette" != "crevete"
		Dish dish = restaurant.findDishByName("maki crevete");
	}

	@Test
	public void testAddDish() throws ItemNotFoundException {
		restaurant.addDish(DishType.main, "maki avocat", 4.5, DietType.vegetarian);
		Dish dish = restaurant.findDishByName("maki avocat");
		System.out.println("The new added dish : " + dish);
	}

	@Test (expected = ItemNotFoundException.class)
	public void testRemoveDish() throws ItemNotFoundException {
		//we add a new dish to the menu of the restaurant (tested above)
		restaurant.addDish(DishType.main, "maki daurade", 4.5, DietType.standard);
		Dish dish = restaurant.findDishByName("maki daurade");
		//we remove this dish
		restaurant.removeDish("maki daurade");
		//we check that the dish has been removed
		dish = restaurant.findDishByName("maki daurade");
	}

	@Test (expected = ItemNotFoundException.class)
	public void testFindMealByName() throws ItemNotFoundException {
		restaurant.addMeal("full", "B2");
		//when the user misspells a word for example : "B2" != "b2"
		Meal meal = restaurant.findMealByName("b2");
	}

	@Test
	public void testAddMeal() throws ItemNotFoundException {
		restaurant.addMeal("full", "B2");
		Meal meal = restaurant.findMealByName("B2");
		System.out.println("The new added meal" + meal);
	}

	@Test (expected = ItemNotFoundException.class)
	public void testRemoveMeal() throws ItemNotFoundException {
		//we add a new meal to the menu of the restaurant (tested above)
		restaurant.addMeal("full", "B7");
		Meal meal = restaurant.findMealByName("B7");
		//we remove this meal
		restaurant.removeMeal("B7");
		//we check that the dish has been removed
		meal = restaurant.findMealByName("B7");
	}

	@Test
	public void testAddDish2Meal() throws ItemNotFoundException, MeallsCompleteException {
		//we add a new meal to the menu of the restaurant (tested above)
		restaurant.addMeal("half", "B2");
		Meal meal = restaurant.findMealByName("B2");
		//we find dishes to add to the meal
		Dish mainDish = restaurant.findDishByName("brochettes boeuf"); 
		Dish dessert = restaurant.findDishByName("litchee");
		//we add them to the empty meal
		restaurant.addDish2Meal("B2", "brochettes boeuf");
		restaurant.addDish2Meal("B2", "litchee");
		
		System.out.println("The new adde half-meal " + meal);
	}

	@Test
	public void testDisplaySortedFoodItems() {
		//we sort the food items of the menu according to their price
		restaurant.setShippedOrderPolicy("counter");
		//we display the sorted dish
		restaurant.displaySortedFoodItems("dish");
		//we display the sorted meals
		restaurant.displaySortedFoodItems("meal");
	}

	@Test
	public void testDisplayMenu() {
		System.out.println("The menu of the restaurant");
		restaurant.displayMenu();
	}
}
