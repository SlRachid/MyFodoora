package Food;

public class MainDish extends Dish{
	
	private static final long serialVersionUID = 4693141788247499246L;

	public MainDish(String name, double price, DietType type) {
		super(name, price, type);
		this.setDishType(DishType.main) ;
	}
	
	@Override
	public String toString() {
		return ("MainDish : " + super.toString());
	}
}
