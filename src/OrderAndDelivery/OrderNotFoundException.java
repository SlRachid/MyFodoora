package OrderAndDelivery;
import Food.*;
import User.*;
import System.*;

public class OrderNotFoundException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6544924684037107244L;


	public OrderNotFoundException() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param arg0 : commentaire
	 */
	public OrderNotFoundException(String arg0) {
		super(arg0);
	}
}