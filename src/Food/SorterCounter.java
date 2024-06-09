package Food;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.Serializable;

/**
 * sorts the list of Food Items (HalfMeals, Dishes a la Carte) with respect to how they were ordered (in descending order)
 */
public class SorterCounter implements SorterMenuItem, Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = -716777925612230729L;

	@Override
    public ArrayList<MenuItem> sort(ArrayList<MenuItem> foodItems) {
        // Make a copy of the list to avoid modifying the original list
        ArrayList<MenuItem> sortedFoodItems = (ArrayList<MenuItem>) foodItems.clone();
        
        // Sort the copied list based on the counter value in descending order
        Collections.sort(sortedFoodItems, new Comparator<MenuItem>() {
            @Override
            public int compare(MenuItem item1, MenuItem item2) {
                // Compare counter values in descending order
                return Integer.compare(item2.getCounter(), item1.getCounter());
            }
        });
        
        return sortedFoodItems;
    }
}
