package Food;

public class FullMeal extends Meal {

    private static final long serialVersionUID = -7845792807622942588L;

    private Starter starter;
    private Dessert dessert;

    /**
     * Constructor for creating a new FullMeal with only a name.
     * This is typically used to initialize a meal that can have dishes added later.
     * @param name the name of the meal
     */
    public FullMeal(String name) {
        super(name);
        this.starter = null;
        this.dessert = null;
    }   
    
    /**
     * Constructor for creating a FullMeal with a main dish, starter, and dessert.
     * @param name the name of the meal
     * @param mainDish the main dish of the meal
     * @param starter the starter of the meal
     * @param dessert the dessert of the meal
     */
    public FullMeal(String name, MainDish mainDish, Starter starter, Dessert dessert) {
        super(name, mainDish);
        this.starter = starter;
        this.dessert = dessert;
        
        // The price is computed based on the prices of the dishes and any applicable discount factor
        this.price = this.getPrice();
        
        // The type of the meal is determined by the type of the dishes that compose the meal
        if ((mainDish.getType() == starter.getType()) && (mainDish.getType() == dessert.getType())) {
            this.type = mainDish.getType();
        }
    }
    
    /**
     * Calculates and returns the price of the full meal.
     * The price is computed using a visitor pattern.
     * @return the total price of the meal
     */
    @Override
    public double getPrice() {
        double price = this.mealVisitor.computePriceMeal(this);
        return price;
    }

    /**
     * Adds a dish to the full meal.
     * @param dish the dish to be added
     * @throws MeallsCompleteException if the meal is already complete
     */
    @Override
    public void addDish(Dish dish) throws MeallsCompleteException {
        this.mealVisitor.addDish2Meal(dish, this);
    }
    
    /**
     * Sets the starter for the full meal.
     * @param starter the starter to be set
     */
    public void setStarter(Starter starter) {
        this.starter = starter;
    }

    /**
     * Gets the starter of the full meal.
     * @return the starter of the meal
     */
    public Starter getStarter() {
        return starter;
    }

    /**
     * Sets the dessert for the full meal.
     * @param dessert the dessert to be set
     */
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    /**
     * Gets the dessert of the full meal.
     * @return the dessert of the meal
     */
    public Dessert getDessert() {
        return dessert;
    }
    
    /**
     * Provides a string representation of the full meal.
     * @return a string containing the meal details
     */
    @Override
    public String toString() {
        return ("\nFull" + super.toString() + starter + dessert);
    }
}
