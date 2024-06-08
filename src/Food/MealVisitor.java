package Food;

import java.io.Serializable;
/**
 * this visitor pattern enables us to deal with different implementation of
 *		computePrice
 *		addDish
 */
public class MealVisitor implements Serializable {

	private static final long serialVersionUID = 1884146694430479857L;

	public MealVisitor() {}
	

	public double computePriceMeal(FullMeal fullMeal){
		Starter starter = fullMeal.getStarter();
		MainDish mainDish = fullMeal.getMainDish();
		Dessert dessert = fullMeal.getDessert();
		
		double discountFactor = fullMeal.getDiscountFactor();
		double starterPrice = (starter == null ? 0 : starter.getPrice());
		double mainDishPrice = (mainDish == null ? 0 : mainDish.getPrice());
		double dessertPrice = (dessert == null ? 0 : dessert.getPrice());
		
		double price = (starterPrice + mainDishPrice + dessertPrice)*(1-discountFactor);
		return (price);
	}
	

	public double computePriceMeal(HalfMeal halfMeal){
		Dish sideDish = halfMeal.getSideDish();
		MainDish mainDish = halfMeal.getMainDish();
		
		double discountFactor = halfMeal.getDiscountFactor();
		
		double sideDishPrice = (sideDish == null ? 0 : sideDish.getPrice());
		double mainDishPrice = (mainDish == null ? 0 : mainDish.getPrice());
		
		double price = (sideDishPrice + mainDishPrice)*(1-discountFactor);
		return (price);
	}
	

	public void addDish2Meal(Dish dish, FullMeal fullMeal) throws MeallsCompleteException{
		Starter starter = fullMeal.getStarter();
		MainDish mainDish = fullMeal.getMainDish();
		Dessert dessert = fullMeal.getDessert();
		
		DishType dishType = dish.getDishType();
		switch(dishType){
			case starter:
				if (starter==null){
					fullMeal.setStarter((Starter)dish);
				}else{
					throw (new MeallsCompleteException("The meal already contains a starter"));
				}
				break;
			case main:
				if (mainDish==null){
					fullMeal.setMainDish((MainDish)dish);
				}else{
					throw (new MeallsCompleteException("The meal already contains a mainDish"));
				}
				break;
			case dessert:
				if (dessert==null){
					fullMeal.setDessert((Dessert)dish);
				}else{
					throw (new MeallsCompleteException("The meal already contains a dessert"));
				}
				break;
			default: break;
		}
		//the price is computed from the prices of the dishes and the discount factor
		fullMeal.setPrice (fullMeal.getPrice());
		
		//the type of the meals depends on the type of the dishes which compose the meal
		if ((mainDish != null)&&(starter != null)&&(dessert != null)&&(mainDish.getType()== starter.getType()) && (mainDish.getType()== dessert.getType())){
			fullMeal.setType(mainDish.getType());
		}
	}
	

	public void addDish2Meal(Dish dish, HalfMeal halfMeal) throws MeallsCompleteException{
		Dish sideDish = halfMeal.getSideDish();
		MainDish mainDish = halfMeal.getMainDish();
		
		DishType dishType = dish.getDishType();
		switch(dishType){
			case starter:
				if (sideDish==null){
					halfMeal.setSideDish((Starter)dish);
				}else{
					throw (new MeallsCompleteException("The meal already contains a sideDish"));
				}
				break;
			case main:
				if (mainDish==null){
					halfMeal.setMainDish((MainDish)dish);
				}else{
					throw (new MeallsCompleteException("The meal already contains a mainDish"));
				}
				break;
			case dessert:
				if (sideDish==null){
					halfMeal.setSideDish((Dessert)dish);
				}else{
					throw (new MeallsCompleteException("The meal already contains a sideDish"));
				}
				break;
			default: break;
		}
		//the price is computed from the prices of the dishes and the discount factor
		halfMeal.setPrice(halfMeal.getPrice());
		
		//the type of the meals depends on the type of the dishes which compose the meal
		if ((mainDish != null)&&(sideDish != null)&&(mainDish.getType()== sideDish.getType())){
			halfMeal.setType(mainDish.getType());
		}

	}
}
