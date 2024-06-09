package Food;

public class HalfMeal extends Meal {
	
	private static final long serialVersionUID = 5964746563078278289L;
	/**
	 * the side dish : a starter or a dessert
	 */
	private Dish sideDish;
	
	/**
	 * creates a HalflMeal object where we could add a mainDish and a sideDish.
	 * @param name : the name of the meal
	 */
	public HalfMeal(String name) {
		super(name);
		this.sideDish = null;
	}
	
	/**
	 * creates a HalfMeal object of a given mainDish and sideDish (starter, dessert)
	 * @param name : the name of the meal
	 * @param mainDish : the mainDish of the meal
	 * @param sideDish : the sideDish of the meal
	 */
	public HalfMeal(String name, MainDish mainDish, Dish sideDish) {
		super(name, mainDish);
		this.sideDish = sideDish;
		
		//the type of the meals depends on the type of the dishes which compose the meal
		if (mainDish.getType()== sideDish.getType()){
			this.type = mainDish.getType();
		}
		
		//the price is computed from the prices of the dishes and the discount factor
		this.price = this.getPrice();
	}
	
	/**
	 * computes the price of the meal
	 */
	
	@Override
	public double getPrice() {
		double price = this.mealVisitor.computePriceMeal(this);
		return(price);
	}
	

	
	/**
	 * adds a dish to the meal if possible using a mealVisitor (considering we have half and full meals)
	 * @param dish : the dish we want to add to the meal
	 * @throws MeallsCompleteException : if the meal is complete
	 */
	@Override
	public void addDish(Dish dish) throws MeallsCompleteException {
		this.mealVisitor.addDish2Meal(dish, this);
	}
	/**
	 * 
	 * @return returns the side dish 
	 */
	
	public Dish getSideDish() {
		return sideDish;
	}

	public void setSideDish(Dish sideDish) {
		this.sideDish = sideDish;
	}

	@Override
	public String toString() {
		return ("\nHalf" + super.toString() + sideDish);
	}
	
	
}
