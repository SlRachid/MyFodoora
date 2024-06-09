package User;
import java.io.*;
import Food.*;
import OrderAndDelivery.*;
import System.*;

import java.util.ArrayList ;

/**
 * This interface serves both customers and couriers:
 * For customers: It displays special offers for those who have opted in to receive them.
 * For couriers: It lists available orders for potential completion.
 * @param <Interest>
 */

public class Interface <Interest> implements Serializable{

    
    /**
	 * 
	 */
	private static final long serialVersionUID = -4098429983703670431L;
	/**
     * The list of items to be displayed to the customer.
     */
    private ArrayList<Interest> target; 
    
    public Interface() {
        target = new ArrayList<Interest>();
    }
    
    /**
     * Adds a new item to the board.
     * @param value the item to be added.
     */
    public void addObs(Interest value){
        this.target.add(value);
    }
    
    /**
     * Removes an item from the board.
     * @param obs the item to be removed.
     */
    public void removeObs(Interest value){
        this.target.remove(value);
    }
    
    /**
     * Finds an object by its unique ID.
     * @param uniqueID the ID of the object to find.
     * @return the object with the specified ID.
     * @throws OrderNotFoundException if the object is not found.
     */
    public Interest findObsById (int uniqueID) throws OrderNotFoundException {
        
        for (Interest object : target){
            if((object instanceof Order)&&(((Order)object).getUniqueID()==(uniqueID))){
                return object;
            }
        }
        throw new OrderNotFoundException("The order with ID " + uniqueID + " is not on the board");
    }
    
    /**
     * Clears all items from the board.
     */
    public void clearBoard(){
        this.target.clear();
    }
    
    /**
     * Displays all items on the board.
     * @return a string representation of all items.
     */
    @Override
    public String toString(){
        String message = "Board:\n";
        for(Interest obs : this.target){
            message += obs + "\n";
        }
        return message;
    }
}
