package Food;

public class Starter extends Dish {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4920129374885032667L;

	public Starter(String name, double price, DietType type) {
		super(name, price, type);
		this.setDishType(DishType.starter) ;
	}
	
	@Override
	public String toString() {
		return ("Starter : " + super.toString());
	}
	
}
