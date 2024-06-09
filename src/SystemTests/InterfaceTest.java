package SystemTests;
import User.*;
import Food.*;
import System.*;
import OrderAndDelivery.*;


import static org.junit.Assert.*;
import org.junit.*;

public class InterfaceTest {

	private static Interface<String> board;
	
	@BeforeClass
	public static void createBoard(){
		board = new Interface<String>();
		String offer = "The most popular menu and your favorite is now available for 10% cheaper\n";
		board.addObs(offer);
	}
	
	@Test
	public void testToString() {
		System.out.println(board);;
	}
	
	@Test
	public void testClearBoard() {
		board.clearBoard();
		System.out.println(board);
	}
}
