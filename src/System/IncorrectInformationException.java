package System;
import Food.*;
import OrderAndDelivery.*;
import User.*;

public class IncorrectInformationException extends Exception {

	private static final long serialVersionUID = -9121993161560782016L;

	public IncorrectInformationException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message : message given when the exception is thrown
	 */
	public IncorrectInformationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
