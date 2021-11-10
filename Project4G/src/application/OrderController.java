package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class OrderController {

	
	private int pizzaType;
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
	private ListView pizzaList;
	
	@FXML
	private Button rPizza;
	
	@FXML
	private Button placeOrder;
	
	
	
	public void removePizza(ActionEvent e) {
		
		
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
	
	public static void displayPopUp() {
		 
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Information");
		alert.setHeaderText("Placing Order");
		alert.setContentText("Order Added!");
		alert.showAndWait();
		
	}
	
	
	
}
