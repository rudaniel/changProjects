package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	 

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene =  new Scene(root);
		 	//scene.getStylesheets().add(getClass().getResource("applicatipron.css").toExternalForm());
			primaryStage.setTitle("Student Roster");
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
