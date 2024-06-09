package Food;

import java.io.Serializable;

import Exceptions.MeallsCompleteException;

/**
 * This visitor pattern enables us to handle different implementations of
 * computePrice and addDish methods, which depend on the nature of the meal.
 */
public class MealVisitor implements Serializable {

    private static final long serialVersionUID = 1884146694430479857L;

    public MealVisitor() {}

    /**
     * Computes the price of a full meal.
     * @param fullMeal the FullMeal object
     * @return the computed price of the full meal
     */
    public double computePriceMeal(FullMeal fullMeal) {
        Starter starter = fullMeal.getStarter();
        MainDish mainDish = fullMeal.getMainDish();
        Dessert dessert = fullMeal.getDessert();

        double discountFactor = fullMeal.getDiscountFactor();
        double starterPrice = (starter == null ? 0 : starter.getPrice());
        double mainDishPrice = (mainDish == null ? 0 : mainDish.getPrice());
        double dessertPrice = (dessert == null ? 0 : dessert.getPrice());

        double price = (starterPrice + mainDishPrice + dessertPrice) * (1 - discountFactor);
        return price;
    }

    /**
     * Computes the price of a half meal.
     * @param halfMeal the HalfMeal object
     * @return the computed price of the half meal
     */
    public double computePriceMeal(HalfMeal halfMeal) {
        Dish sideDish = halfMeal.getSideDish();
        MainDish mainDish = halfMeal.getMainDish();

        double discountFactor = halfMeal.getDiscountFactor();
        double sideDishPrice = (sideDish == null ? 0 : sideDish.getPrice());
        double mainDishPrice = (mainDish == null ? 0 : mainDish.getPrice());

        double price = (sideDishPrice + mainDishPrice) * (1 - discountFactor);
        return price;
    }

    /**
     * Adds a dish to a full meal, ensuring that each type of dish is added only once.
     * @param dish the Dish to be added
     * @param fullMeal the FullMeal to which the dish is added
     * @throws MeallsCompleteException if the meal already contains a dish of the same type
     */
    public void addDish2Meal(Dish dish, FullMeal fullMeal) throws MeallsCompleteException {
        Starter starter = fullMeal.getStarter();
        MainDish mainDish = fullMeal.getMainDish();
        Dessert dessert = fullMeal.getDessert();

        DishType dishType = dish.getDishType();
        switch (dishType) {
            case starter:
                if (starter == null) {
                    fullMeal.setStarter((Starter) dish);
                } else {
                    throw new MeallsCompleteException("The meal already contains a starter");
                }
                break;
            case main:
                if (mainDish == null) {
                    fullMeal.setMainDish((MainDish) dish);
                } else {
                    throw new MeallsCompleteException("The meal already contains a mainDish");
                }
                break;
            case dessert:
                if (dessert == null) {
                    fullMeal.setDessert((Dessert) dish);
                } else {
                    throw new MeallsCompleteException("The meal already contains a dessert");
                }
                break;
            default:
                break;
        }

        // Update the meal price based on the newly added dishes and discount factor
        fullMeal.setPrice(fullMeal.getPrice());

        // Set the meal type based on the types of dishes it contains
        if ((mainDish != null) && (starter != null) && (dessert != null)
                && (mainDish.getType() == starter.getType()) && (mainDish.getType() == dessert.getType())) {
            fullMeal.setType(mainDish.getType());
        }
    }

    /**
     * Adds a dish to a half meal, ensuring that each type of dish is added only once.
     * @param dish the Dish to be added
     * @param halfMeal the HalfMeal to which the dish is added
     * @throws MeallsCompleteException if the meal already contains a dish of the same type
     */
    public void addDish2Meal(Dish dish, HalfMeal halfMeal) throws MeallsCompleteException {
        Dish sideDish = halfMeal.getSideDish();
        MainDish mainDish = halfMeal.getMainDish();

        DishType dishType = dish.getDishType();
        switch (dishType) {
            case starter:
                if (sideDish == null) {
                    halfMeal.setSideDish((Starter) dish);
                } else {
                    throw new MeallsCompleteException("The meal already contains a sideDish");
                }
                break;
            case main:
                if (mainDish == null) {
                    halfMeal.setMainDish((MainDish) dish);
                } else {
                    throw new MeallsCompleteException("The meal already contains a mainDish");
                }
                break;
            case dessert:
                if (sideDish == null) {
                    halfMeal.setSideDish((Dessert) dish);
                } else {
                    throw new MeallsCompleteException("The meal already contains a sideDish");
                }
                break;
            default:
                break;
        }

        // Update the meal price based on the newly added dishes and discount factor
        halfMeal.setPrice(halfMeal.getPrice());

        // Set the meal type based on the types of dishes it contains
        if ((mainDish != null) && (sideDish != null) && (mainDish.getType() == sideDish.getType())) {
            halfMeal.setType(mainDish.getType());
        }
    }
}
