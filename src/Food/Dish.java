package Food;

public abstract class Dish extends MenuItem {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1206079415293719264L;
	/**
	 * W.r.t the meal : "starter", "mainDish" or "dessert"
	 */
	private DishType dishType;
	private String name;
	/**
	 * W.r.t the customer's diet : "standard", "vegetarian" or "glutenFree"
	 */
	private DietType type; 
	

	public Dish(String name, double price, DietType type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}

	
	public DishType getDishType() {
		return dishType;
	}
	
	public void setDishType(DishType type) {
		this.dishType = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DietType getType() {
		return type;
	}

	public void setType(DietType type) {
		this.type = type;
	}	

	@Override
	public String toString() {
		return "[" + name + ", price=" + price + ", type=" + type + ", counter=" + counter + "]\n";
	}
	
	@Override
	public boolean equals (Object o){
		boolean isequal = false;
		if (o instanceof Dish){
			Dish dish = (Dish)o;
			isequal = this.name.equals(dish.getName());
		}
		return isequal;
	}
	
}
