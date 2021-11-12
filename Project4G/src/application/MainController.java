package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

@FXML
TextField phoneMain;

public class MainController {
	private String pizza;
	public void deluxeP() {
		if(alert()) {
			String deluxe="Deluxe";
			this.pizza=deluxe;
			customize();
		}
	}
	
	public void hawaiianP() {
		if(alert()) {	
			String hawaiian="Hawaiian";
			this.pizza=hawaiian;
			customize();
		}
	}
	
	public void pepperoniP() {
		if(alert()) {
			String pepperoni="Pepperoni";
			this.pizza=pepperoni;
			customize();
		}
	}
	
	public void orders() {
		
	}
	
	public void current() {
		
	}
	
	public boolean alert() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText("Ordering Pizzas");
		alert.setContentText("Start a new order!");
		alert.showAndWait();
		if(alert.getResult().equals(ButtonType.OK)) {
			return true;
		}
		return false;
	}
	
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

	public String getPizza() {
		return pizza;
	}
	
}
