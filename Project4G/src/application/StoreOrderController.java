package application;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import project4.Order;
import project4.Pizza;
import project4.StoreOrders;

/**
 * The Store Order class will be used to see final orders.
 * Orders can be canceled and exported.
 * @author Manav Bali
 * @author Daniel Lopez
 */
public class StoreOrderController {

	@FXML
	public ComboBox <String> numberList;
	
	@FXML
	public TextField orderTotal;
	
	@FXML
	private ListView<Pizza> finalOrders;
	
	@FXML
	private Button cancelOrder;
	
	@FXML
	private Button exportOrder;
	
	private MainController mainController;
	private Order order;
	private ArrayList<Pizza> pizzas;
	private ArrayList<String> phoneNumberList;
	private StoreOrders orders;
	private double subT;
	private double orderTax;
	private double orderTotals;
	DecimalFormat df = new DecimalFormat("0.00");
	
	/**
	 * Transfer the information from the Main Controller to this UI controller.
	 * @param controller from main menu.
	 */
	public void setMainController(MainController controller) {
		mainController=controller;
		phoneNumberList=mainController.getNumbers();
		numberList.getItems().addAll(phoneNumberList);
		numberList.setOnAction(this::selectedNumber);
		orders = mainController.getOrders();
		if(phoneNumberList.isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Warning!");
			alert.setHeaderText("Empty Orders");
			alert.setContentText("Create a order and try again!");
			alert.showAndWait();
		}
		else {
			order=orders.getOrder(phoneNumberList.get(0));
			pizzas=order.getPizzas();
			finalOrders.getItems().clear();
			finalOrders.getItems().addAll(pizzas);
			numberList.getSelectionModel().select(phoneNumberList.get(0));
			double taxAmount = 1.06625;
			this.subT = order.subTotal(pizzas);
			this.orderTax = (subT * taxAmount) - subT;
			this.orderTotals = subT + orderTax;
			orderTotal.setText(String.valueOf(df.format(orderTotals)));
		}
	}
	
	/**
	 * When a phone number is selected the values will change accordingly.
	 * @param e The action event that calls selected number.
	 */
	public void selectedNumber(ActionEvent e) {
		
		int index= numberList.getSelectionModel().getSelectedIndex();
		if(index==-1) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Warning!");
			alert.setHeaderText("Empty Orders");
			alert.setContentText("Create a order and try again!");
			alert.showAndWait();
			return;
		}
		order=orders.getOrders().get(index);
		pizzas=order.getPizzas();
		finalOrders.getItems().clear();
		finalOrders.getItems().addAll(pizzas);
		double taxAmount = 1.06625;
		this.subT = order.subTotal(pizzas);
		this.orderTax = (subT * taxAmount) - subT;
		this.orderTotals = subT + orderTax;
		orderTotal.setText(String.valueOf(df.format(orderTotals)));
	}
	
	/**
	 * Removes the order from the order list and from the UI.
	 * @param e event of button.
	 */
	public void removeOrder(ActionEvent e) {
		int index= numberList.getSelectionModel().getSelectedIndex();
		if(index==-1) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Warning!");
			alert.setHeaderText("No Orders");
			alert.setContentText("Select a order and try again!");
			alert.showAndWait();
			return;
		}
		order=orders.getOrders().get(index);
		orders.removeOrder(index); 
		finalOrders.getItems().clear();
		phoneNumberList.remove(index);
		mainController.setNumbers(phoneNumberList);
		orderTotal.clear();
		numberList.getItems().remove(index);
	}
	
	/**
	 * Calls the export method to create the text file.
	 * @param e event of button.
	 */
	public void export(ActionEvent e){
		Alert alert;
		if(orders.export()) {
			alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText("Exporting");
			alert.setContentText("Text File!");
			alert.showAndWait();
		}
		else {
			alert=new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Error!");
			alert.setHeaderText("Orders Have Not Been Exported");
			alert.setContentText("Please Try Again!");
			alert.showAndWait();
			return;
		}	
	}
}
