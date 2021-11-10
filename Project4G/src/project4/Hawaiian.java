package project4;

public class Hawaiian extends Pizza {
	
	private double priceHawaiian;
	
	
	public Hawaiian (String toppingList, String pizzaSize) {
		
		super(toppingList, pizzaSize);
	}
	
	
	public double price() {
		
		int toppingAmount = toppings.size();
		double regularPrice = 10.99;
		int medium = 2;
		int large = 4;
		int minToppings = 2;
		int maxToppings = 7;
		
		
		if(size.getPizzaSize().equals("small")) {
			
			if(toppingAmount == minToppings) {
				priceHawaiian = regularPrice;
			}
			if(toppingAmount > minToppings && toppingAmount <= maxToppings) {
				priceHawaiian = regularPrice + (extraToppings * (toppingAmount - minToppings));
			}
			
		}

		if(size.getPizzaSize().equals("medium")) {
			if(toppingAmount == minToppings) {
				priceHawaiian = regularPrice + medium;
			}
			if(toppingAmount > minToppings && toppingAmount <= maxToppings) {
				priceHawaiian = (regularPrice + medium) + (extraToppings * (toppingAmount - minToppings));
			}
			
		}
		if(size.getPizzaSize().equals("large")) {
			if(toppingAmount == minToppings) {
				priceHawaiian = regularPrice + large;
			}
			if(toppingAmount > minToppings && toppingAmount <= maxToppings) {
				priceHawaiian = (regularPrice + large) + (extraToppings * (toppingAmount - minToppings));
			}
			
		}
		
		priceHawaiian = priceHawaiian * tax;
		
		String temp = df.format(priceHawaiian);	   
	    double finalPrice = Double.parseDouble(temp);
	    
		return finalPrice;
		
	}
	
//	public static void main(String[] args) {
//		String yum = "Cheese,Chicken";
//		String size = "large";
//		Hawaiian angelicaPizza = new Hawaiian(yum,size);
//		System.out.println(angelicaPizza.price());
//		//,Beef,Onion,Mushroom,Ham
//	}
}
