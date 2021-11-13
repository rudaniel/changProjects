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
import java.text.DecimalFormat;

/**
 * The Current Order Controller displays the users order with prices.
 * The user can remove pizzas if needed and place final orders.
 * @author Manav Bali
 * @author Daniel Lopez
 */
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
	private double subT;
	private double orderTax;
	private double orderTotals;
	DecimalFormat df = new DecimalFormat("0.00");
	
	/**
	 * Removes the pizza the user selected and updates the prices.
	 * @param e the button click.
	 */
	public void removePizza(ActionEvent e) {
		Pizza selected=pizzaList.getSelectionModel().getSelectedItem();
		
		double taxAmount = 1.06625;
		double pizzaPrice = selected.price();
		
		this.subT = subT - pizzaPrice;
		this.orderTax = (subT * taxAmount) - subT;
		this.orderTotals = subT + orderTax;
		
		subTotal.setText(String.valueOf(df.format(subT)));
		salesTax.setText(String.valueOf(df.format(orderTax)));
		orderTotal.setText(String.valueOf(df.format(orderTotals)));
		
		if(selected!=null) {
			order.removePizza(selected);
			getPizzas();
		}
	}
	
	/**
	 * Resets the order page and transfers the data to Store Order Controller.
	 * @param e the button click.
	 */
	public void confirmOrder(ActionEvent e) {
		displayPopUp();
		phoneNumber.setText("");
		subTotal.setText("");
		salesTax.setText("");
		orderTotal.setText("");
		pizzaList.getItems().clear();
		
		//After this is should be moved to store order fxml
		
	}
	
	/**
	 * Transfer the information from the Main Controller to this UI controller.
	 */
	public void setMainController(MainController controller) {
		mainController=controller;
		flavor=mainController.getPizza();
		phone=mainController.getPhone();
		phoneNumber.setText(phone);	
		orders=mainController.getOrders();
		order=orders.getOrder(phone);
		getPizzas();
		
		
	}
	
	/**
	 * The total pizzas that the user ordered is displayed.
	 * The prices for the total order is then calculated and set.
	 */
	public void getPizzas() {
		pizzas=order.getPizzas();
		pizzaList.getItems().clear();
		pizzaList.getItems().addAll(pizzas);
		
		double taxAmount = 1.06625;
		this.subT = order.subTotal(pizzas);
		this.orderTax = (subT * taxAmount) - subT;
		this.orderTotals = subT + orderTax;
		
		subTotal.setText(String.valueOf(df.format(subT)));
		salesTax.setText(String.valueOf(df.format(orderTax)));
		orderTotal.setText(String.valueOf(df.format(orderTotals)));
		
	}
	
	/**
	 * Once the order is placed this alert will appear.
	 */
	public static void displayPopUp() {
		 
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText("Placing Order");
		alert.setContentText("Order Added!");
		alert.showAndWait();
		
	}
	
	
	
}
