package Food;

public class FullMeal extends Meal {

	private static final long serialVersionUID = -7845792807622942588L;

	private Starter starter;
	private Dessert dessert;

	
	public FullMeal(String name) {
		super(name);
		this.starter = null;
		this.dessert = null;
	}	
	

	public FullMeal(String name, MainDish mainDish, Starter starter, Dessert dessert) {
		super(name, mainDish);
		this.starter = starter;
		this.dessert = dessert;
		
		//the price is computed from the prices of the dishes and the discount factor
		this.price = this.getPrice();
		
		//the type of the meals depends on the type of the dishes which compose the meal
		if ((mainDish.getType()== starter.getType()) && (mainDish.getType()== dessert.getType())){
			this.type = mainDish.getType();
		}
	}
	

	@Override
	public double getPrice() {
		double price = this.mealVisitor.computePriceMeal(this);
		return(price);
	}

	@Override
	public void update (Menu menu){
		double genericDiscountFactor = menu.getGenericDiscountFactor();
		double specialDiscountFactor = menu.getSpecialDiscountFactor();
		Meal mealOfTheWeek = menu.getMealOfTheWeek();
		
		if (this == mealOfTheWeek){
			//we apply the special discount factor
			this.discountFactor = specialDiscountFactor;
		}
		else{
			//we apply the generic discount factor
			this.discountFactor = genericDiscountFactor;
		}
		this.price = this.getPrice();
	}
	
	@Override
	public void addDish(Dish dish) throws NoPlaceInMealException {
		this.mealVisitor.addDish2Meal(dish, this);
	}
	
	public void setStarter(Starter starter) {
		this.starter = starter;
	}

	public Starter getStarter() {
		return starter;
	}

	public void setDessert(Dessert dessert) {
		this.dessert = dessert;
	}

	public Dessert getDessert() {
		return dessert;
	}
	
	@Override
	public String toString() {
		return ("\nFull" + super.toString() + starter + dessert);
	}
}
