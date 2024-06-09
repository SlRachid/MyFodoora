package Food;

public class Dessert extends Dish {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -881985313352419861L;

	/**
	 * @param name
	 * @param price
	 * @param type
	 */
	public Dessert(String name, double price, DietType type) {
		super(name, price, type);
		this.setDishType(DishType.dessert);
	}

	@Override
	public String toString() {
		return ("Dessert : " + super.toString());
	}
}
