package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
 * The Main class will set the foundation for the root and scene and call the Controller class.
 * @author Manav Bali
 * @author Daniel Lopez
 */
public class Main extends Application {
	
	 
	/**
	 * Sets the stage/scene for our UI.
	 * @param primaryStage the stage of UI.
	 */
	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
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
	/**
	 * Launches the stage.
	 * @param args.
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
