package SystemTests;
import User.*;
import Food.*;
import System.*;
import OrderAndDelivery.*;


import static org.junit.Assert.*;
import org.junit.*;

public class InterfaceTest {

	private static Interface<String> specialOffers;
	
	@BeforeClass
	public static void createBoard(){
		specialOffers = new Interface<String>();
		String specialOffer = "The most popular menu and your favorite is now available for 10% cheaper\n";
		specialOffers.addObs(specialOffer);
	}
	
	@Test
	public void testToString() {
		System.out.println(specialOffers);;
	}
	
	@Test
	public void testClearBoard() {
		specialOffers.clearBoard();
		System.out.println(specialOffers);
	}
}
