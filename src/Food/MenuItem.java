package Food;

/**
 * this abstract class enables us to deal with both Dish and Meal objects in the sorter
 */
public abstract class MenuItem implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -698433074705384736L;
	protected double price = 0;
	/**
	 * the number of times the food item has been shipped 
	 */
	protected int counter = 0 ;
	
	public int getCounter(){
		return counter ;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}
	
	public void increaseCounter() {
		this.counter++ ;
	}
}
