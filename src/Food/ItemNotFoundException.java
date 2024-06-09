package Food;


public class ItemNotFoundException extends Exception {

	private static final long serialVersionUID = 7752643160099900523L;
	public ItemNotFoundException(){}
	/**
	 * @param arg0
	 */
	
	public ItemNotFoundException(String arg0) {
		super(arg0);
	}
}