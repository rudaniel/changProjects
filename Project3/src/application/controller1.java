package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class controller1 {

	@FXML
	TextField addTextField = new TextField();
	
	@FXML
	TextField creditHourTextField = new TextField();
	
	@FXML
	RadioButton csMajor = new RadioButton();
	
	@FXML
	RadioButton itMajor = new RadioButton();
	
	@FXML
	RadioButton baMajor = new RadioButton();
	
	@FXML
	RadioButton eeMajor = new RadioButton();
	
	@FXML
	RadioButton meMajor = new RadioButton();
	
	
	public void addStudent(ActionEvent e) {
		
		String name = addTextField.getText();
		System.out.println(name);
	}
	
public void creditHour(ActionEvent e) {
		
		int creditHour = Integer.parseInt(addTextField.getText());
		System.out.println(creditHour);
	}
	
	public void getMajor(ActionEvent e) {
		String major = null;
		
		if(csMajor.isSelected()) {
			major = csMajor.getText();
		}
		if(itMajor.isSelected()) {
			major = itMajor.getText();
		}
		if(baMajor.isSelected()) {
			major = baMajor.getText();
		}
		if(eeMajor.isSelected()) {
			major = eeMajor.getText();
		}
		if(meMajor.isSelected()) {
			major = meMajor.getText();
		}
		System.out.println(major);
		
	}
	
	@FXML
	TextField getNamePay = new TextField();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
