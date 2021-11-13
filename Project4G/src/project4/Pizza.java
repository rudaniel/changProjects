package project4;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

/**
 * The Pizza abstract class will create the overall design for all the pizza types.
 * @author Manav Bali
 * @author Daniel Lopez
 */
public abstract class Pizza {

	protected ArrayList <Topping> toppings = new ArrayList<Topping>();
	protected Size size;
	static final double tax = 1.06625;
	static final double extraToppings = 1.49;
	static final DecimalFormat df = new  DecimalFormat(".00") ;
	
	/**
	 * Every class that extends this the Pizza abstract class must have this method.
	 */
	public abstract double price();
	
	/**
	 * Fills the toppings ArrayList and update size.
	 * This will allow for price to be calculated in the extending classes. 
	 * @param toppingList list of all toppings.
	 * @param pizzaSize size of pizza.
	 */
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
	
	/**
	 * Fills the toppings ArrayList and update size.
	 * This will allow for price to be calculated in the extending classes. 
	 * @param toppingList list of all toppings.
	 * @param pizzaSize size of pizza.
	 */
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
	
	/**
	 * Default size small when needed.
	 */
	public Pizza() {
		this.size= Size.Small;
	}
	
	/**
	 * Setter method to change size.
	 */
	public void setSize(Size size) {
		this.size=size; 
	}
	
	/**
	 * Getter method to get toppings list.
	 */
	public ArrayList<Topping> getToppings() {
		return toppings;
	}
	
	/**
	 * Setter method to set toppings list.
	 */
	public void setToppings(ArrayList<Topping> toppings) {
		this.toppings=toppings;
	}
	
	/**
	 * Method extends subclasses and is used to print desired output.
	 */
	@Override
	public String toString() {
		return toppings+", "+size+", "+"$"+price();
	}
	
	/**
	 * Method extends subclasses and is used to check if the object is equal to current pizza instance.
	 * @return true if equal, false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Pizza) {
			Pizza compare= (Pizza) obj;
			if (compare.size.equals(this.size)) {
				if (compare.toppings.equals(this.toppings)) {
					return true;
				}
			}
		}
		return false;
	}
	

}
