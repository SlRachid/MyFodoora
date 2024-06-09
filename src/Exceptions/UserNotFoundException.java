package Exceptions;
import Food.*;


public class UserNotFoundException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1426582701583896148L;

	public UserNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message : message given when the exception is thrown
	 */
	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
