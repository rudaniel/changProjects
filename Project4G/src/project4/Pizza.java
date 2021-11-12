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
	
	public Pizza (String toppingList, Size pizzaSize) {
		this.size = pizzaSize; 
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
	public Pizza (ArrayList<String> toppingList, Size pizzaSize) {
		this.size = pizzaSize; 
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
	
	public Pizza() {
		this.size= Size.Small;
	}
	
	public void setSize(Size size) {
		this.size=size; 
	}
	
	public ArrayList<Topping> getToppings() {
		return toppings;
	}
	
	public void setToppings(ArrayList<Topping> toppings) {
		this.toppings=toppings;
	}
	
	@Override
	public String toString() {
		return toppings+", "+size+", "+"$"+price();
	}
	

}
