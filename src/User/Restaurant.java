package User;
import Food.*;
import OrderAndDelivery.*;
import System.*;

import java.util.ArrayList;

public class Restaurant extends User {
	
	private static final long serialVersionUID = -983973017288067345L;
	private Location address ;
	private Menu menu ;
	private int counter = 0 ;
	private FoodItemFactory foodItemFactory ;
	
	/**
	 * the policy to sort food items that have been shipped in completed orders
	 */
	private SorterFoodItem shippedOrderPolicy = new SorterCounter() ;
	
	/**
	 * creates a restaurant who will be used in the MyFoodora platform
	 * @param name : the name of the user
	 * @param surname : the surname of the user
	 * @param userName : the user name in the MyFoodora platform
	 * @param password : the password of the user to login in the MyFoodora platform
	 */
	public Restaurant(String name, String surname, String userName, String password) {
		super(name, "", userName, password);
		this.address = null ;
		this.menu = new Menu() ;
		this.foodItemFactory = new FoodItemFactory();
		
		this.setUserType (UserType.restaurant) ;
	}
	
	/**
	 * creates a restaurant who will be used in the MyFoodora platform
	 * @param name : the name of the user
	 * @param userName : the user name in the MyFoodora platform
	 * @param password : the password of the user to login in the MyFoodora platform
	 * @param address : the address of the restaurant
	 */
	public Restaurant(String name, String userName, String password, Location address) {
		super(name, "", userName, password);
		this.address = address ;
		this.menu = new Menu() ;
		this.foodItemFactory = new FoodItemFactory();

		this.setUserType (UserType.restaurant) ;
	}
	
	/**
	 * adds a new dish to the restaurant menu
	 * @param dishType : "starter", "mainDish" or "dessert"
	 * @param name : the name of the dish
	 * @param price : the price of the dish
	 * @param type : the type of dish "standard", "vegetarian" or "glutenFree"
	 */
	public void addDish(DishType dishType, String name, double price, DietType type){
		Dish dish = this.foodItemFactory.createDish(dishType, name, price, type);
		this.menu.addDish(dish);
	}
	
	/**
	 * remove dish of given name from the menu
	 * @param name : the name of the dish
	 * @throws ItemNotFoundException : if the dish of given name is not in the menu
	 */
	public void removeDish(String name) throws ItemNotFoundException{
		Dish dish = this.findDishByName(name);
		this.menu.removeDish(dish);
	}
	
	/**
	 * finds the dish of given name in the menu
	 * @param name : the name of the dish
	 * @return dish : the dish of given name
	 * @throws ItemNotFoundException : if the dish of given name is not in the menu
	 */
	public Dish findDishByName(String name) throws ItemNotFoundException {
		ArrayList<Dish> dishes = this.menu.getDishes();
		for (Dish dish: dishes){
			if (dish.getName().equals(name)){
				return dish;
			}
		}
		throw (new ItemNotFoundException(name+" is not found")) ;
	}
	
	/**
	 * adds a new meal to the restaurant menu
	 * @param mealType : "full" or "half" 
	 * @param name : the name of the meal
	 */
	public void addMeal(String mealType, String name){
		Meal meal = this.foodItemFactory.createMeal(mealType, name);
		this.menu.addMeal(meal);
	}
	
	/**
	 * remove meal of given name from the menu
	 * @param name : the name of the meal
	 * @throws ItemNotFoundException : if the meal of given name is not in the menu
	 */
	public void removeMeal(String name) throws ItemNotFoundException{
		Meal meal = this.findMealByName(name);
		this.menu.removeMeal(meal);
	}
	
	/**
	 * finds the meal of given name in the menu
	 * @param name : the name of the meal
	 * @return meal : the meal of given name
	 * @throws ItemNotFoundException : if the meal of given name is not in the menu
	 */
	public Meal findMealByName(String name) throws ItemNotFoundException {
		ArrayList<Meal> meals = this.menu.getMeals();
		for (Meal meal: meals){
			if (meal.getName().equals(name)){
				return meal;
			}
		}
		throw (new ItemNotFoundException(name+" is not found")) ;
	}
	
	/**
	 * adds a dish to a meal if possible
	 * @param mealName : the name of the meal
	 * @param dishName : the name of the dish
	 * @throws MeallsCompleteException : if the meal is already complete 
	 * @throws ItemNotFoundException : if the dish or the meal of given name is not in the menu
	 */
	public void addDish2Meal(String mealName, String dishName) throws MeallsCompleteException, ItemNotFoundException{
		Meal meal = this.findMealByName(mealName);
		Dish dish = this.findDishByName(dishName);
		meal.addDish(dish);

	}
	
	/**
	 * sets the new Meal of the week
	 * @param mealName : the name of the new meal of the week
	 * @param myFoodora : the myFoodora core
	 * @throws ItemNotFoundException : if the meal of given name is not in the menu
	 */
	public void setMealOfTheWeek(String mealName, MyFoodora myFoodora) throws ItemNotFoundException{
		Meal mealOfTheWeek = this.findMealByName(mealName);
		this.getMenu().setMealOfTheWeek(mealOfTheWeek);
		
		//we notify the customers that agreed to be notified for special offers
		double reduction = 100*(this.menu.getSpecialDiscountFactor()-this.menu.getGenericDiscountFactor())/(1 - this.menu.getGenericDiscountFactor());
		String offer = "At " + this.getName() + " the meal " + mealName + " is " + reduction + "% cheaper than usually !\n";
		myFoodora.newOffer(offer);
	}
	
	/**
	 * display the food items of the menu according to the shipped order policy
	 * @param foodItemType : the type of food items to display : "dish" or "meal"
	 */
	public void displaySortedFoodItems(String foodItemType){
		ArrayList<MenuItem> notSortedFoodItems = new ArrayList<MenuItem>();
		switch(foodItemType){
			case("dish"):
				ArrayList<Dish> dishes = this.menu.getDishes();
				for(MenuItem dish : dishes){
					notSortedFoodItems.add(dish);
				}
				break;
			case("meal"):
				ArrayList<Meal> meals = this.menu.getMeals();
				for(MenuItem meal : meals){
					notSortedFoodItems.add(meal);
				}
				break;
			default: break;
		}
		ArrayList<MenuItem> sortedFoodItems = this.shippedOrderPolicy.sort(notSortedFoodItems);
		System.out.println(sortedFoodItems);
	}
	
	public Menu getMenu(){
		return menu ;
	}
	
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public void displayMenu(){
		System.out.println(this.menu.toString());
	}
	
	public void setGenericDiscountFactor(double genericDiscountFactor) {
		this.menu.setGenericDiscountFactor(genericDiscountFactor);
	}
	
	public void setSpecialDiscountFactor(double specialDiscountFactor) {
		this.menu.setSpecialDiscountFactor(specialDiscountFactor);
	}

	public Location getAddress() {
		return address;
	}

	public void setAddress(Location address) {
		this.address = address;
	}
	
	public int getCounter() {
		return counter;
	}

	public void increaseCounter() {
		this.counter++ ;
	}
	
	public void setShippedOrderPolicy(SorterFoodItem shippedOrderPolicy) {
		this.shippedOrderPolicy = shippedOrderPolicy;
	}

	public void setShippedOrderPolicy (String shippedOrderPolicyName){
		SorterFoodItem sorterFoodItem = null;
		switch(shippedOrderPolicyName){
			case("counter"):
				sorterFoodItem = new SorterCounter();
				break;
		}
		this.shippedOrderPolicy = sorterFoodItem;
	}
		
	@Override
	public String toString(){
		return ("Name : " + this.getName() + "\n" + 
				"	Address " + address);
	}
}
