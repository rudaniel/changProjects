package application;

import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;

public class CustomizeController {
	
	private MainController mainController;
	ObservableList<String> sizes= FXCollections.observableArrayList("Small","Medium","Large");
	ObservableList<String> Toppings= FXCollections.observableArrayList("Beef","Black Olives","Cheese","Chicken","Green Pepper","Ham","Mushroom","Onion","Pepperoni","Pineapple","Sausage");
	ObservableList<String> selectedToppings;
	@FXML
	public ChoiceBox<String> size;
	
	@FXML
	public ListView sTop, aTop;
	
	@FXML
	public Pane pizzaImg;
	
	@FXML
	public Label pizzaLbl;
	
	@FXML
	public TextField price;
	
	@FXML
	public void initialize() {
		String small="Small";
		String medium="Medium";
		String large="Large";
		size.setItems(sizes);
		size.setValue(small);
		aTop.getItems().addAll(Toppings);
		size.valueProperty().addListener(new ChangeListener<String>() {
	        @Override public void changed(ObservableValue ov, String oldS, String newS) {
	        	Double curPrice= Double.parseDouble(price.getText());
	        	String blank="";
	        	int big=4;
	        	int little=2;
	        	String temp="";
	        	if(newS.equals(small)){
	        		if(oldS.equals(medium))
	        			temp=(curPrice-little)+blank;
	        		if(oldS.equals(large))
	        			temp=(curPrice-big)+blank;
	        	}
	        	else if(newS.equals(large)) {
	        		if(oldS.equals(medium))
	        			temp=(curPrice+little)+blank;
	        		if(oldS.equals(small))
	        			temp=(curPrice+big)+blank;
	        	}
	        	else {
	        		if(oldS.equals(large))
	        			temp=(curPrice-little)+blank;
	        		if(oldS.equals(small))
	        			temp=(curPrice+little)+blank;
	        	}
	        	price.setText(temp);
	        }    
	    });
	}
	
	public void set() {
		int pizza=mainController.getPizza();
		Image image;
		String text;
		if(pizza==0){
			image= new Image("/deluxePizza.png");
			text="Deluxe";
			selectedToppings=FXCollections.observableArrayList("Black Olives","Cheese","Chicken","Green Pepper","Mushroom");
			Toppings= FXCollections.observableArrayList("Beef","Ham","Onion","Pepperoni","Pineapple","Sausage");	
		}
		else if(pizza==1) {
			image= new Image("/hawaiianPizza.png");
			text="Hawaiian";
			selectedToppings=FXCollections.observableArrayList("Ham","Pineapple");
			Toppings= FXCollections.observableArrayList("Beef","Black Olives","Cheese","Chicken","Green Pepper","Mushroom","Onion","Pepperoni","Sausage");	
		}
		else{
			image= new Image("/pepperoniPizza.png");
			text="Pepperoni";
			selectedToppings=FXCollections.observableArrayList("Pepperoni");
			Toppings= FXCollections.observableArrayList("Beef","Black Olives","Cheese","Chicken","Green Pepper","Ham","Mushroom","Onion","Pineapple","Sausage");
		}
		BackgroundImage back= new BackgroundImage(image,null,null,null,null);
		pizzaImg.setBackground(new Background(back));
		pizzaLbl.setText(text);
		aTop.getItems().clear();
		aTop.getItems().addAll(Toppings);
		sTop.getItems().addAll(selectedToppings);
	}

	public void setMainController(MainController controller) {
		mainController=controller;
		set();
		
	}
	
	public void addTop() {
		if(!aTop.getSelectionModel().isEmpty()) {
			int index=aTop.getSelectionModel().getSelectedIndex();
			sTop.getItems().add(aTop.getItems().get(index).toString());
			aTop.getItems().remove(index);
		}
	}
	
	public void removeTop() {
		if(!sTop.getSelectionModel().isEmpty()) {
			int index=sTop.getSelectionModel().getSelectedIndex();
			aTop.getItems().add(sTop.getItems().get(index).toString());
			sTop.getItems().remove(index);
		}
	}
	
	public void addOrder() {
		ArrayList<String> aList=new ArrayList<> (aTop.getItems());
		ArrayList<String> sList=new ArrayList<> (sTop.getItems());
		System.out.println(aList);
		System.out.println(sList);
		
	}
	
}
