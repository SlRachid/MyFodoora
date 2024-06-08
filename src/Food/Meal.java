package Food;

public abstract class Meal extends MenuItem {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 519790930574147324L;
	/**
	 * the name of the meal
	 */
	private String name;
	/**
	 * the main-dish of the meal considering all meals have a main dish
	 */
	protected MainDish mainDish;
	
	/**
	 * the type of the dish : standard, vegetarian or gluten-free
	 */
	protected DietType type = DietType.standard;
	/**
	 * The discount factor of the dish
	 */
	protected double discountFactor = 0.05; 
	
	protected MealVisitor mealVisitor = new MealVisitor() ;
	
	/**
	 * creates a Meal object of a given mainDish
	 * @param name : the name of the meal
	 */
	public Meal(String name) {
		this.name = name ;
		this.mainDish = null;
	}
	
	/**
	 * creates a Meal object of a given mainDish
	 * @param name : the name of the meal
	 * @param mainDish : the mainDish of the meal
	 */
	public Meal(String name, MainDish mainDish) {
		this.name = name;
		this.mainDish = mainDish;
	}
	
	public abstract double getPrice();
	
	public abstract void update (Menu menu);
	
	public abstract void addDish (Dish dish) throws MeallsCompleteException;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setMainDish(MainDish mainDish) {
		this.mainDish = mainDish;
	}

	public MainDish getMainDish() {
		return mainDish;
	}

	public void setType(DietType type) {
		this.type = type;
	}

	public DietType getType() {
		return type;
	}
	
	public double getDiscountFactor() {
		return discountFactor;
	}

	@Override
	public String toString() {
		return ("Meal : " + this.getName() + "\nprice : " + this.getPrice() + " type : " + this.getType() +"\n"+
				 mainDish);
	}
	
	@Override
	public boolean equals (Object o){
		boolean isequal = false;
		if (o instanceof Meal){
			Meal meal = (Meal)o;
			isequal = this.name.equals(meal.getName());
		}
		return isequal;
	}
}
