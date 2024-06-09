package User;
import Food.*;
import System.*;

import java.io.Serializable ;

/**
 *this factory class enables us to register different types of users
 */
public class UserFactory implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2136067834275559198L;

	public UserFactory() {}
	
	public void registerUser (UserType userType, String name, String surname, String userName, String password, MyFoodora myFoodora){
		switch(userType){
			case customer:
				Customer customer = new Customer(name, surname, userName, password);
				myFoodora.addUser(customer);
				break;
			case courier:
				Courier courier = new Courier(name, surname, userName, password);
				myFoodora.addUser(courier);
				break;
			case restaurant:
				Restaurant restaurant = new Restaurant(name, surname, userName, password);
				myFoodora.addUser(restaurant);
				break;
			case manager:
				Manager manager = new Manager(name, surname, userName, password, myFoodora);
				//to ensure that non-manager users cannot create manager accounts
				manager.setActivated(false);
				myFoodora.addUser(manager);
				break;
			default:
				break;
		}
	}

}
