package System;
import Food.*;
import OrderAndDelivery.*;
import User.*;

public class NotActiveAccException extends Exception {

	private static final long serialVersionUID = -7830538404004078430L;

	public NotActiveAccException() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param message : message given when the exception is thrown
	 */
	public NotActiveAccException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
