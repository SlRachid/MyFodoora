package User;
import Food.*;
import OrderAndDelivery.*;
import System.*;

import java.util.ArrayList ;

/**
 * This interface serves both customers and couriers:
 * For customers: It displays special offers for those who have opted in to receive them.
 * For couriers: It lists available orders for potential completion.
 * @param <ObsType>
 */

public class Interface <ObsType> implements java.io.Serializable{

    private static final long serialVersionUID = -3052025800155606005L;
    
    /**
     * The list of items to be displayed to the customer.
     */
    private ArrayList<ObsType> obs; 
    
    public Interface() {
        obs = new ArrayList<ObsType>();
    }
    
    /**
     * Adds a new item to the board.
     * @param obs the item to be added.
     */
    public void addObs(ObsType obs){
        this.obs.add(obs);
    }
    
    /**
     * Removes an item from the board.
     * @param obs the item to be removed.
     */
    public void removeObs(ObsType obs){
        this.obs.remove(obs);
    }
    
    /**
     * Finds an object by its unique ID.
     * @param uniqueID the ID of the object to find.
     * @return the object with the specified ID.
     * @throws OrderNotFoundException if the object is not found.
     */
    public ObsType findObsById (int uniqueID) throws OrderNotFoundException {
        
        for (ObsType object : obs){
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
        this.obs.clear();
    }
    
    /**
     * Displays all items on the board.
     * @return a string representation of all items.
     */
    @Override
    public String toString(){
        String message = "Board:\n";
        for(ObsType obs : this.obs){
            message += obs + "\n";
        }
        return message;
    }
}
