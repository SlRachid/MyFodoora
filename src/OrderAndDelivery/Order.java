package OrderAndDelivery;
import Food.*;
import User.*;
import System.*;

import java.util.ArrayList;
import java.util.Calendar ;
import java.util.Locale;

public class Order implements java.io.Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8854065909989557711L;


	/**
	 * the name of the order
	 */
	private String name;
	

	/**
	 * the static nextID to ensure the uniqueness of the IDs
	 */
	protected static int nextID = 1 ;
	private int uniqueID;
	/**
	 * the date of the order
	 */
	private Calendar dateOfOrder ;
	
	private Customer customer;
	private Restaurant restaurant;
	/**
	 * the list of the chosen dishes
	 */
	private ArrayList<Dish> dishes;
	/**
	 * the list of the chosen meals
	 */
	private ArrayList<Meal> meals;
	/**
	 * the price of the order
	 */
	private double price;
	/**
	 * the courier who will deliver the order
	 */
	private Courier courier ;
	/**
	 * 
	 */
	private Location deliveryaddress ;
	
	/**
	 * creates a new Order object given a customer and a target restaurant
	 * @param customer : the customer making an order
	 * @param restaurant : the target restaurant
	 */
	public Order(String name, Customer customer,Location address, Restaurant restaurant) {
		this.uniqueID = nextID;
		nextID++;
		this.name = name;
		this.customer = customer;
		this.customer.setLocation(address);
		this.restaurant = restaurant;
		this.dishes = new ArrayList<Dish>();
		this.meals = new ArrayList<Meal>();
		this.dateOfOrder = Calendar.getInstance() ;
		this.courier = null ;
		this.deliveryaddress = restaurant.getLocation() ;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	public int getUniqueID() {
		return uniqueID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}
	
	
	public Calendar getDateOfOrder() {
		return dateOfOrder;
	}

	public ArrayList<Dish> getDishes() {
		return dishes;
	}
	
	/**
	 * add a dish to the order
	 * @param dish : the dish to add
	 */
	public void addDish(Dish dish){
		this.dishes.add(dish);
	}
	
	/**
	 * remove a dish from the order
	 * @param dish : the dish to remove
	 */
	public void removeDish(Dish dish){
		this.dishes.remove(dish);
	}
	
	public ArrayList<Meal> getMeals() {
		return meals;
	}
	
	/**
	 * add a meal to the order
	 * @param meal : the meal to add to the menu
	 */
	public void addMeal(Meal meal){
		this.meals.add(meal);
	}
	
	/**
	 * remove a meal to the list of meals proposed on the menu
	 * @param meal : the meal to remove from the menu
	 */
	public void removeMeal(Meal meal){
		this.meals.remove(meal);
	}

	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	public double computePrice(){
		double price = 0;
		
		for(Dish dish:this.dishes){
			price += dish.getPrice();
		}
		for(Meal meal:this.meals){
			price += meal.getPrice();
		}
		return(price);
	}
	
	public Location getDeliveryAddress() {
		return deliveryaddress;
	}

	public void setDeliveryAddress(Location addressOfDelivery) {
		this.deliveryaddress = addressOfDelivery;
	}	

	public Courier getCourier() {
		return courier;
	}

	public void setCourier(Courier courier) {
		this.courier = courier;
		//we put the order on the board of the courier
		this.courier.getInterfaceBoard().addObs(this);
	}

	/**
	 * when the order is validated
	 * 		we allocate a courier and put the order on his board
	 * 		we increase the counter of the restaurant
	 * 		we increase all the counters of the picked items
	 * 		we compute the price of the order according to a eventual reduction
	 * 		if necessary we add the fidelity points to the card of the customer
	 * @param applyReduction : "true" if the customer wants to apply a reduction using his fidelity card
	 * @param myFoodora : myFoodora core
	 */
	public void submit(boolean applyReduction, MyFoodora myFoodora){
		myFoodora.getDeliveryPolicy().allocateCourier(myFoodora, this);
		
		restaurant.increaseCounter();
		for (Dish dish : dishes){
			dish.increaseCounter();
		}
		for (Meal meal : meals){
			meal.increaseCounter();
		}
		this.price = this.computePrice();
		
		FidelityCard fidelityCard = customer.getFidelityCard();
		if(applyReduction){
			fidelityCard.applyReduction(this);	
		}
		if (fidelityCard instanceof PointFidelityCard){
			((PointFidelityCard)fidelityCard).computeFidelityPoints(this);
		}
	}
	
	/**
	 * indicate that the courier has accepted the delivery call of this order
	 * 		the order is then completed
	 * @param myFoodora : my Foodora system
	 */
	public void validateOrderByCourier (MyFoodora myFoodora){
		this.courier.increaseCounter();
		myFoodora.addCompletedOrders(this);
	}

	@Override
	public String toString() {
		return "Order [ID : " + this.uniqueID + "\n"
				+ "name=" + name
				+ "dateOfOrder=" + dateOfOrder.get(Calendar.DAY_OF_MONTH) + " " + dateOfOrder.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + " " + dateOfOrder.get(Calendar.YEAR) + "\n" 
				+ "customer=" + customer + "\n" 
				+ "restaurant=" + restaurant + "\n" 
				+ "dishes=" + dishes + "\n"
				+ "meals=" + meals + "\n"
				+ "price=" + price + "\n"
				+ "courier=" + courier + "\n"
				+ "To be delivered to [" + deliveryaddress + "]\n";
	}
	
	@Override
	public boolean equals (Object o){
		boolean isequal = false;
		if (o instanceof Order){
			Order order = (Order)o;
			isequal = (this.uniqueID == order.getUniqueID());
		}
		return isequal;
	}
}
