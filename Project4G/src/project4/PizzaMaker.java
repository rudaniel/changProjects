package project4;

public class PizzaMaker {
	public static Pizza createPizza(String flavor) {
		String deluxe="Deluxe";
		String hawaiian="Hawaiian";
		String pepperoni="Pepperoni";
		Pizza pizza=null;
		if(flavor.equals(deluxe)) {
			pizza= new Deluxe();
		}
		else if(flavor.equals(hawaiian)) {
			pizza= new Hawaiian();
		}
		else if(flavor.equals(pepperoni)) {
			pizza= new Pepperoni();
		}
		return pizza;
	}
}
