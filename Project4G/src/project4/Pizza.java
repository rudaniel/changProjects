package project4;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

public abstract class Pizza {

	protected ArrayList <Topping> toppings = new ArrayList<Topping>();
	protected Size size;
	static final double tax = 1.06625;
	static final double extraToppings = 1.49;
	static final DecimalFormat df = new  DecimalFormat(".00") ;
	
	public abstract double price();
	
	public Pizza (String toppingList, String pizzaSize) {
		Size temp = new Size(pizzaSize); 
		this.size = temp;
		StringTokenizer reader = new StringTokenizer(toppingList,",");
		while((reader.hasMoreTokens())) {
			try {
				this.toppings.add(Topping.valueOf(reader.nextToken()));
			}
			catch(IllegalArgumentException e) {
				this.toppings.add(Topping.valueOf("UNKNOWN"));
			};
		}
		
	}
	public Pizza (ArrayList<String> toppingList, String pizzaSize) {
		this.size = new Size(pizzaSize); 
		while(!toppingList.isEmpty()) {
			int item=0;
			try {
				this.toppings.add(Topping.valueOf(toppingList.get(item)));
				toppingList.remove(item);
			}
			catch(IllegalArgumentException e) {
				this.toppings.add(Topping.valueOf("UNKNOWN"));
			};
		}
		
	}
	@Override
	public String toString() {
		return toppings+" :deluxe: "+size;
	}
}
