package User;
import Food.*;
import OrderAndDelivery.*;
import System.*;

public abstract class User implements java.io.Serializable {
	
	private static final long serialVersionUID = 6262632605692759298L;
	private String name ;
	private String surname ;
	private int ID ;
	private String userName ;
	private String password ;
	/**
	 * the type of user : manager, customer, courier or restaurant
	 */
	private UserType userType ;
	/**
	 * the static nextID ensures the uniqueness of IDs
	 */
	protected static int nextID = 0 ;
	/**
	 * activation is done by the managaer
	 */
	private boolean active = false ;
	
	/**
	 * creates an user who will use the MyFoodora platform
	 * @param name : the name of the user
	 * @param surname : the surname of the user
	 * @param userName : the user name in the MyFoodora platform
	 * @param password : the password of the user to login in the MyFoodora platform
	 */
	public User(String name, String surname, String userName, String password) {
		ID = nextID ;
		nextID++ ;
		this.name = name ;
		this.surname = surname;
		this.userName = userName ;
		this.password = password ;
		this.active = true ;
	}
	

	public void unregister(MyFoodora myFoodora){
		myFoodora.removeUser(ID);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getUniqueID() {
		return ID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivated() {
		return active;
	}

	public void setActivated(boolean activated) {
		this.active = activated;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	public static int getLastID() {
		return nextID;
	}

	public static void setLastID(int lastID) {
		User.nextID = lastID;
	}

	@Override
	public String toString(){
		return (this.userType + " ID n�" + this.ID + " " + name + " " + surname + " username:"+userName+"\n");
	}
	
	@Override
	public boolean equals (Object o){
		boolean isequal = false;
		if (o instanceof User){
			User user = (User)o;
			isequal = (this.ID == user.getUniqueID());
		}
		return isequal;
	}
	
}
