package application;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
	private ListView finalOrders;
	
	@FXML
	private Button cancelOrder;
	
	@FXML
	private Button exportOrder;
	
	private MainController mainController;
	private String phone;
	private Order order;
	private ArrayList<Pizza> pizzas;
	private ArrayList<String> phoneNumberList;
	private StoreOrders orders;
	private double subT;
	private double orderTax;
	private double orderTotals;
	private String flavor;
	DecimalFormat df = new DecimalFormat("0.00");
	
	/**
	 * Transfer the information from the Main Controller to this UI controller.
	 * @param controller from main menu.
	 */
	public void setMainController(MainController controller) {
		mainController=controller;
		flavor=mainController.getPizza();
		phoneNumberList=mainController.getNumbers();
		
		
		numberList.getItems().addAll(phoneNumberList);
		numberList.setOnAction(this::selectedNumber);
		
	
		
		orders = mainController.getOrders();
		
		
	}
	
	/**
	 * When a phone number is selected the values will change accordingly.
	 */
	public void selectedNumber(ActionEvent e) {
		
		String currentNumber = numberList.getValue();
		
		order=orders.getOrder(currentNumber);
		pizzas=order.getPizzas();
		finalOrders.getItems().clear();
		finalOrders.getItems().addAll(pizzas);

		
		double taxAmount = 1.06625;
		this.subT = order.subTotal(pizzas);
		this.orderTax = (subT * taxAmount) - subT;
		this.orderTotals = subT + orderTax;
			

		orderTotal.setText(String.valueOf(df.format(orderTotals)));
			
//		for(int i =0; i< pizzas.size(); i++) {
//			System.out.println(pizzas.get(i));
//		}

		
	//	System.out.println(currentNumber);
		
	}
	
	/**
	 * Removes the order from the order list and from the UI.
	 * @param e event of button.
	 */
	public void removeOrder(ActionEvent e) {
		
		String currentNumber = numberList.getValue();
		order = orders.getOrder(currentNumber);
		orders.removeOrder(order); 
		finalOrders.getItems().clear();
		
		orderTotal.clear();
		numberList.getItems().remove(currentNumber);
		
	}
	
	/**
	 * Calls the export method to create the text file.
	 * @param e event of button.
	 */
	public void export(ActionEvent e) throws IOException {
		
		orders.export(phoneNumberList, orders);
			displayPopUp();
		
	}
	
	/**
	 * Once the order is placed this alert will appear.
	 */
	public static void displayPopUp() {
		 
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText("Exporting");
		alert.setContentText("Text File!");
		alert.showAndWait();
		
	}
	
}
