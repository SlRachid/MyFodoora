package SystemTests;
import User.*;
import Food.*;
import System.*;
import OrderAndDelivery.*;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import Exceptions.ItemNotFoundException;
import Exceptions.MeallsCompleteException;


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
			restaurant = (Restaurant) myFoodora.login("sushi", "sushi_pass");
		}catch(Exception e){}
	}
	
	@Test
	public void testFindDishByNameWhenInMenu() throws ItemNotFoundException {
		//restaurant.addDish(DishType.main, "Tajine", 15, DietType.standard);
		Dish dish = restaurant.findDishByName("Sushi Platter");
		assertEquals("Sushi Platter", dish.getName());
	}
	
	@Test (expected = ItemNotFoundException.class)
	public void testFindDishByNameWhenNotInMenu() throws ItemNotFoundException {
		restaurant.addDish(DishType.main, "Tajine", 15, DietType.standard);
		//"Tajine" != "Tajin" it should throw an error
		Dish dish = restaurant.findDishByName("Tajin");
	}

	@Test
	public void testAddDish() throws ItemNotFoundException {
		restaurant.addDish(DishType.main, "Tajine", 15, DietType.standard);
		Dish dish = restaurant.findDishByName("Tajine");
		System.out.println(dish);
	}

	@Test (expected = ItemNotFoundException.class)
	public void testRemoveDish() throws ItemNotFoundException {
		//we add a new dish to the menu of the restaurant (tested above)
		restaurant.addDish(DishType.main, "Taine", 15, DietType.standard);
		//we remove this dish
		restaurant.removeDish("Taine");
		//we check that the dish has been removed
		Dish dish = restaurant.findDishByName("Taine");
	}

	@Test (expected = ItemNotFoundException.class)
	public void testFindMealByName() throws ItemNotFoundException {
		restaurant.addMeal("full", "Rfissa marocaine");
		//when the user misspells a word for example : "B2" != "b2"
		Meal meal = restaurant.findMealByName("Rissa");
	}

	@Test
	public void testAddMeal() throws ItemNotFoundException {
		restaurant.addMeal("full", "Rfissa");
		Meal meal = restaurant.findMealByName("Rfissa");
		System.out.println(meal);
	}

	@Test (expected = ItemNotFoundException.class)
	public void testRemoveMeal() throws ItemNotFoundException {
		//we add a new meal to the menu of the restaurant (tested above)
		restaurant.addMeal("full", "1");
		Meal meal = restaurant.findMealByName("1");
		//we remove this meal
		restaurant.removeMeal("1");
		//we check that the dish has been removed
		meal = restaurant.findMealByName("1");
	}

	@Test
	public void testAddDish2Meal() throws ItemNotFoundException, MeallsCompleteException {
		//we add a new meal to the menu of the restaurant (tested above)
		restaurant.addMeal("half", "12");
		Meal meal = restaurant.findMealByName("12");
		//System.out.println(restaurant.getMenu());
		//we find dishes to add to the meal
		Dish mainDish = restaurant.findDishByName("Sushi Platter");
		System.out.println(mainDish);

		Dish dessert = restaurant.findDishByName("Green Tea Ice Cream");
		System.out.println(dessert);

		//we add them to the empty meal
		restaurant.addDish2Meal("12", "Sushi Platter");
		restaurant.addDish2Meal("12", "Green Tea Ice Cream");
		
		System.out.println(meal);
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
