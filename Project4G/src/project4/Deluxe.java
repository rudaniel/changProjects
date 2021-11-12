package project4;

import java.util.Arrays;


public class Deluxe extends Pizza {
	
	private double priceDeluxe;
	
	
//	public Deluxe (ArrayList<String> toppingList, Size pizzaSize) {
//		super(toppingList, pizzaSize);
//		
//		this.priceDeluxe = price();
//	}
	
	public Deluxe() {
		super();
		toppings.addAll(Arrays.asList(Topping.BlackOlives,Topping.Cheese,Topping.Chicken,Topping.GreenPepper,Topping.Mushroom));
	}	
	
	@Override
	public double price() {
		
		
		int toppingAmount = toppings.size();
		double regularPrice = 12.99;
		int medium = 2;
		int large = 4;
		int minToppings = 5;
		int maxToppings = 7;
		
		
		if(size.equals(Size.Small)) {
			
			if(toppingAmount == minToppings) {
				priceDeluxe = regularPrice;
			}
			if(toppingAmount > minToppings && toppingAmount <= maxToppings) {
				priceDeluxe = regularPrice + (extraToppings * (toppingAmount - minToppings));
			}
			
		}

		if(size.equals(Size.Medium)) {
			if(toppingAmount == minToppings) {
				priceDeluxe = regularPrice + medium;
			}
			if(toppingAmount > minToppings && toppingAmount <= maxToppings) {
				priceDeluxe = (regularPrice + medium) + (extraToppings * (toppingAmount - minToppings));
			}
			
		}
		if(size.equals(Size.Large)) {
			if(toppingAmount == minToppings) {
				priceDeluxe = regularPrice + large;
			}
			if(toppingAmount > minToppings && toppingAmount <= maxToppings) {
				priceDeluxe = (regularPrice + large) + (extraToppings * (toppingAmount - minToppings));
			}
			
		}
		
		//priceDeluxe = priceDeluxe * tax;
		
		String temp = df.format(priceDeluxe);	   
	    double finalPrice = Double.parseDouble(temp);
	    
		return finalPrice;
		
		
	}
	
	@Override
	public String toString() {
		return "Deluxe Pizza :"+ super.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Deluxe) {
			return super.equals(obj);
		}
		return false;
	}
	
//	public static void main(String[] args) {
//		String yum = "Cheese,Chicken,Beef,Onion,Mushroom,Ham";
//		String size = "large";
//		Deluxe angelicaPizza = new Deluxe(yum,size);
//		System.out.println(angelicaPizza.price());
//	}
	
}





















