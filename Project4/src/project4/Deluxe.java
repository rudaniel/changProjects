package project4;

public class Deluxe extends Pizza {
	
	private double priceDeluxe;
	
	
	
	public Deluxe (String toppingList, String pizzaSize) {
	
		super(toppingList, pizzaSize);
	//	this.priceDeluxe = price();
	}
	
	@Override
	public double price() {
		
		
		int toppingAmount = toppings.size();
		double regularPrice = 12.99;
		int medium = 2;
		int large = 4;
		int minToppings = 5;
		int maxToppings = 7;
		
		
		if(size.getPizzaSize().equals("small")) {
			
			if(toppingAmount == minToppings) {
				priceDeluxe = regularPrice;
			}
			if(toppingAmount > minToppings && toppingAmount <= maxToppings) {
				priceDeluxe = regularPrice + (extraToppings * (toppingAmount - minToppings));
			}
			
		}

		if(size.getPizzaSize().equals("medium")) {
			if(toppingAmount == minToppings) {
				priceDeluxe = regularPrice + medium;
			}
			if(toppingAmount > minToppings && toppingAmount <= maxToppings) {
				priceDeluxe = (regularPrice + medium) + (extraToppings * (toppingAmount - minToppings));
			}
			
		}
		if(size.getPizzaSize().equals("large")) {
			if(toppingAmount == minToppings) {
				priceDeluxe = regularPrice + large;
			}
			if(toppingAmount > minToppings && toppingAmount <= maxToppings) {
				priceDeluxe = (regularPrice + large) + (extraToppings * (toppingAmount - minToppings));
			}
			
		}
		
		priceDeluxe = priceDeluxe * tax;
		
		String temp = df.format(priceDeluxe);	   
	    double finalPrice = Double.parseDouble(temp);
	    
		return finalPrice;
		
		
	}
	
	public static void main(String[] args) {
		String yum = "Cheese,Chicken,Beef,Onion,Mushroom,Ham";
		String size = "large";
		Deluxe angelicaPizza = new Deluxe(yum,size);
		System.out.println(angelicaPizza.price());
	}
	
}





















