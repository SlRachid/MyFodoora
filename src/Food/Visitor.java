package Food;


public interface Visitor {	

	public double computePriceMeal(FullMeal fullMeal);

	public double computePriceMeal(HalfMeal halfMeal);

	public void addDish2Meal(Dish dish, FullMeal fullMeal) throws MeallsCompleteException;

	public void addDish2Meal(Dish dish, HalfMeal halfMeal) throws MeallsCompleteException;
}

