package project4;

import java.util.ArrayList;

public class StoreOrders {
	
	private ArrayList<Order> orders= new ArrayList<Order>();
	
	public StoreOrders() {
		
	}
	
	public StoreOrders(ArrayList<Order> orders) {
		this.orders=orders;
	}
	
	
	public boolean add(String phone, Pizza pizza) {
		Order order=new Order(phone);
		Order temp;
		int index=orders.indexOf(order);
		if(index!=-1) {
			temp= orders.get(index);
			temp.addPizza(pizza);
			orders.set(index, temp);
			return true;
			
		}
		else {
			temp =new Order(phone);
			temp.addPizza(pizza);
			orders.add(temp);
			return true;
		}
	}
	
	public Order getOrder(String phone) {
		Order temp =new Order(phone);
		int index=orders.indexOf(new Order(phone));
		if(index==-1) {
			return null;
		}
		return orders.get(index);
	}
	
	public boolean remove(String phone, Pizza pizza) {
		Order order=new Order(phone);
		Order temp;
		int index=orders.indexOf(order);
		if(index!=-1) {
			temp= orders.get(index);
			temp.removePizza(pizza);
			orders.set(index, temp);
			return true;
			
		}
		return false;
	}
}
