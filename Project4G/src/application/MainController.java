package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {
	private String pizza;
	public void deluxeP() {
		String deluxe="Deluxe";
		this.pizza=deluxe;
		customize();
	}
	
	public void hawaiianP() {
		String hawaiian="Hawaiian";
		this.pizza=hawaiian;
		customize();
	}
	
	public void pepperoniP() {
		String pepperoni="Pepperoni";
		this.pizza=pepperoni;
		customize();
	}
	
	public void orders() {
		
	}
	
	public void current() {
		
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
