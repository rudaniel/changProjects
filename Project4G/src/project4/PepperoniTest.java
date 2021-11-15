package project4;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PepperoniTest {

	@Test
	public void testPrice() {
		
		
	
		Pepperoni pizza = new Pepperoni();
		
		Pepperoni pizza2 = new Pepperoni();
		
		Pepperoni pizza3 = new Pepperoni();
		
		ArrayList<Topping> toppings = new ArrayList<Topping>();
		
		ArrayList<Topping> toppings2 = new ArrayList<Topping>();
		toppings2.add(Topping.Pepperoni);
		
		ArrayList<Topping> toppings3 = new ArrayList<Topping>();
		toppings3.add(Topping.Pepperoni);
		toppings3.add(Topping.Beef);
		
		Size size = Size.Small;
		
		Size size2 = Size.Medium;
		
		Size size3 = Size.Large;
		
		double compare = 8.99;
		double compare2 = 8.99;
		double compare3 = 10.48;
		
		
		
		pizza.setToppings(toppings); //no toppings
		pizza.setSize(size);
		
		pizza2.setToppings(toppings2); //1 toppings
		pizza2.setSize(size);
		
		pizza3.setToppings(toppings3); //2 toppings
		pizza3.setSize(size);
		
		
		double comparing = pizza.price();
		double comparing2 = pizza2.price();
		double comparing3 = pizza3.price();
		
		
		Pepperoni pizza4 = new Pepperoni();
		
		Pepperoni pizza5 = new Pepperoni();
		
		Pepperoni pizza6 = new Pepperoni();
		
		ArrayList<Topping> toppings4 = new ArrayList<Topping>();
		
		ArrayList<Topping> toppings5 = new ArrayList<Topping>();
		toppings5.add(Topping.Pepperoni);
		toppings5.add(Topping.Beef);
		
		ArrayList<Topping> toppings6 = new ArrayList<Topping>();
		toppings6.add(Topping.Pepperoni);
		toppings6.add(Topping.Beef);
		toppings6.add(Topping.BlackOlives);
		toppings6.add(Topping.Cheese);
	
		pizza4.setToppings(toppings4); //no toppings
		pizza4.setSize(size2);
		
		pizza5.setToppings(toppings5); //2 toppings
		pizza5.setSize(size2);
		
		pizza6.setToppings(toppings6); //4 toppings
		pizza6.setSize(size2);
		
		double comparing4 = pizza4.price();
		double comparing5 = pizza5.price();
		double comparing6 = pizza6.price();
		
		double compare4 = 10.99;
		double compare5 = 12.48;
		double compare6 = 15.46;

		
		Pepperoni pizza7 = new Pepperoni();
		
		Pepperoni pizza8 = new Pepperoni();
		
		Pepperoni pizza9 = new Pepperoni();
		
		ArrayList<Topping> toppings7 = new ArrayList<Topping>();
		
		ArrayList<Topping> toppings8 = new ArrayList<Topping>();
		toppings8.add(Topping.Pepperoni);
		toppings8.add(Topping.Beef);
		toppings8.add(Topping.BlackOlives);
		toppings8.add(Topping.Cheese);
		
		ArrayList<Topping> toppings9 = new ArrayList<Topping>();
		toppings9.add(Topping.Pepperoni);
		toppings9.add(Topping.Beef);
		toppings9.add(Topping.BlackOlives);
		toppings9.add(Topping.Cheese);
		toppings9.add(Topping.Chicken);
		toppings9.add(Topping.Mushroom);
		toppings9.add(Topping.Onion);
		
		pizza7.setToppings(toppings7); //no toppings
		pizza7.setSize(size3);
		
		pizza8.setToppings(toppings8); //4 toppings
		pizza8.setSize(size3);
		
		pizza9.setToppings(toppings9); //7 toppings
		pizza9.setSize(size3);
		
		double comparing7 = pizza7.price();
		double comparing8 = pizza8.price();
		double comparing9 = pizza9.price();

		
		double compare7 = 12.99;
		double compare8 = 17.46;
		double compare9 = 21.93;
		
		assertTrue(compare == comparing);
		
		assertTrue(compare2 == comparing2);
		
		assertTrue(compare3 == comparing3);
		
		assertTrue(compare4 == comparing4);
		
		assertTrue(compare5 == comparing5);
		
		assertTrue(compare6 == comparing6);
		
		assertTrue(compare7 == comparing7);
		
		assertTrue(compare8 == comparing8);
		
		assertTrue(compare9 == comparing9);
		
	}

}
