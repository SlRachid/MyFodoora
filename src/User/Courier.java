package User;
import Food.*;
import OrderAndDelivery.*;
import Food.*;
import System.*;




public class Courier extends User {

	private static final long serialVersionUID = 7761609339188995456L;
	private Location position ;
	private String phoneNumber ;
	/**
	 * the number of completed deliveries
	 */
	private int numOfDeliveries = 0 ;
	/**
	 * true when the courier is on-duty and false if he is off-duty
	 */
	private boolean onDuty = false ;
	/**
	 * show the delivery calls
	 */
	private Interface<Order> board;

	/**
	 * creates a courier who will use the MyFoodora platform
	 * @param name : the name of the user
	 * @param surname : the surname of the user
	 * @param userName : the user name in the MyFoodora platform
	 * @param password : the password of the user to login in the MyFoodora platform
	 */
	public Courier(String name, String surname, String userName, String password) {
		super(name, surname, userName, password);
		this.position = null ;
		this.phoneNumber = "" ;
		this.board = new Interface<Order>();

		this.setUserType (UserType.courier) ;
	}
	
	/**
	 * creates a courier who will use the MyFoodora platform
	 * @param name : the name of the user
	 * @param surname : the surname of the user
	 * @param userName : the user name in the MyFoodora platform
	 * @param password : the password of the user to login in the MyFoodora platform
	 * @param position : the position of the courier
	 * @param phoneNumber : the phone number of the courier
	 */
	public Courier(String name, String surname, String userName, String password, Location position, String phoneNumber) {
		super(name, surname, userName, password);
		this.position = position ;
		this.phoneNumber = phoneNumber ;
		this.board = new Interface<Order>();
		
		this.setUserType (UserType.courier) ;
	}
	
	/**
	 * accept or refuse a delivery call for a waiting order
	 * @param decision : the decision "true" if accept, "false" if refuse
	 * @param waitingOrder : the waiting order
	 * @param myFoodora : the my Foodora system
	 */
	public void acceptDeliveryCall (boolean decision, Order waitingOrder, MyFoodora myFoodora){
		if (decision){
			waitingOrder.validateOrderByCourier(myFoodora);
		}else{
			//we set the state of the courier as "off-duty" to allocate another courier to the order
			this.onDuty = false;
			myFoodora.getDeliveryPolicy().allocateCourier(myFoodora, waitingOrder);
		}
		this.board.removeObs(waitingOrder);
		
	}

	public Location getPosition() {
		return position;
	}

	public void setPosition(Location position) {
		this.position = position;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isOnDuty() {
		return onDuty;
	}

	public void setOnDuty(boolean onDuty) {
		this.onDuty = onDuty;
	}

	public int getNumOfDeliveries() {
		return numOfDeliveries;
	}
	
	public void increaseCounter() {
		numOfDeliveries++;
	}

	public Interface<Order> getBoard() {
		return board;
	}
}
