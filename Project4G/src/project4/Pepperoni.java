package project4;

import java.util.Arrays;



public class Pepperoni extends Pizza {

	private double pricePepperoni;
	

//	public Pepperoni (String toppingList, Size pizzaSize) {
//	
//		super(toppingList, pizzaSize);
//	}

	public Pepperoni() {
		super();
		toppings.addAll(Arrays.asList(Topping.Pepperoni));
	}	
	
	public double price() {
		
		
		int toppingAmount = toppings.size();
		double regularPrice = 8.99;
		int medium = 2;
		int large = 4;
		int minToppings = 1;
		int maxToppings = 7;
		
		
		if(size.equals(Size.Small)) {
			
			if(toppingAmount == minToppings) {
				pricePepperoni = regularPrice;
			}
			if(toppingAmount > minToppings && toppingAmount <= maxToppings) {
				pricePepperoni = regularPrice + (extraToppings * (toppingAmount - minToppings));
			}
			
		}

		if(size.equals(Size.Medium)) {
			if(toppingAmount == minToppings) {
				pricePepperoni = regularPrice + medium;
			}
			if(toppingAmount > minToppings && toppingAmount <= maxToppings) {
				pricePepperoni = (regularPrice + medium) + (extraToppings * (toppingAmount - minToppings));
			}
			
		}
		if(size.equals(Size.Large)) {
			if(toppingAmount == minToppings) {
				pricePepperoni = regularPrice + large;
			}
			if(toppingAmount > minToppings && toppingAmount <= maxToppings) {
				pricePepperoni = (regularPrice + large) + (extraToppings * (toppingAmount - minToppings));
			}
			
		}
		
		//pricePepperoni = pricePepperoni * tax;
		
		String temp = df.format(pricePepperoni);	   
	    double finalPrice = Double.parseDouble(temp);
	    
		return finalPrice;
		
	}
	
	@Override
	public String toString() {
		return "Pepperoni Pizza :"+ super.toString();
	}
	
//	public static void main(String[] args) {
//		String yum = "Cheese,Ham,Chicken";
//		String size = "large";
//		Pepperoni angelicaPizza = new Pepperoni(yum,size);
//		System.out.println(angelicaPizza.price());
//		//,Beef,Onion,Mushroom,Ham
//	}
	
}
