package Food;

import java.util.ArrayList;

public class Menu implements java.io.Serializable {

    private static final long serialVersionUID = -8318434210469557686L;

    // The list of dishes that are available in the menu
    private ArrayList<Dish> dishes;

    // The list of meals that are available in the menu
    private ArrayList<Meal> meals;

    // The generic discount factor for the meal of the week
    private double genericDiscountFactor = 0.05;

    // The special discount factor for the meal of the week
    private double specialDiscountFactor = 0.1;

    // The meal of the week
    private Meal mealOfTheWeek = null;

    public Menu() {
        this.dishes = new ArrayList<Dish>();
        this.meals = new ArrayList<Meal>();
    }

    /**
     * Creates a Menu object given a list of dishes and meals.
     * 
     * @param dishes the list of dishes to add to the menu
     * @param meals  the list of meals to add to the menu
     */
    public Menu(ArrayList<Dish> dishes, ArrayList<Meal> meals) {
        this.dishes = dishes;
        this.meals = meals;
    }

    /**
     * Notifies all meals of the change of the discount factors.
     */
    public void notifyMeals() {
        for (Meal meal : meals) {
            meal.update(this);
        }
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    /**
     * Adds a dish to the list of dishes proposed on the menu.
     * 
     * @param dish the dish to add to the menu
     */
    public void addDish(Dish dish) {
        this.dishes.add(dish);
    }

    /**
     * Removes a dish from the list of dishes proposed on the menu.
     * 
     * @param dish the dish to remove from the menu
     */
    public void removeDish(Dish dish) {
        this.dishes.remove(dish);
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    /**
     * Adds a meal to the list of meals proposed on the menu.
     * 
     * @param meal the meal to add to the menu
     */
    public void addMeal(Meal meal) {
        this.meals.add(meal);
    }

    /**
     * Removes a meal from the list of meals proposed on the menu.
     * 
     * @param meal the meal to remove from the menu
     */
    public void removeMeal(Meal meal) {
        this.meals.remove(meal);
    }

    public double getGenericDiscountFactor() {
        return genericDiscountFactor;
    }

    public void setGenericDiscountFactor(double genericDiscountFactor) {
        this.genericDiscountFactor = genericDiscountFactor;
        this.notifyMeals();
    }

    public double getSpecialDiscountFactor() {
        return specialDiscountFactor;
    }

    public void setSpecialDiscountFactor(double specialDiscountFactor) {
        this.specialDiscountFactor = specialDiscountFactor;
        this.notifyMeals();
    }

    public Meal getMealOfTheWeek() {
        return mealOfTheWeek;
    }

    public void setMealOfTheWeek(Meal mealOfTheWeek) {
        this.mealOfTheWeek = mealOfTheWeek;
        this.notifyMeals();
    }

    @Override
    public String toString() {
        return "Menu {" +
                "\n  dishes=" + dishes +
                ",\n  meals=" + meals +
                ",\n  genericDiscountFactor=" + genericDiscountFactor +
                ",\n  specialDiscountFactor=" + specialDiscountFactor +
                ",\n  mealOfTheWeek=" + mealOfTheWeek +
                "\n}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Menu menu = (Menu) obj;

        if (Double.compare(menu.genericDiscountFactor, genericDiscountFactor) != 0) return false;
        if (Double.compare(menu.specialDiscountFactor, specialDiscountFactor) != 0) return false;
        if (dishes != null ? !dishes.equals(menu.dishes) : menu.dishes != null) return false;
        if (meals != null ? !meals.equals(menu.meals) : menu.meals != null) return false;
        return mealOfTheWeek != null ? mealOfTheWeek.equals(menu.mealOfTheWeek) : menu.mealOfTheWeek == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = dishes != null ? dishes.hashCode() : 0;
        result = 31 * result + (meals != null ? meals.hashCode() : 0);
        temp = Double.doubleToLongBits(genericDiscountFactor);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(specialDiscountFactor);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (mealOfTheWeek != null ? mealOfTheWeek.hashCode() : 0);
        return result;
    }
}
