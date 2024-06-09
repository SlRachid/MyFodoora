package Exceptions;

import java.io.Serializable ;

import Food.Dessert;
import Food.DietType;
import Food.Dish;
import Food.DishType;
import Food.FullMeal;
import Food.HalfMeal;
import Food.MainDish;
import Food.Meal;
import Food.Starter;

public class MenuItemFactory implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6358064614386568642L;


	public MenuItemFactory() {}
	
	public Dish createDish (DishType dishType, String name, double price, DietType type) {
		Dish dish = null;
		switch(dishType){
			case starter:
				dish = new Starter(name, price, type);
				break;
			case main:
				dish = new MainDish(name, price, type);
				break;
			case dessert:
				dish = new Dessert(name, price, type);
				break;
		}
		return dish;
	}

	
	public Meal createMeal (String mealType, String name) {
		Meal meal = null;
		switch(mealType){
			case("full"):
				meal = new FullMeal(name);
				break;
			case("half"):
				meal = new HalfMeal(name);
				break;
		}
		return (meal);
	}

}
