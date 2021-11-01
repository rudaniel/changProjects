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
import project2.Date;
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
	TextField tuition= new TextField();
	
	@FXML
	RadioButton csMajor, itMajor, baMajor, eeMajor, meMajor, major1;
	
	@FXML
	RadioButton Resident, nonResident, tristate, ny, connecticut,internationalButton, abroadButton, residency, s, ts;

	@FXML
	ToggleGroup Major, Status, home1, stateT, Major1;
	
	@FXML 
	Button printing, tuitionDue;
	
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
				else {
					profileText.appendText("Please select residency for the Student!\n");	
				}
			}
			else {
				profileText.appendText("Please select a major.\n");
			}
		}		
		else {
			profileText.appendText("Please enter a name for Student.\n");
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
			else {
				profileText.appendText("Please select a major.\n");
			}
		}		
		else {
			profileText.appendText("Please enter a name for Student.\n");
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
	
	public void studentTuition(ActionEvent e) {
		String name = nameProfile.getText();
		if(!name.isBlank()) {
			major1=(RadioButton) Major.getSelectedToggle();
			if(major1!=null) {
				major= major1.getText();	
				Profile profile= new Profile(name,major);
				Student student= new Student(profile);
				if(obj.calcSingle(student, tuition)) {
					profileText.appendText("Student Tuition Calculated.\n");
				}
				else {
					profileText.appendText("Student is not in the roster.\n");
				}
			}
			else {
				profileText.appendText("Please select a major.\n");
			}
		}		
		else {
			profileText.appendText("Please enter a name for Student.\n");
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
	TextField namePay;
	
	
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
	String name = namePay.getText();
	if(!name.isBlank()) {
		major1=(RadioButton) Major1.getSelectedToggle();
		if(major1!=null) {
			major= major1.getText();	
			Profile profile= new Profile(name,major);
			if(isNumber(payTotal.getText())) {
				double amount=Double.parseDouble(payTotal.getText());
				if(amount<=0) {
					displayBoard.appendText("Invalid amount.\n");
				}
				else {
					LocalDate date1 = paymentDate.getValue();
					Date date;
					if(date1==null) {
						date= new Date();
					}
					else {
						String formatDate = date1.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
						date= new Date(formatDate);
					}
					if(!date.isValid()) {
						displayBoard.appendText("Payment date invalid.\n");
					}
					else {
						Student student= new Student(profile,amount,date);
						obj.payment(student);
						displayBoard.appendText("Payment made.\n");
						
					}
				}
			}
			else {
				displayBoard.appendText("Payment can only be a number.\n");
			}			
		}
		else {
			displayBoard.appendText("Please select a major.\n");
		}
	}
	else {
		displayBoard.appendText("Please enter a name for Student.\n");
	}
	
	
	
	//boolean realNumAid = isNumber(aidPaid);
	//System.out.println("T,"+ namePay + "," +majorPay +","+ amountPaid + "," + formatDate );
	}

public void paymentAid(ActionEvent event) {
	String name = namePay.getText();
	if(!name.isBlank()) {
		major1=(RadioButton) Major1.getSelectedToggle();
		if(major1!=null) {
			major= major1.getText();	
			Profile profile= new Profile(name,major);
			if(isNumber(payAid.getText())) {
				double amount=Double.parseDouble(payAid.getText());
				if(amount<=0) {
					displayBoard.appendText("Invalid amount.\n");
				}
				else {
					Student student= new Student(profile,amount);
					displayBoard.appendText(obj.aid(student)+"\n");
				}
			}
			else {
				displayBoard.appendText("Financial Aid can only be a number.\n");
			}			
		}
		else {
			displayBoard.appendText("Please select a major.\n");
		}
	}
	else {
		displayBoard.appendText("Please enter a name for Student.\n");
	}
	
//	String namePay = getNamePay.getText();
//	String aidPaid = payAid.getText();
//	//boolean realNumAmount = isNumber(amountPaid);
//	boolean realNumAid = isNumber(aidPaid);
//	//LocalDate date = paymentDate.getValue();
//	//String formatDate = date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//	
//	if(namePay.length() != 0 && validName(namePay)) {
//		//if(majorPay.length() != 0) {
//			if(aidPaid.length() != 0 && realNumAid == true && amountPaid.length() == 0) {
//				if(formatDate.length() != 0) {
//					String finalPayment = F + comma + namePay + comma + majorPay + comma + aidPaid + comma + formatDate;
//					//System.out.println(finalPayment);
//					displayBoard.appendText(finalPayment + "\n");
//				}
//			}
//		//}
//	}
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
			return true;
			
			
		} catch(NumberFormatException e) {
			return false;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
