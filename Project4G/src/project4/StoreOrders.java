package project4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

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
	
//	public boolean addOrder(Order order) {
//		orders.add(order);
//		return true;
//	}
	
	public Order getOrder(String phone) {
		Order temp =new Order(phone);
		int index=orders.indexOf(new Order(phone));
		if(index==-1) {
			return null;
		}
		return orders.get(index);
	}
	
	public boolean removeOrder(Order order) {
		orders.remove(order);
		return true;
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
	
	public boolean export(ArrayList<String> phoneNumberList, StoreOrders orders) throws IOException {
		ArrayList<Pizza> pizzas;
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Open Target File for the Export");
		chooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"),
				new ExtensionFilter("All Files", "*.*"));
		Stage stage = new Stage();
		File targetFile = chooser.showSaveDialog(stage); //get the reference of the target file
		//write code to write to the file.
		
		FileWriter fw = new FileWriter(targetFile, true);
		
		PrintWriter pw = new PrintWriter(fw);
		for(int i = 0; i < phoneNumberList.size(); i++) {
			Order order= getOrder(phoneNumberList.get(i));
			
			pizzas = order.getPizzas();
			for(int j =0; j < pizzas.size(); j++) {
				pw.println(pizzas.get(j).toString());
				
				//System.out.println(pizzas.get(j));
				System.out.println(pizzas.get(j).toString());
			}
		
			
		}
	
		pw.close();
		return true;
	}
	
	
}
