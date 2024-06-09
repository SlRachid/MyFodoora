package SystemTests;
import User.*;
import Food.*;
import System.*;
import OrderAndDelivery.*;


public class MyFoodoraExample {
	/**
	 * Generates an instance of MyFoodora which will be saved in "MyFoodora.ser"
	 * this example is later used in the JUnit tests
	 */
	public static void createMyFoodora() {
		//Create an empty myFoodora
		double serviceFee = 10;
		double markupPercentage = 0.05;
		double deliveryCost = 5;
		MyFoodora myFoodora = new MyFoodora(serviceFee, markupPercentage, deliveryCost);
		
		// Add the first manager
		Manager manager = new Manager("Massine", "EL KHADER", "Mek", "qwerty", myFoodora);
		myFoodora.addUser(manager);
		
		// Create a first restaurant
		Restaurant foPizza = new Restaurant("Fo", "fo_pizza", "123", new Location(12.3, 478.21));
		Menu menu = foPizza.getMenu();
		
		// Add dishes and meals to the menu
		Starter starter = new Starter("Pizza norvegienne", 12.95, DietType.standard); menu.addDish(starter);

		MainDish mainDish = new MainDish("Veggie pizza", 11, DietType.vegetarian);	menu.addDish(mainDish);
		mainDish = new MainDish("Margherita pizza", 10, DietType.vegetarian); menu.addDish(mainDish);
		mainDish = new MainDish("Pepperoni pizza", 13, DietType.standard); menu.addDish(mainDish);
		
		HalfMeal halfMeal = new HalfMeal("Special Pizza Combo", mainDish, starter); menu.addMeal(halfMeal);
		menu.setMealOfTheWeek(halfMeal);
		
		mainDish = new MainDish("Cheesy Garlic Bread", 5.5, DietType.standard); 
		menu.addDish(mainDish);

		Dessert dessert = new Dessert("Tiramisu", 4, DietType.standard);	
		menu.addDish(dessert);

		FullMeal fullMeal = new FullMeal("Family Pizza Feast", mainDish, starter, dessert); 
		menu.addMeal(fullMeal);

		mainDish = new MainDish("Meat Lover's Pizza", 15, DietType.standard); 
		menu.addDish(mainDish);

		halfMeal = new HalfMeal("Pizza and Salad Combo", mainDish, dessert); 
		menu.addMeal(halfMeal);
		
		// Add the restaurant to myFoodora
		myFoodora.addUser(foPizza);
		
		// Create a second restaurant: Sushi Delight
		Restaurant sushiDelight = new Restaurant("Sushi Delight", "sushi", "sushi_pass", new Location(121.3, 41.31));
		menu = sushiDelight.getMenu();
		// Add dishes and meals to the menu
		starter = new Starter("Edamame", 3.5, DietType.vegetarian); 
		menu.addDish(starter);

		dessert = new Dessert("Green Tea Ice Cream", 5, DietType.vegetarian);	
		menu.addDish(dessert);

		mainDish = new MainDish("Sushi Platter", 18, DietType.standard);	
		menu.addDish(mainDish);

		halfMeal = new HalfMeal("Sushi Roll Combo", mainDish, starter); 
		menu.addMeal(halfMeal);

		mainDish = new MainDish("Sashimi Bowl", 20, DietType.standard);	
		menu.addDish(mainDish);

		fullMeal = new FullMeal("Deluxe Sushi Feast", mainDish, starter, dessert); 
		menu.addMeal(fullMeal);

		mainDish = new MainDish("Tempura Udon", 15, DietType.standard); 
		menu.addDish(mainDish);

		halfMeal = new HalfMeal("Nigiri and Miso Soup Combo", mainDish, dessert); 
		menu.addMeal(halfMeal);

		// Add Sushi Delight to MyFoodora
		myFoodora.addUser(sushiDelight);

		
		//Add a manager
		myFoodora.addUser(new Manager("Rachid", "SLIMANI", "RS", "azerty", myFoodora));
		
		//Add couriers
		Courier courier = new Courier("John", "Doe", "johndoe", "password", new Location(35.789, 78.65), "0634567890"); 
		for (int i = 0; i < 50; i++) {
		    courier.increaseCounter();
		}
		courier.setOnDuty(true);
		myFoodora.addUser(courier);

		courier = new Courier("Jane", "Smith", "janesmith", "pass123", new Location(40.7128, 74.0060), "0987654321");
		for (int i = 0; i < 11; i++) {
		    courier.increaseCounter();
		}
		courier.setOnDuty(true);
		myFoodora.addUser(courier);

		myFoodora.addUser(new Courier("Michael", "Johnson", "mikejohn", "mypass", new Location(51.5074, 0.1278), "0112223333"));
		
		//Add customers
		Customer customer = new Customer("Ali", "Garfield", "AG", "password1", new Location(23.3, 45.12), "ali.garfield@student-cs.fr", "0712035618");
		
		//Fidelity points for Ali
		customer.registerFidelityCard("point");
		((PointFidelityCard)customer.getFidelityCard()).addPoints(123);
		
		// Add customer 1
		myFoodora.addUser(customer);

		// Add customer 2
		myFoodora.addUser(new Customer("Alice", "Johnson", "alicej", "pass123", new Location(87.3, 12.5), "alice.johnson@example.com", "0743628121"));

		// Add customer 3
		myFoodora.addUser(new Customer("Bob", "Smith", "bobsmith", "secret321", new Location(2.3, 4.12), "bob.smith@example.com", "0743628131"));

		// Add customer 4
		myFoodora.addUser(new Customer("Emily", "Jones", "emilyj", "mypassword", new Location(69.2, 12.78), "emily.jones@example.com", "0753628181"));

		// Add customer 5
		myFoodora.addUser(new Customer("Sara", "Jamil", "saraj", "password456", new Location(84.3, 145.12), "sara.jamil@example.com", "0759628121"));
		
		//we create an order
		Order order = new Order("AliOrder",customer,new Location(4,8), foPizza);
		//we fill the order with food items
		order.addDish(mainDish);
		order.addMeal(fullMeal);
		//the customer submits the order
		order.submit(true, myFoodora);
		//the courier accepts the delivery call
		order.validateOrderByCourier(myFoodora);
		
		myFoodora.saveMyFoodora();
	}
	
	
	public static void main(String[] args) {
		createMyFoodora();
	}
}