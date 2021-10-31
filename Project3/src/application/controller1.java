package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import project2.International;
import project2.NonResident;
import project2.Profile;
import project2.Roster;
import project2.Student;
import project2.Tristate;
import project2.Resident;

public class controller1 {
	Roster obj=new Roster();
	String comma = ",";
	String T = "T";
	String F = "F";

	@FXML
	TextField nameProfile = new TextField();
	
	@FXML
	TextField creditHourTextField = new TextField();
	
	@FXML
	RadioButton csMajor, itMajor, baMajor, eeMajor, meMajor, major1;
	
	@FXML
	RadioButton Resident, nonResident, tristate, ny, connecticut,internationalButton, abroadButton, residency, s, ts;

	@FXML
	ToggleGroup Major, Status, home1, stateT;
	
	@FXML 
	Button printing;
	
	String major = null;
	String status = null;
	String state = null;
	boolean international;
	boolean abroad;
	String r= "Resident";
	String nr= "Non-Resident";
	public void getStatus(ActionEvent e) {
		residency= (RadioButton) Status.getSelectedToggle();
		String res= residency.getText();
		if (res.equals(r)) {
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
		if (res.equals(nr)){			
			
			tristate.setDisable(false);
			internationalButton.setDisable(false);
			if(tristate.isSelected()) {
				ny.setDisable(false);
				connecticut.setDisable(false);
			}
			else {
				ny.setDisable(true);
				connecticut.setDisable(true);
				ny.setSelected(false);
				connecticut.setSelected(false);
			}
			
			if(internationalButton.isSelected()) {
				abroadButton.setDisable(false);
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
		if(!name.isBlank()) {
			major1=(RadioButton) Major.getSelectedToggle();
			if(major1!=null) {
				major= major1.getText();
				residency= (RadioButton) Status.getSelectedToggle();
				if(residency!=null) {
					if(credits.isBlank()) {
						profileText.appendText("Enter credits for the Student!\n");
					}
					else {
						String res= residency.getText();
						if(res.equals(r)) {
							profileText.appendText("adding Resident\n");
							addResident(name,major, Integer.parseInt(credits));
						}
						else if(res.equals(nr)) {
							s= (RadioButton) home1.getSelectedToggle();
							String tri="Tristate";
							if(s==null) {
								profileText.appendText("adding NonResident\n");
								addNonResident(name,major, Integer.parseInt(credits));
							}
							else if(s.getText().equals(tri)){
								ts= (RadioButton) stateT.getSelectedToggle();
								if(ts!=null) {
									String st="CT";
									String stat= ts.getText();
									if(stat.equals("New York")) {
										st="NY";
									}
									profileText.appendText("adding tri-state\n");
									addTristate(name,major, Integer.parseInt(credits), st);
								}
								else {
									profileText.appendText("Enter a state for the Student!\n");	
								}
							}
							else {
								boolean study=false;
								if(abroadButton.isSelected()) {
									study=true;
								}
								profileText.appendText("adding international\n");
								addInternational(name,major, Integer.parseInt(credits), study);
							}
						}
					}
				}
			}
		}
	}
	
	public void removeStudent(ActionEvent event1) {
		String name = nameProfile.getText();
		if(!name.isBlank()) {
			major1=(RadioButton) Major.getSelectedToggle();
			if(major1!=null) {
				major= major1.getText();	
				Profile profile= new Profile(name,major);
				Student student= new Student(profile);
				if(obj.remove(student)) {
					profileText.appendText("Student removed from the roster.\n");
				}
				else {
					profileText.appendText("Student is not in the roster.\n");
				}
			}
		}
	}
	
	public boolean nameCheck() {
		String name = nameProfile.getText();
		if(!name.isBlank()) {
			return true;
		}
		profileText.appendText("Enter a name for the Student!\n");
		return false;
	}
	
	public boolean majorCheck() {
		major1=(RadioButton) Major.getSelectedToggle();
		if(major1!=null) {
			return true;
		}
		profileText.appendText("Enter a major for the Student!\n");
		return false;
	}
	
	public boolean residencyCheck() {
		residency= (RadioButton) Status.getSelectedToggle();
		if(residency!=null) {
			return true;
		}
		profileText.appendText("Enter a residency for the Student!\n");
		return false;
	}
	
	public boolean creditCheck() {
		String credits= creditHourTextField.getText();
		if(!credits.isBlank()) {
			return true;
		}
		profileText.appendText("Enter credits for the Student!\n");
		return false;
	}
	
	public void add(Student student) {
		if(obj.add(student)) {
			profileText.appendText("Student added.\n");
		}
		else {
			profileText.appendText("Student is already in the roster.\n");
		}
	}
	
	public void addInternational(String name, String major, int credits, boolean studyAbroad) {
		Profile profile= new Profile(name,major);
		Student student= new International(profile,credits,studyAbroad);
		add(student);
	}
	
	public void addTristate(String name, String major, int credits, String state) {			
		Profile profile= new Profile(name,major);
		Student student= new Tristate(profile,credits,state);
		add(student);
	}
	
	public void addNonResident(String name, String major, int credits) {
		Profile profile= new Profile(name,major);
		Student student= new NonResident(profile,credits);
		add(student);
	}
	
	public void addResident(String name, String major, int credits) {
		Profile profile= new Profile(name,major);
		Student student= new Resident(profile,credits);
		add(student);
	}
	
	public void printStudents(ActionEvent e) {
		printing=(Button)e.getSource();
		if(printing.getText().equals("Print")) {
			obj.print(printBox);
		}
		else if(printing.getText().equals("Print by name")) {
			obj.printN(printBox);
		}
		else if(printing.getText().equals("Print by time")) {
			obj.printT(printBox);
		}
	}
	
	
	@FXML
	TextField getNamePay;
	
	
	@FXML
	RadioButton csMajorPay, itMajorPay, baMajorPay, eeMajorPay, meMajorPay;
	
	@FXML
	TextArea displayBoard, profileText, printBox;
	
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
		//if(majorPay.length() != 0) {
			if(aidPaid.length() != 0 && realNumAid == true && amountPaid.length() == 0) {
				if(formatDate.length() != 0) {
					String finalPayment = F + comma + namePay + comma + majorPay + comma + aidPaid + comma + formatDate;
					//System.out.println(finalPayment);
					displayBoard.appendText(finalPayment + "\n");
				}
			}
		//}
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
