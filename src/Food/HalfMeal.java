package Food;

import Exceptions.*;

/**
 * Represents a half meal, including a main dish and a side dish.
 */
public class HalfMeal extends Meal {
	
	/**
	 * Serial version UID for serialization.
	 */
	private static final long serialVersionUID = 7790237610202183462L;
	
	/**
	 * The side dish: either a starter or a dessert.
	 */
	private Dish sideDish;
	
	/**
	 * Constructs a HalfMeal object where a main dish and a side dish can be added later.
	 * 
	 * @param name The name of the meal.
	 */
	public HalfMeal(String name) {
		super(name);
		this.sideDish = null;
	}
	
	/**
	 * Constructs a HalfMeal object with a given main dish and side dish (starter or dessert).
	 * 
	 * @param name The name of the meal.
	 * @param mainDish The main dish of the meal.
	 * @param sideDish The side dish of the meal.
	 */
	public HalfMeal(String name, MainDish mainDish, Dish sideDish) {
		super(name, mainDish);
		this.sideDish = sideDish;
		
		// The type of the meal depends on the type of the dishes that compose the meal
		if (mainDish.getType() == sideDish.getType()){
			this.type = mainDish.getType();
		}
		
		// The price is computed from the prices of the dishes and the discount factor
		this.price = this.getPrice();
	}
	
	/**
	 * Calculates the price of the meal.
	 * 
	 * @return The price of the meal.
	 */
	@Override
	public double getPrice() {
		double price = this.mealVisitor.computePriceMeal(this);
		return price;
	}
	
	/**
	 * Adds a dish to the meal if possible using a mealVisitor (considering we have half and full meals).
	 * 
	 * @param dish The dish to add to the meal.
	 * @throws MeallsCompleteException If the meal is complete.
	 */
	@Override
	public void addDish(Dish dish) throws MeallsCompleteException {
		this.mealVisitor.addDish2Meal(dish, this);
	}
	
	/**
	 * Gets the side dish of the meal.
	 * 
	 * @return The side dish of the meal.
	 */
	public Dish getSideDish() {
		return sideDish;
	}

	/**
	 * Sets the side dish for the meal.
	 * 
	 * @param sideDish The side dish to set.
	 */
	public void setSideDish(Dish sideDish) {
		this.sideDish = sideDish;
	}

	/**
	 * Provides a string representation of the half meal.
	 * 
	 * @return A string containing the meal details.
	 */
	@Override
	public String toString() {
		return ("\nHalf" + super.toString() + sideDish);
	}
}
