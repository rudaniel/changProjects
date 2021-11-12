package project4;

import java.util.ArrayList;

public class Order {
	private String phone;
	private ArrayList<Pizza> pizzas= new ArrayList();
	
	public Order(String phone) {
		this.phone=phone;
	}
	
	public void addPizza(Pizza pizza) {
		pizzas.add(pizza);
	}
	
	public void removePizza(Pizza pizza) {
		pizzas.remove(pizza);
	}
	
	public ArrayList<Pizza> getPizzas() {
		return pizzas;
	}
	
	public String getPhone() {
		return phone;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Order) {
			Order compare = (Order) obj;
			if(this.phone.equals(compare.phone)) {
				return true;
			}
		}
		return false;
	}
}
