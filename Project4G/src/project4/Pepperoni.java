package project4;

import project4.Pizza;

public class Pepperoni extends Pizza {

	private double pricePepperoni;
	

	public Pepperoni (String toppingList, String pizzaSize) {
	
		super(toppingList, pizzaSize);
	}

	public double price() {
		
		
		int toppingAmount = toppings.size();
		double regularPrice = 8.99;
		int medium = 2;
		int large = 4;
		int minToppings = 1;
		int maxToppings = 7;
		
		
		if(size.getPizzaSize().equals("small")) {
			
			if(toppingAmount == minToppings) {
				pricePepperoni = regularPrice;
			}
			if(toppingAmount > minToppings && toppingAmount <= maxToppings) {
				pricePepperoni = regularPrice + (extraToppings * (toppingAmount - minToppings));
			}
			
		}

		if(size.getPizzaSize().equals("medium")) {
			if(toppingAmount == minToppings) {
				pricePepperoni = regularPrice + medium;
			}
			if(toppingAmount > minToppings && toppingAmount <= maxToppings) {
				pricePepperoni = (regularPrice + medium) + (extraToppings * (toppingAmount - minToppings));
			}
			
		}
		if(size.getPizzaSize().equals("large")) {
			if(toppingAmount == minToppings) {
				pricePepperoni = regularPrice + large;
			}
			if(toppingAmount > minToppings && toppingAmount <= maxToppings) {
				pricePepperoni = (regularPrice + large) + (extraToppings * (toppingAmount - minToppings));
			}
			
		}
		
		pricePepperoni = pricePepperoni * tax;
		
		String temp = df.format(pricePepperoni);	   
	    double finalPrice = Double.parseDouble(temp);
	    
		return finalPrice;
		
	}
	
//	public static void main(String[] args) {
//		String yum = "Cheese,Ham,Chicken";
//		String size = "large";
//		Pepperoni angelicaPizza = new Pepperoni(yum,size);
//		System.out.println(angelicaPizza.price());
//		//,Beef,Onion,Mushroom,Ham
//	}
	
}
