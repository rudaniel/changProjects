package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StoreOrderController {

	@FXML
	public ChoiceBox <String> numberList;
	
	@FXML
	public TextField orderTotal;
	
	@FXML
	private ListView finalOrders;
	
	@FXML
	private Button cancelOrder;
	
	@FXML
	private Button exportOrder;
	
	
	public void removeOrder(ActionEvent e) {
		
		
	}
	
	public void export(ActionEvent e) {
		
		
	}
	
}
