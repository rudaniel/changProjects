package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import project4.Order;
import project4.Pizza;
import project4.StoreOrders;


public class CurrentOrderController {

	
	private String flavor;
	private String toppings;
	private String size;
	@FXML
	private TextField phoneNumber;
	
	@FXML
	private TextField subTotal;
	
	@FXML
	private TextField salesTax;
	
	@FXML
	private TextField orderTotal;
	
	@FXML
	private ListView<Pizza> pizzaList;
	
	@FXML
	private Button rPizza;
	
	@FXML
	private Button placeOrder;
	
	private MainController mainController;
	private String phone;
	private Order order;
	private ArrayList<Pizza> pizzas;
	private StoreOrders orders;
	
	
	public void removePizza(ActionEvent e) {
		Pizza selected=pizzaList.getSelectionModel().getSelectedItem();
		if(selected!=null) {
			order.removePizza(selected);
			getPizzas();
		}
	}
	
	public void confirmOrder(ActionEvent e) {
		displayPopUp();
		phoneNumber.setText("");
		subTotal.setText("");
		salesTax.setText("");
		orderTotal.setText("");
		pizzaList.getItems().clear();
		
		//After this is should be moved to store order fxml
		
	}
	public void setMainController(MainController controller) {
		mainController=controller;
		flavor=mainController.getPizza();
		phone=mainController.getPhone();
		phoneNumber.setText(phone);	
		orders=mainController.getOrders();
		order=orders.getOrder(phone);
		getPizzas();
		
	}
	
	public void getPizzas() {
		pizzas=order.getPizzas();
		pizzaList.getItems().clear();
		pizzaList.getItems().addAll(pizzas);
		
	}
	public static void displayPopUp() {
		 
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText("Placing Order");
		alert.setContentText("Order Added!");
		alert.showAndWait();
		
	}
	
	
	
}
