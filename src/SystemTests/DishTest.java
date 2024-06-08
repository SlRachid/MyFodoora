package SystemTests;
import User.*;
import Food.*;
import System.*;
import OrderAndDelivery.*;

import static org.junit.Assert.*;

import org.junit.Test;


public class DishTest {

	@Test
	public void testGetDishType() {
		MainDish mainDish = new MainDish("quiche aux legumes", 18, DietType.vegetarian);
		assertEquals("The dish type must be compute automatically", DishType.main, mainDish.getDishType());
	}

	@Test
	public void testToString() {
		Starter starter = new Starter("mozzarella", 4, DietType.vegetarian);
		System.out.println(starter);
	}

	@Test
	public void testEqualsObject() {
		Dessert dessert = new Dessert("gateau au pois-chiche", 18, DietType.vegetarian);
		Dessert dessertCopy = new Dessert("gateau au pois-chiche", 18, DietType.vegetarian);
		assertEquals("The overriden equals function enables to compare Dish objects", dessert, dessertCopy);
	}

}
