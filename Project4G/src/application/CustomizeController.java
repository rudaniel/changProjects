package application;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import project4.Pizza;
import project4.PizzaMaker;
import project4.Topping;
import project4.Size;
import project4.StoreOrders;

public class CustomizeController {
	
	private MainController mainController;
	private String flavor;
	private StoreOrders orders;
	private String phone;
	private Pizza pizza;
	
	ObservableList<Size> sizes= FXCollections.observableArrayList(Arrays.asList(Size.values()));
	ObservableList<Topping> Toppings= FXCollections.observableArrayList(Arrays.asList(Topping.values()));
	ObservableList<Topping> selectedToppings=FXCollections.observableArrayList(Arrays.asList(Topping.values()));
	@FXML
	public ComboBox<Size> size;
	
	@FXML
	public ListView<Topping> sTop, aTop;
	
	@FXML
	public ImageView pizzaImg;
	
	@FXML
	public Label pizzaLbl;
	
	@FXML
	public TextField price;

	@FXML
	public void initialize() {
		size.setItems(sizes);
		size.setValue(Size.Small);
		aTop.getItems().addAll(Toppings);
		size.valueProperty().addListener(new ChangeListener<Size>() {
	        @Override public void changed(ObservableValue ov, Size oldS, Size newS) {
	        	String blank="";
	        	pizza.setSize(newS);
	        	price.setText(pizza.price()+blank);
	        }    
	    });
	}
	
	public void set() {
		Image image=null;
		String text="";
		String deluxe="Deluxe";
		String hawaiian="Hawaiian";
		String pepperoni="Pepperoni";
		if(flavor.equals(deluxe)){
			image= new Image("/deluxePizza.png");
			text=deluxe;
		}
		else if(flavor.equals(hawaiian)) {
			image= new Image("/hawaiianPizza.png");
			text=hawaiian;	
		}
		else if(flavor.equals(pepperoni)){
			image= new Image("/pepperoniPizza.png");
			text=pepperoni;
		}
		pizzaImg.setImage(image);
		pizzaLbl.setText(text);
		selectedToppings=FXCollections.observableArrayList(pizza.getToppings());
		Toppings.removeAll(selectedToppings);
		aTop.getItems().clear();
		aTop.getItems().addAll(Toppings);
		sTop.getItems().addAll(selectedToppings);
		String blank="";
    	price.setText(pizza.price()+blank);
	}

	public void setMainController(MainController controller) {
		this.mainController=controller;
		this.flavor=mainController.getPizza();
		this.pizza=PizzaMaker.createPizza(flavor);
		this.phone=mainController.getPhone();
		this.orders=mainController.getOrders();
		set();
		
	}
	
	public void addTop() {
		if(!aTop.getSelectionModel().isEmpty()) {
			int index=aTop.getSelectionModel().getSelectedIndex();
			sTop.getItems().add(aTop.getItems().get(index));
			aTop.getItems().remove(index);
			pizza.setToppings(new ArrayList<Topping>(sTop.getItems()));
			String blank="";
        	price.setText(pizza.price()+blank);
		}
	}
	
	public void removeTop() {
		if(!sTop.getSelectionModel().isEmpty()) {
			int index=sTop.getSelectionModel().getSelectedIndex();
			aTop.getItems().add(sTop.getItems().get(index));
			sTop.getItems().remove(index);
			pizza.setToppings(new ArrayList<Topping>(sTop.getItems()));
			String blank="";
        	price.setText(pizza.price()+blank);
		}
	}
	
	public void addOrder() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText("Adding Pizzas");
		alert.setContentText("Do you want to add this Pizaa to the order?");
		alert.showAndWait();
		if(alert.getResult().equals(ButtonType.OK)) {
			if(orders.add(phone, pizza)) {
				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information");
				alert.setHeaderText("Added Pizza");
				alert.setContentText("Pizza has been added to Order!");
				alert.showAndWait();
			}
		}
	}
	
}
