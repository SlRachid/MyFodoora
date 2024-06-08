package Food;

import java.util.ArrayList;
import java.io.Serializable ;

/**
 * sorts the list according to the area of figures (in descending order)
 */
public class SorterCounter implements SorterFoodItem,Serializable {

	private static final long serialVersionUID = -2130889579431738571L;

	/**
	 * looks over the list of foodItems looking for the biggest counter
	 * @param foodItems - list of food items
	 * @return the foodItem with the biggest counter
	 */
	public MenuItem maxFoodItem(ArrayList<MenuItem> foodItems){
		MenuItem maxFoodItem = null; 
		int maxCounter = 0 ;
		
		if(foodItems.isEmpty())
			return null;
		else{
			for(MenuItem foodItem:foodItems){
				if(foodItem.getCounter()>=maxCounter){
					maxCounter = foodItem.getCounter() ;
					maxFoodItem = foodItem ;
				}	
			}
		}
		return maxFoodItem; 
	}
	
	/**
	 * sorts the list according to the counter of food items (in descending order)
	 */
	@Override
	public ArrayList<MenuItem> sort(ArrayList<MenuItem> foodItems){
		ArrayList<MenuItem> FoodItemsCopy = (ArrayList<MenuItem>) foodItems.clone(); 
		ArrayList<MenuItem> sortedFoodItems = new ArrayList<MenuItem>();
		
		if(foodItems.size()<=1)
			return foodItems;
		else{
			MenuItem maxFoodItem;
			while(FoodItemsCopy.size()>0){
				maxFoodItem = this.maxFoodItem(FoodItemsCopy);
				sortedFoodItems.add(maxFoodItem);
				FoodItemsCopy.remove(maxFoodItem);
			}
			return sortedFoodItems;
		}
	}
}
