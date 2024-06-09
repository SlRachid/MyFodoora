package Food;

/**
 * An abstract class representing a dish in the menu.
 */
public abstract class Dish extends MenuItem {
	
	/**
	 * Serial version UID for serialization.
	 */
	private static final long serialVersionUID = -428328274386160481L;
	
	/**
	 * The type of the dish: "starter", "mainDish", or "dessert".
	 */
	private DishType dishType;
	
	/**
	 * The name of the dish.
	 */
	private String name;
	
	/**
	 * The diet type of the dish: "standard", "vegetarian", or "glutenFree".
	 */
	private DietType type;
	
	/**
	 * Constructs a dish with the given name, price, and diet type.
	 * 
	 * @param name The name of the dish.
	 * @param price The price of the dish.
	 * @param type The diet type of the dish.
	 */
	public Dish(String name, double price, DietType type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}

	/**
	 * Gets the type of the dish.
	 * 
	 * @return The dish type.
	 */
	public DishType getDishType() {
		return dishType;
	}
	
	/**
	 * Sets the type of the dish.
	 * 
	 * @param type The dish type to set.
	 */
	public void setDishType(DishType type) {
		this.dishType = type;
	}

	/**
	 * Gets the name of the dish.
	 * 
	 * @return The name of the dish.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the dish.
	 * 
	 * @param name The name to set for the dish.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the diet type of the dish.
	 * 
	 * @return The diet type of the dish.
	 */
	public DietType getType() {
		return type;
	}

	/**
	 * Sets the diet type of the dish.
	 * 
	 * @param type The diet type to set for the dish.
	 */
	public void setType(DietType type) {
		this.type = type;
	}	

	/**
	 * Returns a string representation of the dish.
	 * 
	 * @return A string representing the dish.
	 */
	@Override
	public String toString() {
		return "[" + name + ", price=" + price + ", type=" + type + ", counter=" + counter + "]\n";
	}
	
	/**
	 * Checks if this dish is equal to another object.
	 * 
	 * @param o The object to compare with.
	 * @return True if the dishes are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		boolean isequal = false;
		if (o instanceof Dish) {
			Dish dish = (Dish)o;
			isequal = this.name.equals(dish.getName());
		}
		return isequal;
	}
	
}
