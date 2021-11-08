package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;

public class CustomizeController {
	
	ObservableList<String> sizes= FXCollections.observableArrayList("Small","Medium","Large");
	ObservableList<String> Toppings= FXCollections.observableArrayList("Beef","Black Olives","Cheese","Chicken","Green Pepper","Ham","Mushroom","Onion","Pepperoni","Pineapple","Sausage");
	@FXML
	public ChoiceBox size;
	
	@FXML
	public ListView sTop;
	
	@FXML
	public Pane pizzaImg;
	
	@FXML
	public Label pizzaLbl;
	
	@FXML
	public void initialize() {
		size.setItems(sizes);
		size.setValue("Small");
		sTop.getItems().addAll(Toppings);
		sTop.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
	
	public void set(int pizza) {
		Image image;
		if(pizza==0){
			image= new Image("/deluxePizza.png");
		}
		else if(pizza==1) {
			image= new Image("/hawaiianPizza.png");
		}
		else{
			image= new Image("/pepperoniPizza.png");
		}
		BackgroundImage back= new BackgroundImage(image,null,null,null,null);
		pizzaImg.setBackground(new Background(back));
	}
	
}
