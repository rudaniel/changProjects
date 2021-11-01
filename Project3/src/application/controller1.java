package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import project2.Date;
import project2.International;
import project2.NonResident;
import project2.Profile;
import project2.Roster;
import project2.RunProject2;
import project2.Student;
import project2.Tristate;
import project2.Resident;

/**
 * The Controller class will be controller the UI and preventing it from crashing.
 * All desired commands for thr user will be coded here.
 * @author Manav Bali
 * @author Daniel Lopez
 */
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
	Button printing, tuitionDue, us, asBt, rsBt;
	
	@FXML
	Label aidbox1, pa1, pd1, statusLbl, chLbl;
	
	@FXML
	HBox aidbox2, pd2,chBox,tdBox,isBox,tsBox;
	
	@FXML
	VBox statusBox;
	
	@FXML
	Pane pa2;
	
	String major = null;
	String status = null;
	String state = null;
	boolean international;
	boolean abroad;
	String r= "Resident";
	String nr= "Non-Resident";
	
	/**
	 * Makes sure that the status buttons work property and wont crash the UI.
	 * @param e the button click.
	 */
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
				us.setVisible(true);
				us.setDisable(false);
			}
			else {
				us.setDisable(true);
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
	
	/**
	 * Makes sure that the fields are filled out and then adds a student to the Roster list.
	 * @param event1 the button click.
	 */
	public void addStudent(ActionEvent event1) {
		String name = nameProfile.getText();
		String credits = creditHourTextField.getText();
		if(!name.isBlank()) {
			major1=(RadioButton) Major.getSelectedToggle();
			if(major1!=null) {
				major= major1.getText();
				residency= (RadioButton) Status.getSelectedToggle();
				if(residency!=null) {
					String res= residency.getText();
					if(res.equals(r)) {
						if(credits==null||credits.isBlank()) {
							profileText.appendText("Enter credits for the Student!\n");
						}
						else {
							disable();
							profileText.appendText("adding Resident\n");
							addResident(name,major, Integer.parseInt(credits));
						}
					}
					else if(res.equals(nr)) {
						s= (RadioButton) home1.getSelectedToggle();
						String tri="Tristate";
						if(s==null) {
							if(credits==null||credits.isBlank()) {
								profileText.appendText("Enter credits for the Student!\n");
							}
							else {
								disable();
								profileText.appendText("adding NonResident\n");
								addNonResident(name,major, Integer.parseInt(credits));
							}
						}
						else if(s.getText().equals(tri)){
							ts= (RadioButton) stateT.getSelectedToggle();
							if(ts!=null) {
								String st="CT";
								String stat= ts.getText();
								if(stat.equals("New York")) {
									st="NY";
								}
								if(credits==null||credits.isBlank()) {
									profileText.appendText("Enter credits for the Student!\n");
								}
								else {
									disable();
									profileText.appendText("adding tri-state\n");
									addTristate(name,major, Integer.parseInt(credits), st);
								}
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
							if(credits==null||credits.isBlank()) {
								profileText.appendText("Enter credits for the Student!\n");
							}
							else {
								disable();
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
	
	/**
	 * Makes sure that the fields are filled out and then removes a student from the Roster list.
	 * @param event1 the button click.
	 */
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
					resetP();
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
	
	/**
	 * Checks if the user inputed a proper name.
	 */
	public boolean nameCheck() {
		String name = nameProfile.getText();
		if(!name.isBlank()) {
			return true;
		}
		profileText.appendText("Enter a name for the Student!\n");
		return false;
	}
	
	/**
	 * Checks if the user inputed a proper major button.
	 */
	public boolean majorCheck() {
		major1=(RadioButton) Major.getSelectedToggle();
		if(major1!=null) {
			return true;
		}
		profileText.appendText("Enter a major for the Student!\n");
		return false;
	}
	
	/**
	 * Checks if the user inputed a proper status button.
	 */
	public boolean residencyCheck() {
		residency= (RadioButton) Status.getSelectedToggle();
		if(residency!=null) {
			return true;
		}
		profileText.appendText("Enter a residency for the Student!\n");
		return false;
	}
	
	/**
	 * Checks if the user inputed a proper credit number.
	 */
	public boolean creditCheck() {
		String credits= creditHourTextField.getText();
		if(!credits.isBlank()) {
			return true;
		}
		profileText.appendText("Enter credits for the Student!\n");
		return false;
	}
	
	/**
	 * Adds the student and displays message for the user.
	 * @param student to be added.
	 */
	public void add(Student student) {
		if(obj.add(student)) {
			profileText.appendText("Student added.\n");
		}
		else {
			profileText.appendText("Student is already in the roster.\n");
		}
	}
	
	/**
	 * Calculates the tuition of the student.
	 * @param e click of button.
	 */
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
	
	/**
	 * Creates and adds a student of type international.
	 * @param name name of student
	 * @param major major of student
	 * @param credits credits of student
	 * @param studyAbroad
	 */
	public void addInternational(String name, String major, int credits, boolean studyAbroad) {
		Profile profile= new Profile(name,major);
		Student student= new International(profile,credits,studyAbroad);
		add(student);
	}
	
	/**
	 * Creates and adds a student of type tristate.
	 * @param name name of student
	 * @param major major of student
	 * @param credits credits of student
	 * @param state
	 */
	public void addTristate(String name, String major, int credits, String state) {			
		Profile profile= new Profile(name,major);
		Student student= new Tristate(profile,credits,state);
		add(student);
	}
	
	/**
	 * Creates and adds a student of type nonresident.
	 * @param name name of student
	 * @param major major of student
	 * @param credits credits of student
	 */
	public void addNonResident(String name, String major, int credits) {
		Profile profile= new Profile(name,major);
		Student student= new NonResident(profile,credits);
		add(student);
	}
	
	/**
	 * Creates and adds a student of type resident.
	 * @param name name of student
	 * @param major major of student
	 * @param credits credits of student
	 */
	public void addResident(String name, String major, int credits) {
		Profile profile= new Profile(name,major);
		Student student= new Resident(profile,credits);
		add(student);
	}
	
	/**
	 * Prints the Roster depending on user input.
	 * @param e click of button
	 */
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
	
	/**
	 * Gets the major the user selects in tab2.
	 * @param e click of button
	 */
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
	
	/**
	 * Handles the payment numbers. Making sure everything that is entered is valid.
	 * @param e click of button
	 */
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
	

	}

/**
 * Handles the payment numbers for financial aid. Making sure everything that is entered is valid.
 * @param event click of button
 */
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
}


/**
 * Makes sure the name thats entered has a first and last name.
 * @param name name of student
 */
public static boolean validName(String name) {
	if (name.contains(" ")) {
		return true;
	} 
	else {
		return false;
	
	}
}

/**
 * Checks if a real number is inputed.
 * @param amountPaid
 */
public static boolean isNumber(String amountPaid) {
		try {
			double number = Double.parseDouble(amountPaid);
			return true;
			
			
		} catch(NumberFormatException e) {
			return false;
		}
		
		
}
	
	
	
/**
 * Updates the fields while the user uses the UI.
 */
	@FXML
	void update() {
		String name = nameProfile.getText();
		if(!name.isBlank()) {
			major1=(RadioButton) Major.getSelectedToggle();
			if(major1!=null) {
				major= major1.getText();	
				Profile profile= new Profile(name,major);	
				International student= new International(profile, abroadButton.isSelected());
				obj.abroadStatus(student);
				profileText.appendText("Status updated.\n");
				
			}
			else {
				profileText.appendText("Please select a major.\n");
			}
		}
		else {
			profileText.appendText("Please enter a name for Student.\n");
		}
	}
	
	/**
	 * Searches for the student in the Roster.
	 * @param ee click of button
	 */
	@FXML
	void search(ActionEvent ee) {
		reset();
		String name = namePay.getText();
		if(!name.isBlank()) {
			major1=(RadioButton) Major1.getSelectedToggle();
			if(major1!=null) {
				major= major1.getText();	
				Profile profile= new Profile(name,major);	
				Student student= obj.search(new Student(profile));
				if(student==null) {
					displayBoard.appendText("Student is not in the roster.\n");
				}
				else {
					pa1.setDisable(false);
					pa2.setDisable(false);
					pd1.setDisable(false);
					pd2.setDisable(false);
					displayBoard.appendText("Search successful.\n");
					Resident test;
					try {
						test= (Resident) student;
						aidbox1.setDisable(false);
						aidbox2.setDisable(false);
					}
					catch(Exception e){
						
					}
				}
			}
			else {
				displayBoard.appendText("Please select a major.\n");
			}
		}
		else {
			displayBoard.appendText("Please enter a name for Student.\n");
		}
	}
	
	String nyS="NY";
	
	/**
	 * Searches for the student that is already in list with status included.
	 * @param ee click of button
	 */
	@FXML
	void searchP(ActionEvent ee) {
	//	resetP();
		String name = nameProfile.getText();
		if(!name.isBlank()) {
			major1=(RadioButton) Major.getSelectedToggle();
			if(major1!=null) {
				major= major1.getText();	
				Profile profile= new Profile(name,major);	
				Student student= obj.search(new Student(profile));
				if(student==null) {
					statusBox.setDisable(false);
					statusLbl.setDisable(false);
					//isBox.setDisable(true);
					//tsBox.setDisable(true);
					chLbl.setDisable(false);
					chBox.setDisable(false);
					asBt.setDisable(false);
					rsBt.setDisable(true);
					tdBox.setDisable(true);
				}
				else {
					chLbl.setDisable(true);
					chBox.setDisable(true);
					statusBox.setDisable(true);
					statusLbl.setDisable(true);
					rsBt.setDisable(false);
					tdBox.setDisable(false);
					tuitionDue.setDisable(false);
					tuition.setDisable(false);
					Student test;
					//NonResident test2;
					try {
						test= (Resident) student;
						Status.selectToggle(Resident);
					}
					catch(Exception e){
						
					}
					try {
						test= (NonResident) student;
						Status.selectToggle(nonResident);
						Tristate test3;
						International test4;
						try {
							test= (Tristate) student;
							test3= (Tristate) student;
							home1.selectToggle(tristate);
							String temp= test3.getState();
							if(temp.equals(nyS)) {
								stateT.selectToggle(ny);
							}
							else {
								stateT.selectToggle(connecticut);
							}
						}				
						catch(Exception e){
							
						}
						try {
							nonResident.setDisable(false);
							internationalButton.setDisable(false);
							abroadButton.setDisable(false);
							us.setDisable(false);
							test= (International) student;
							test4= (International) student;
							home1.selectToggle(internationalButton);
							abroadButton.setSelected(test4.getStatus());
						}				
						catch(Exception e){
							
						}
						tuition.setText(test.getTuition()+"");
						creditHourTextField.setText(test.getCredits()+"");
					}
					catch(Exception e){
						
					}
					
				}
				profileText.appendText("Search successful.\n");
			}
			else {
				profileText.appendText("Please select a major.\n");
			}
		}
		else {
			profileText.appendText("Please enter a name for Student.\n");
		}
	}
	
	/**
	 * Resets the UI to start researching.
	 */
	@FXML
	void reset(){
		aidbox1.setDisable(true);
		aidbox2.setDisable(true);
		pa1.setDisable(true);
		pa2.setDisable(true);
		pd1.setDisable(true);
		pd2.setDisable(true);
	}
	
	/**
	 * Resets the UI to start researching.
	 */
	@FXML
	void resetP(){
		tristate.setDisable(true);
		ny.setDisable(true);
		connecticut.setDisable(true);
		internationalButton.setDisable(true);
		abroadButton.setDisable(true);
		Status.selectToggle(null);
		home1.selectToggle(null);
		stateT.selectToggle(null);
		abroadButton.setSelected(false);
		statusBox.setDisable(true);
		statusLbl.setDisable(true);
		chLbl.setDisable(true);
		chBox.setDisable(true);
		asBt.setDisable(true);
		rsBt.setDisable(true);
		tdBox.setDisable(true);
		tuitionDue.setDisable(true);
		tuition.setDisable(true);
		tuition.setText(null);
		creditHourTextField.setText(null);
		us.setDisable(true);
	}
	
	public void disable(){
		tristate.setDisable(true);
		ny.setDisable(true);
		connecticut.setDisable(true);
		internationalButton.setDisable(true);
		abroadButton.setDisable(true);
		//Status.selectToggle(null);
		//home1.selectToggle(null);
		//stateT.selectToggle(null);
		//abroadButton.setSelected(false);
		statusBox.setDisable(true);
		statusLbl.setDisable(true);
		chLbl.setDisable(true);
		chBox.setDisable(true);
		asBt.setDisable(true);
		rsBt.setDisable(true);
		tdBox.setDisable(true);
		tuitionDue.setDisable(true);
		tuition.setDisable(true);
		//tuition.setText(null);
		//creditHourTextField.setText(null);
		//us.setDisable(true);
		asBt.setDisable(true);
		rsBt.setDisable(false);
		tuitionDue.setDisable(false);
		tdBox.setDisable(false);
	}
	
	/**
	 * Calculates Tuition.
	 */
	@FXML
	void calcAll() {
		obj.printC();
		printBox.appendText("Calculated Tuitions.\n");
	}
	
	
}
