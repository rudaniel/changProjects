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
import project4.Order;
import project4.Pizza;
import project4.PizzaMaker;
import project4.Topping;
import project4.Size;

/**
 * The Customize Controller class will be used to create the user's pizza.
 * Same UI for all pizza types.
 * @author Manav Bali
 * @author Daniel Lopez
 */
public class CustomizeController {
	
	private MainController mainController;
	private String flavor;
	//private StoreOrders orders;
	private String phone;
	private Pizza pizza;
	private Pizza pizza2;
	
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
	private Order order;

	/**
	 * Initializes the UI to default settings for the user to customize.
	 */
	public void initialize() {
		size.setItems(sizes);
		size.setValue(Size.Small);
		aTop.getItems().addAll(Toppings);
		size.valueProperty().addListener(new ChangeListener<Size>() {
	        @Override public void changed(ObservableValue ov, Size oldS, Size newS) { //do i add comment?
	        	String blank="";
	        	pizza.setSize(newS);
	        	price.setText(pizza.price()+blank);
	        }    
	    });
	}
	
	/**
	 * Sets up the UI pizza image based on what the user selects.
	 * Adds the toppings based on what pizza the user selected. 
	 */
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
		sTop.getItems().clear();
		aTop.getItems().addAll(Toppings);
		sTop.getItems().addAll(selectedToppings);
		String blank="";
    	price.setText(pizza.price()+blank);
	}
	
	/**
	 * Transfer the information from the Main Controller to this UI controller.
	 * @param controller from main menu.
	 */
	public void setMainController(MainController controller) {
		this.mainController=controller;
		this.flavor=mainController.getPizza();
		this.pizza=PizzaMaker.createPizza(flavor);
		this.pizza2=PizzaMaker.createPizza(flavor);
		this.phone=mainController.getPhone();
		this.order=mainController.getOrder();
		set();
	}
	
	/**
	 * Adds the topping based on user selection.
	 * Subtotal of pizza is updated.
	 */
	public void addTop() {
		if(!aTop.getSelectionModel().isEmpty()) {
			if(sTop.getItems().size()==7) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Warning!");
				alert.setHeaderText("Maximum Toppings Reached");
				alert.setContentText("The Maximum number of allowed toppings is 7!");
				alert.showAndWait();
				return;
			}
			int index=aTop.getSelectionModel().getSelectedIndex();
			sTop.getItems().add(aTop.getItems().get(index));
			aTop.getItems().remove(index);
			pizza.setToppings(new ArrayList<Topping>(sTop.getItems()));
			String blank="";
        	price.setText(pizza.price()+blank);
		}
	}
	
	/**
	 * removes the topping based on user selection.
	 * Subtotal of pizza is updated.
	 */
	public void removeTop() {
		if(!sTop.getSelectionModel().isEmpty()) {
			int index=sTop.getSelectionModel().getSelectedIndex();
			if(pizza2.getToppings().contains(sTop.getItems().get(index))) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Warning!");
				alert.setHeaderText("Removing Toppings");
				alert.setContentText("Removing an Essential Topping!");
				alert.showAndWait();
			}
			aTop.getItems().add(sTop.getItems().get(index));
			sTop.getItems().remove(index);
			pizza.setToppings(new ArrayList<Topping>(sTop.getItems()));
			String blank="";
        	price.setText(pizza.price()+blank);
		}
	}
	
	/**
	 * Once the user is finished creating their pizza the order for that user is recorded.
	 */
	public void addOrder() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText("Adding Pizzas");
		alert.setContentText("Do you want to add this Pizza to the order?");
		alert.showAndWait();
		if(alert.getResult().equals(ButtonType.OK)) {
			if(order==null) {
				order=new Order(phone);
			} 
			order.addPizza(pizza);
			mainController.setOrder(order);
			pizza=PizzaMaker.createPizza(flavor);
			order=mainController.getOrder();
			set();
				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information");
				alert.setHeaderText("Added Pizza");
				alert.setContentText("Pizza has been added to Order!");
				alert.showAndWait();
		}
	}
}
