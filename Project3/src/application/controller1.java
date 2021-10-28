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
	TextField nameProfile = new TextField();
	
	@FXML
	TextField creditHourTextField = new TextField();
	
	@FXML
	RadioButton csMajor, itMajor, baMajor, eeMajor, meMajor;
	
	@FXML
	RadioButton Resident, nonResident, tristate, ny, connecticut,internationalButton, abroadButton;
	
	@FXML
	TextArea displayBoardAdd;

	
	String major = null;
	String status = null;
	String state = null;
	boolean international;
	boolean abroad;
	
	public void getMajor(ActionEvent e) {

		
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
		//System.out.println(major);
		
	}

	
	public void getStatus(ActionEvent e) {
		
	
		if (Resident.isSelected()) {
			status = Resident.getText();
			tristate.setDisable(true);
			ny.setDisable(true);
			connecticut.setDisable(true);
			internationalButton.setDisable(true);
			abroadButton.setDisable(true);
			
			
			tristate.setSelected(false);
			ny.setSelected(false);
			connecticut.setSelected(false);
			internationalButton.setSelected(false);
			abroadButton.setSelected(false);
		}
		if (nonResident.isSelected()) {
			status = nonResident.getText();
			
			tristate.setDisable(false);
			internationalButton.setDisable(false);
			if(tristate.isSelected()) {
				ny.setDisable(false);
				connecticut.setDisable(false);
			//	internationalButton.setDisable(true);
				
				if(ny.isSelected()) {
					state = ny.getText();
				}
				if(connecticut.isSelected()) {
					state = connecticut.getText();
				}
			}
			else {
				ny.setDisable(true);
				connecticut.setDisable(true);
				ny.setSelected(false);
				connecticut.setSelected(false);
			//	internationalButton.setDisable(false);
			}
			
			if(internationalButton.isSelected()) {
				abroadButton.setDisable(false);
			//	tristate.setDisable(true);
				international = true;
				
				if(abroadButton.isSelected()) {
					abroad = true;
				}
				
			}
			else {
				abroadButton.setDisable(true);
				abroadButton.setSelected(false);
				tristate.setDisable(false);
				
			}
			
		}
		
	}
	
	String finalProfile = null;
	
	String residentadd = "AR";
	String nonResidentadd = "AN";
	String tristateadd = "AT";
	String internationaladd = "AI";
	
	public void addStudent(ActionEvent event1) {
		String name = nameProfile.getText();
		String credits = creditHourTextField.getText();
		
		
		
		if(name.length() != 0 && validName(name)) {
			if(major.length() != 0) {
				if(status.length() != 0) {
					if(status.equals("Resident")) {
						String finalProfile = residentadd + comma + name + comma + major + comma + credits;
						displayBoardAdd.appendText(finalProfile + "\n");
					}
					if(status.equals("Non-Resident") && state.length() == 0 && international == false) {
						String finalProfile = nonResidentadd + comma + name + comma + major + comma + credits;
						displayBoardAdd.appendText(finalProfile + "\n");
					}
					else if(state.length() != 0) {
						String finalProfile = tristateadd + comma + name + comma + major + comma + credits + comma + state;
						displayBoardAdd.appendText(finalProfile + "\n");
					}
					else if(international) {
						String finalProfile3 =  internationaladd + comma + name + comma + major + comma + credits + abroad ;
						displayBoardAdd.appendText(finalProfile3 + "\n");
						//System.out.println(finalPayment);
				
					}
				
				}
			}
		}
		
		
		
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
