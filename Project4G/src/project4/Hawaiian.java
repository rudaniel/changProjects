package project4;

import java.util.Arrays;

public class Hawaiian extends Pizza {
	
	private double priceHawaiian;
	
	
//	public Hawaiian (String toppingList, Size pizzaSize) {
//		
//		super(toppingList, pizzaSize);
//	}
	
	public Hawaiian() {
		super();
		toppings.addAll(Arrays.asList(Topping.Ham,Topping.Pineapple));
	}	
	
	public double price() {
		
		int toppingAmount = toppings.size();
		double regularPrice = 10.99;
		int medium = 2;
		int large = 4;
		int minToppings = 2;
		int maxToppings = 7;
		
		
		if(size.equals(Size.Small)) {
			
			if(toppingAmount == minToppings) {
				priceHawaiian = regularPrice;
			}
			if(toppingAmount > minToppings && toppingAmount <= maxToppings) {
				priceHawaiian = regularPrice + (extraToppings * (toppingAmount - minToppings));
			}
			
		}

		if(size.equals(Size.Medium)) {
			if(toppingAmount == minToppings) {
				priceHawaiian = regularPrice + medium;
			}
			if(toppingAmount > minToppings && toppingAmount <= maxToppings) {
				priceHawaiian = (regularPrice + medium) + (extraToppings * (toppingAmount - minToppings));
			}
			
		}
		if(size.equals(Size.Large)) {
			if(toppingAmount == minToppings) {
				priceHawaiian = regularPrice + large;
			}
			if(toppingAmount > minToppings && toppingAmount <= maxToppings) {
				priceHawaiian = (regularPrice + large) + (extraToppings * (toppingAmount - minToppings));
			}
			
		}
		
		//priceHawaiian = priceHawaiian * tax;
		
		String temp = df.format(priceHawaiian);	   
	    double finalPrice = Double.parseDouble(temp);
	    
		return finalPrice;
		
	}
	
	@Override
	public String toString() {
		return "Hawaiian Pizza :"+ super.toString();
	}
	
//	public static void main(String[] args) {
//		String yum = "Cheese,Chicken";
//		String size = "large";
//		Hawaiian angelicaPizza = new Hawaiian(yum,size);
//		System.out.println(angelicaPizza.price());
//		//,Beef,Onion,Mushroom,Ham
//	}
}
