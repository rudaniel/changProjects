package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class controller1 {
	
	String comma = ",";
	String T = "T";
	String F = "F";

	@FXML
	TextField addTextField = new TextField();
	
	@FXML
	TextField creditHourTextField = new TextField();
	
	@FXML
	RadioButton csMajor, itMajor, baMajor, eeMajor, meMajor;
	
	
	public void addStudent(ActionEvent e) {
		
		String name = addTextField.getText();
		System.out.println(name);
		int creditHour = Integer.parseInt(creditHourTextField.getText());
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
	TextField getNamePay;
	
	
	@FXML
	RadioButton csMajorPay, itMajorPay, baMajorPay, eeMajorPay, meMajorPay;
	
	@FXML
	TextArea displayBoard;
	
	@FXML
	TextField payTotal, payAid;
	
	@FXML
	DatePicker paymentDate;
	
	String majorPay;
	
	public void getMajorPay(ActionEvent e) {
		
		
		if(csMajorPay.isSelected()) {
			majorPay = csMajorPay.getText();
		}
		if(itMajorPay.isSelected()) {
			majorPay = itMajorPay.getText();
		}
		if(baMajorPay.isSelected()) {
			majorPay = baMajorPay.getText();
		}
		if(eeMajorPay.isSelected()) {
			majorPay = eeMajorPay.getText();
		}
		if(meMajorPay.isSelected()) {
			majorPay = meMajorPay.getText();
		}
	//	System.out.println(majorPay);
		
	}
	
	
public void paymentTotal(ActionEvent e) {
	String namePay = getNamePay.getText();
	String amountPaid = payTotal.getText();
	String aidPaid = payAid.getText();
	boolean realNumAmount = isNumber(amountPaid);
	//boolean realNumAid = isNumber(aidPaid);
	LocalDate date = paymentDate.getValue();
	String formatDate = date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		
		
		if(namePay.length() != 0 && validName(namePay)) {
			if(majorPay.length() != 0) {
				if(amountPaid.length() != 0 && realNumAmount == true && aidPaid.length() == 0) {
					if(formatDate.length() != 0) {
						String finalPayment = T + comma + namePay + comma + majorPay + comma + amountPaid + comma + formatDate;
						displayBoard.appendText(finalPayment + "\n");
						//System.out.println(finalPayment);
					}
				}
			}
		}
		
	
		
		
		
		//System.out.println("T,"+ namePay + "," +majorPay +","+ amountPaid + "," + formatDate );
	}

public void paymentAid(ActionEvent event) {
	String namePay = getNamePay.getText();
	String amountPaid = payTotal.getText();
	String aidPaid = payAid.getText();
	//boolean realNumAmount = isNumber(amountPaid);
	boolean realNumAid = isNumber(aidPaid);
	LocalDate date = paymentDate.getValue();
	String formatDate = date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	
	if(namePay.length() != 0 && validName(namePay)) {
		if(majorPay.length() != 0) {
			if(aidPaid.length() != 0 && realNumAid == true && amountPaid.length() == 0) {
				if(formatDate.length() != 0) {
					String finalPayment = F + comma + namePay + comma + majorPay + comma + aidPaid + comma + formatDate;
					//System.out.println(finalPayment);
					displayBoard.appendText(finalPayment + "\n");
				}
			}
		}
	}
}

public static boolean validName(String name) {
	if (name.contains(" ")) {
		return true;
	} 
	else {
		return false;
	
	}
}

	
	public static boolean isNumber(String amountPaid) {
		try {
			double number = Double.parseDouble(amountPaid);
			if(number >0) {
				return true;
			}
			return false;
			
		} catch(NumberFormatException e) {
			return false;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
