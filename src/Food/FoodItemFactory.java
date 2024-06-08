package Food;

import java.io.Serializable ;

public class FoodItemFactory implements Serializable {
	
	private static final long serialVersionUID = 6129494191504757935L;

	public FoodItemFactory() {}
	
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
