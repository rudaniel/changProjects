package project4;

import java.util.HashMap;
import java.util.ArrayList;

public class Order {

	
	HashMap <String, ArrayList <Pizza>> pizzaOrders = new HashMap<String, ArrayList <Pizza>>();
	
	public void phoneOrder (String phoneNumber, Pizza pizza) {
	
	

	
		if (pizzaOrders.containsKey(phoneNumber) ) {
			System.out.println("1");
			ArrayList <Pizza> temp;
			temp = pizzaOrders.get(phoneNumber);
			temp.add(pizza);
			pizzaOrders.put(phoneNumber, temp);
		}
		else {
		
			ArrayList <Pizza> temp = new ArrayList<Pizza>();
			temp.add(pizza);
			pizzaOrders.put(phoneNumber, temp);
			//System.out.println(pizzaOrders.get(phoneNumber));
	     	//temp = null;
			//System.out.println(pizzaOrders);
		}
		
		
		
	
	}
	
	public static String getOrders (String phoneNumber, HashMap<String, ArrayList <Pizza>> pizzaOrders) {
		String order = null;
		ArrayList<Pizza> temp = new ArrayList<Pizza>();
		
		temp = pizzaOrders.get(phoneNumber);
		
		System.out.println(temp);
		
		
		return order;
	}
	
	
	
	public static void main(String[] args) {
		String yum = "Cheese,Ham,Chicken";
		String size = "large";
		Pepperoni pizza1 = new Pepperoni(yum,size);
		
		String yum2 = "Cheese,Chicken";
		String size2 = "small";
		Pepperoni pizza2 = new Pepperoni(yum2,size2);
		
		String number = "9084561296";
		String number2 = "4253256783";
		
		
		
		//getOrders(number, pizzaOrders);
		//System.out.println(angelicaPizza.price());
		//,Beef,Onion,Mushroom,Ham
	}
	
	
}
