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
		MainDish mainDish = new MainDish("pizza vegetarienne", 18, DietType.vegetarian);
		assertEquals("The dish type must be set automatically to main", DishType.main, mainDish.getDishType());
	}

	@Test
	public void testToString() {
		Starter starter = new Starter("salade marocaine", 1, DietType.vegetarian);
		System.out.println(starter);
	}

	@Test
	public void testEqualsObject() {
		Starter starter = new Starter("salade marocaine", 1, DietType.vegetarian);
		Starter startercopy = new Starter("salade marocaine", 1, DietType.vegetarian);
		assertEquals("The overriden equals function enables to compare Dish objects", starter, startercopy);
	}

}
