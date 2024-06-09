package Food;

import Exceptions.*;
/**
 * Represents a meal, which may include a main dish and additional items.
 */
public abstract class Meal extends MenuItem {

    /**
     * The name of the meal.
     */
    private String name;

    /**
     * The main dish of the meal.
     */
    protected MainDish mainDish;

    /**
     * The type of diet associated with the meal, default is standard.
     */
    protected DietType type = DietType.standard;

    /**
     * The discount factor applied to the meal price, default is 0.05 (5%).
     */
    protected double discountFactor = 0.05;

    /**
     * Visitor pattern implementation for calculating meal price.
     */
    protected MealVisitor mealVisitor = new MealVisitor();

    /**
     * Constructs a Meal object with a specified name and no main dish.
     * 
     * @param name The name of the meal.
     */
    public Meal(String name) {
        this.name = name;
        this.mainDish = null;
    }

    /**
     * Constructs a Meal object with a specified name and main dish.
     * 
     * @param name     The name of the meal.
     * @param mainDish The main dish of the meal.
     */
    public Meal(String name, MainDish mainDish) {
        this.name = name;
        this.mainDish = mainDish;
    }

    /**
     * Abstract method to calculate and return the price of the meal.
     * 
     * @return The price of the meal.
     */
    public abstract double getPrice();

    /**
     * Abstract method to add a dish to the meal.
     * 
     * @param dish The dish to be added.
     * @throws MeallsCompleteException If the meal is already complete.
     */
    public abstract void addDish(Dish dish) throws MeallsCompleteException;

    /**
     * Updates the meal's discount factor based on the menu's discount policies and recalculates the meal's price.
     * 
     * @param menu The menu containing the meal.
     */
    public void update(Menu menu) {
        double genericDiscountFactor = menu.getGenericDiscountFactor();
        double specialDiscountFactor = menu.getSpecialDiscountFactor();
        Meal mealOfTheWeek = menu.getMealOfTheWeek();

        if (this == mealOfTheWeek) {
            // Apply the special discount factor
            this.discountFactor = specialDiscountFactor;
        } else {
            // Apply the generic discount factor
            this.discountFactor = genericDiscountFactor;
        }
        this.price = this.getPrice();
    }

    /**
     * Gets the name of the meal.
     * 
     * @return The name of the meal.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the meal.
     * 
     * @param name The new name of the meal.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the main dish of the meal.
     * 
     * @param mainDish The new main dish of the meal.
     */
    public void setMainDish(MainDish mainDish) {
        this.mainDish = mainDish;
    }

    /**
     * Gets the main dish of the meal.
     * 
     * @return The main dish of the meal.
     */
    public MainDish getMainDish() {
        return mainDish;
    }

    /**
     * Sets the diet type of the meal.
     * 
     * @param type The new diet type of the meal.
     */
    public void setType(DietType type) {
        this.type = type;
    }

    /**
     * Gets the diet type of the meal.
     * 
     * @return The diet type of the meal.
     */
    public DietType getType() {
        return type;
    }

    /**
     * Gets the discount factor applied to the meal price.
     * 
     * @return The discount factor.
     */
    public double getDiscountFactor() {
        return discountFactor;
    }

    /**
     * Provides a string representation of the meal.
     * 
     * @return A string containing the meal details.
     */
    @Override
    public String toString() {
        return String.format("Meal: %s\nPrice: %.2f\nType: %s\nMain Dish: %s",
                              getName(), getPrice(), getType(), mainDish);
    }

    /**
     * Checks if this meal is equal to another object.
     * 
     * @param o The object to compare with.
     * @return true if the meals have the same name, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Meal meal = (Meal) o;
        return name.equals(meal.name);
    }

   

}
