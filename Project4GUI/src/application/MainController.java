package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {
	
	public void deluxeP() {
		customize();
	}
	
	public void hawaiianP() {
		
	}
	
	public void pepperoniP() {
		
	}
	
	public void orders() {
		
	}
	
	public void current() {
		
	}
	
	public void customize() {
		try {
			Stage stage= new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("CustomizePizzaView.fxml"));
			Scene scene = new Scene(root,500,610);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
