package application;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project4.Order;
import project4.StoreOrders;

/**
 * The Main Controller will open the other UIs based on user selection.
 * @author Manav Bali
 * @author Daniel Lopez
 */
public class MainController {
	
	@FXML
	TextField phoneMain;
	
	private String phoneNumber;
	private String pizza;
	private StoreOrders orders = new StoreOrders();
	private Order order;
	private ArrayList<String> phoneNumberList = new ArrayList<String>();
	
	/**
	 * Will call the Customize UI with the pizza type of deluxe.
	 */
	public void deluxeP() {
		if(alert()) {
			String deluxe="Deluxe";
			this.pizza=deluxe;
//			if(!phoneNumberList.contains(phoneNumber)) {
//				this.phoneNumberList.add(phoneNumber);
//			}
			customize();
		}
	}
	
	/**
	 * Will call the Customize UI with the pizza type of hawaiian.
	 */
	public void hawaiianP() {
		if(alert()) {	
			String hawaiian="Hawaiian";
			this.pizza=hawaiian;
//			if(!phoneNumberList.contains(phoneNumber)) {
//				this.phoneNumberList.add(phoneNumber);
//			}
			customize();
		}
	}
	
	/**
	 * Will call the Customize UI with the pizza type of pepperoni.
	 */
	public void pepperoniP() {
		if(alert()) {
			String pepperoni="Pepperoni";
			this.pizza=pepperoni;
//			if(!phoneNumberList.contains(phoneNumber)) {
//				this.phoneNumberList.add(phoneNumber);
//			}
			customize();
		}
	}
	
	/**
	 * Will open the Store Order UI.
	 */
	public void orders() {
		try {
				Stage stage= new Stage();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("StoreOrderView.fxml"));
				Parent root = loader.load();
				Scene scene = new Scene(root,600,400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
				StoreOrderController custom= loader.getController();
				custom.setMainController(this);
	
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * Will open the Current Order UI.
	 */
	public void current() {
		if(phoneCheck()){
			try {
				Stage stage= new Stage();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("CurrentOrderView.fxml"));
				Parent root = loader.load();
				Scene scene = new Scene(root,600,400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
				CurrentOrderController custom= loader.getController();
				custom.setMainController(this);
	
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Checks to make sure a phone number is entered before the user can create their pizza.
	 * @return true if valid number, false otherwise.
	 */
	public boolean alert() {
		if(!phoneCheck()) {
			return false;
		}
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText("Ordering Pizzas");
		alert.setContentText("Start a new order!");
		alert.showAndWait();
		if(alert.getResult().equals(ButtonType.OK))
			return true;
		return false;
	}
	
	/**
	 * Makes sure that the phone number is valid.
	 * @return true is valid number, false otherwise.
	 */
	public boolean phoneCheck() {
		String blank="";
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning!");
		if(phoneMain.getText()==null||phoneMain.getText().equals(blank)) {
			alert.setHeaderText("Phone Number field is empty.");
			alert.setContentText("Please enter a valid Phone Number.");
			alert.showAndWait();
			return false;
		}
		try {
			String number=phoneMain.getText();
		//	Integer.parseInt(number);
//			if(number.length()!=10 && number.matches("[0-9+")) {
				if(number.length()!=10) {
				alert.setHeaderText("Phone Number field is not 10 digits.");
				alert.setContentText("Please enter a valid Phone Number containing 10 digits.");
				alert.showAndWait();
				return false;
			}
		}
		catch(Exception e) {
			alert.setHeaderText("Phone Number field contains invalid Phone Number.");
			alert.setContentText("Please enter a valid Phone Number only containing digits.");
			alert.showAndWait();
			return false;
		}
		phoneNumber=phoneMain.getText();
		return true;
	}
	
	/**
	 * Opens the Customize UI and transfers data from this UI.
	 */
	public void customize() {
		try {
			Stage stage= new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomizePizzaView.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root,500,610);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			CustomizeController custom= loader.getController();
			custom.setMainController(this);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Getter method for pizza type.
	 * @return pizza
	 */
	public String getPizza() {
		return pizza;
	}
	
	/**
	 * Getter method for phone number.
	 * @return phoneNumber
	 */
	public String getPhone() {
		return phoneNumber;
	}
	
	/**
	 * Getter method for order list.
	 * @return orders list
	 */
	public StoreOrders getOrders() {
		return orders;
	}
	
	/**
	 * Getter method for phone number list.
	 * @return phone number list.
	 */
	public ArrayList<String> getNumbers() {
		return phoneNumberList;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order= order;
	}
	
	public void addPhone(String phone) {
		phoneNumberList.add(phone);
	}

	public void setOrders(StoreOrders orders) {
		this.orders=orders;
	}
}
