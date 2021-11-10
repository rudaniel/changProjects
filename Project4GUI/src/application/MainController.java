package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainController {
	private int pizza=0;
	public void deluxeP() {
		this.pizza=0;
		customize();
	}
	
	public void hawaiianP() {
		this.pizza=1;
		customize();
	}
	
	public void pepperoniP() {
		this.pizza=2;
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

	public int getPizza() {
		return pizza;
	}
	
}
