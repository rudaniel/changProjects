package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
		if(order==null||pizzaList.getSelectionModel().getSelectedItem()==null) {
			Alert alert=new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Warning!");
			alert.setHeaderText("Selection is empty");
			alert.setContentText("Select Pizza's to edit Order!");
			alert.showAndWait();
			return;
		}
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
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		if(order==null) {
			alert=new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Warning!");
			alert.setHeaderText("Order is empty");
			alert.setContentText("Add Pizza's to Create Order!");
			alert.showAndWait();
			return;
		}
		if(pizzaList.getItems().size()==0) {
			alert=new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Warning!");
			alert.setHeaderText("Order is empty");
			alert.setContentText("Add Pizza's to Create Order!");
			alert.showAndWait();
			return;
		}
		alert.setTitle("Information");
		alert.setHeaderText("Placing Order");
		alert.setContentText("Order Added!");
		alert.showAndWait();
		phoneNumber.setText("");
		subTotal.setText("");
		salesTax.setText("");
		orderTotal.setText("");
		pizzaList.getItems().clear();
		if(alert.getResult().equals(ButtonType.OK)) {
				orders.addOrder(order);
				mainController.addPhone(phone);
				order=null;
				mainController.setOrder(order);
				mainController.setOrders(orders);
				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information");
				alert.setHeaderText("Order Confirmed");
				alert.setContentText("Pizza has been added to Store Orders!");
				alert.showAndWait();
		}
	}
	
	/**
	 * Transfer the information from the Main Controller to this UI controller.
	 * @param controller from main menu.
	 */
	public void setMainController(MainController controller) {
		mainController=controller;
		phone=mainController.getPhone();
		phoneNumber.setText(phone);	
		orders=mainController.getOrders();
		order=mainController.getOrder();
		getPizzas();
	}
	
	/**
	 * The total pizzas that the user ordered is displayed.
	 * The prices for the total order is then calculated and set.
	 */
	public void getPizzas() {
		if(order==null) {
			return;
		}
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
