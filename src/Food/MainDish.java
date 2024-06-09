package Food;

public class MainDish extends Dish{
	
	private static final long serialVersionUID = 4693141788247499246L;
	
	/**
	 * 
	 * @param name
	 * @param price
	 * @param type which corresponds to the eater's diet : vegetarian, standard, gluten free
	 */
	public MainDish(String name, double price, DietType type) {
		super(name, price, type);
		this.setDishType(DishType.main) ;
	}
	
	@Override
	public String toString() {
		return ("MainDish : " + super.toString());
	}
}
