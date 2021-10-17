package project2;

import java.util.InputMismatchException;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 * Gets what the user inputs and calls the correct methods based on the commands.
 * @author Manav Bali
 * @author Daniel Lopez
 */
public class TuitionManager {
	Roster obj=new Roster();
	
	/**
	 * The method that is in charge of dealing with user input and displaying error messages.
	 * @param input the input line of user
	 * @return true to keep program running, false if user entered "Q" to stop program
	 */
	public boolean caller(String input){
		if(input.equals("Q"))
			return false;
		else if(input.length()==0) {
		}
		else if(input.charAt(0)=='A'&&input.length()>=2) {
			if(input.charAt(1)=='R')
				addResident(input);
			if(input.charAt(1)=='N')
				addNonResident(input);
			if(input.charAt(1)=='T')
				addTrisate(input);
			if(input.charAt(1)=='I')
				addInternational(input);
		}
		else if(input.charAt(0)=='R'&&input.length()>1&&input.charAt(1)==',')
			removeStudent(input);
		else if(input.charAt(0)=='C'&&input.length()==1)
			calculateTuition();
		else if(input.charAt(0)=='T'&&input.length()>1&&input.charAt(1)==',')
			payTuition(input);
		else if(input.charAt(0)=='S'&&input.length()>1&&input.charAt(1)==',')
			abroadStatus(input);
		else if(input.charAt(0)=='F'&&input.length()>1&&input.charAt(1)==',')
			setFinancialAid(input);
		else if(input.charAt(0)=='P') {
			if(input.length()==1)
				obj.print();
			else if(input.charAt(1)=='N'&&input.length()==2)
				obj.printN();
			else if(input.charAt(1)=='T'&&input.length()==2)
				obj.printT();
			else
				System.out.println("Command '"+input+"' not supported!");
		}	
		else 
			System.out.println("Command '"+input+"' not supported!");
		return true;
	}
	
	/**
	 * The method that handles calling add International function
	 * @param input The input line from user
	 */
	public void addInternational(String input) {
		try {
			StringTokenizer studentMaker= new StringTokenizer(input.substring(2),",");
			StringTokenizer studentMakerCredits= new StringTokenizer(input.substring(2),",");
			int tokens=studentMaker.countTokens();
			int minTokens=2;
			dataCheck(minTokens,tokens);
			String name=studentMaker.nextToken();
			String major=studentMaker.nextToken();
			majorCheck(major);
			intlCreditsCheck(studentMakerCredits);
			int credits=Integer.parseInt(studentMaker.nextToken());
			minTokens=4;
			dataCheck(minTokens,tokens);
			boolean studyAbroad=Boolean.parseBoolean(studentMaker.nextToken());
			Profile profile= new Profile(name,major);
			Student student= new International(profile,credits,studyAbroad);
			if(obj.add(student)) {
			System.out.println("Student added.");
			}
			else {
				System.out.println("Student is already in the roster.");
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	/**
	 * Handles bad commands.
	 * @param data input The input line from user
	 */
	public void intlCreditsCheck(StringTokenizer data) {
		int minTokens=3;
		int zero =0;
		int minCredit = 3;
		int fullCredit = 12;
		int maxCredit = 24;
		if(data.countTokens()<minTokens) {
			throw new NoSuchElementException("Credit hours missing."); 
		}
		data.nextToken();
		data.nextToken();
		try {
			int credits=Integer.parseInt(data.nextToken());
			if(credits < zero) {
				throw new InputMismatchException("Credit hours cannot be negative.");
			}
			if(credits < minCredit) {
				throw new InputMismatchException("Minimum credit hours is 3.");
			}
			if(credits < fullCredit) {
				throw new InputMismatchException("International students must enroll at least 12 credits.");
			}
			if(credits > maxCredit) {
				throw new InputMismatchException("Credit hours exceed the maximum 24.");
			}
		}
		catch(NumberFormatException e) {
			throw new NumberFormatException("Invalid credit hours.");
		}

		
	}
	
	/**
	 * The method that handles calling add Tristate function
	 * @param input The input line from user
	 */
	public void addTrisate(String input) {
		try {
			StringTokenizer studentMaker= new StringTokenizer(input.substring(2),",");
			StringTokenizer studentMakerCredits= new StringTokenizer(input.substring(2),",");
			int tokens=studentMaker.countTokens();
			int minTokens=2;
			dataCheck(minTokens,tokens);
			String name=studentMaker.nextToken();
			String major=studentMaker.nextToken();
			majorCheck(major);
			creditsCheck(studentMakerCredits);
			int credits=Integer.parseInt(studentMaker.nextToken());
			minTokens=4;
			dataCheck(minTokens,tokens);
			String state=studentMaker.nextToken();
			stateCheck(state);
			Profile profile= new Profile(name,major);
			Student student= new Tristate(profile,credits,state);
			if(obj.add(student)) {
			System.out.println("Student added.");
			}
			else {
				System.out.println("Student is already in the roster.");
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	/**
	 * The method that handles calling add NonResident function
	 * @param input The input line from user
	 */
	public void addNonResident(String input) {
		try {
			StringTokenizer studentMaker= new StringTokenizer(input.substring(2),",");
			StringTokenizer studentMakerCredits= new StringTokenizer(input.substring(2),",");
			int tokens=studentMaker.countTokens();
			int minTokens=2;
			dataCheck(minTokens,tokens);
			String name=studentMaker.nextToken();
			String major=studentMaker.nextToken();
			majorCheck(major);
			creditsCheck(studentMakerCredits);
			int credits=Integer.parseInt(studentMaker.nextToken());
			Profile profile= new Profile(name,major);
			Student student= new NonResident(profile,credits);
			if(obj.add(student)) {
			System.out.println("Student added.");
			}
			else {
				System.out.println("Student is already in the roster.");
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	/**
	 * The method that handles calling add Resident function
	 * @param input The input line from user
	 */
	public void addResident(String input) {
		try {
			StringTokenizer studentMaker= new StringTokenizer(input.substring(2),",");
			StringTokenizer studentMakerCredits= new StringTokenizer(input.substring(2),",");
			int tokens=studentMaker.countTokens();
			int minTokens=2;
			dataCheck(minTokens,tokens);
			String name=studentMaker.nextToken();
			String major=studentMaker.nextToken();
			majorCheck(major);
			creditsCheck(studentMakerCredits);
			int credits=Integer.parseInt(studentMaker.nextToken());
			Profile profile= new Profile(name,major);
			Student student= new Resident(profile,credits);
			if(obj.add(student)) {
			System.out.println("Student added.");
			}
			else {
				System.out.println("Student is already in the roster.");
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * The method that handles calling financial aid methods.
	 * @param input The input line from user
	 */
	public void setFinancialAid(String input) {
		try {
			StringTokenizer studentMaker= new StringTokenizer(input.substring(2),",");
			StringTokenizer temp= new StringTokenizer(input.substring(2),",");
			aidCheck(temp);
			String name=studentMaker.nextToken();
			String major=studentMaker.nextToken();
			Double amount=Double.parseDouble(studentMaker.nextToken());
			Profile profile= new Profile(name,major);
			Student student= new Student(profile,amount);
			System.out.println(obj.aid(student));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * The method that handles calling abroad status methods.
	 * @param input The input line from user
	 */
	public void abroadStatus(String input) {
			StringTokenizer studentMaker= new StringTokenizer(input.substring(2),",");
			String name=studentMaker.nextToken();
			String major=studentMaker.nextToken();
			boolean status=Boolean.parseBoolean(studentMaker.nextToken());
			Profile profile= new Profile(name,major);
			International student= new International(profile,status);
			if(obj.abroadStatus(student))
				System.out.println("Tuition updated.");
			else
				System.out.println("Couldn't find the international student.");
	}

	/**
	 * The method that handles calling tuition methods.
	 * @param input The input line from user
	 */
	public void payTuition(String input) {
		try {
			StringTokenizer studentMaker= new StringTokenizer(input.substring(2),",");
			int tokens=studentMaker.countTokens();
			payCheck(tokens);
			String name=studentMaker.nextToken();
			String major=studentMaker.nextToken();
			majorCheck(major);
			double amount=Double.parseDouble(studentMaker.nextToken());
			if(amount<=0) {
				System.out.println("Invalid amount.");
				return;
			}
			Date date= new Date(studentMaker.nextToken());
			if(!date.isValid()) {
				System.out.println("Payment date invalid.");
				return;
			}
			Profile profile= new Profile(name,major);
			Student student= new Student(profile,amount,date);
			if(obj.payment(student))
				System.out.println("Payment applied.");
			else
				System.out.println("Amount is greater than amount due.");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Calculates tuition of all students in roster.
	 */
	public void calculateTuition() {
		obj.printC();
		System.out.println("Calculation completed.");
		
	}
	
	/**
	 * Removes student from roster.
	 * @param input The input line from user
	 */
	public void removeStudent(String input) {
		try {
			StringTokenizer studentMaker= new StringTokenizer(input.substring(2),",");
			int tokens=studentMaker.countTokens();
			int minTokens=2;
			dataCheck(minTokens,tokens);
			String name=studentMaker.nextToken();
			String major=studentMaker.nextToken();
			majorCheck(major);
			Profile profile= new Profile(name,major);
			Student student= new Student(profile);
			if(obj.remove(student)) {
			System.out.println("Student removed from the roster.");
			}
			else {
				System.out.println("Student is not in the roster.");
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	/**
	 * Checks if payment date is included.
	 * @param amount minimum number of tokens allowed.
	 * @param tokens number of tokens in tokenizer.
	 */
	public void dataCheck(int amount,int tokens) throws NoSuchElementException{
		if(amount>tokens) {
			throw new NoSuchElementException("Missing data in command line."); 
		}
	}
	
	/**
	 * Checks if payment amount is included.
	 * @param tokens number of tokens in tokenizer.
	 */
	public void payCheck(int tokens) throws NoSuchElementException{
		int amount=3;
		if(amount>tokens) {
			throw new NoSuchElementException("Payment amount missing."); 
		}
	}
	/**
	 * Checks if credits is included.
	 * @param data The input line from user in tokenizer.
	 * @throws Exception exception thrown based on error.
	 */
	public void creditsCheck(StringTokenizer data) throws Exception{
		int minTokens=3;
		if(data.countTokens()<minTokens) {
			throw new NoSuchElementException("Credit hours missing."); 
		}
		data.nextToken();
		data.nextToken();
		try {
			int credits=Integer.parseInt(data.nextToken());
			if(credits<0) {
				throw new InputMismatchException("Credit hours cannot be negative.");
			}
			if(credits<3) {
				throw new InputMismatchException("Minimum credit hours is 3.");
			}
			if(credits>24) {
				throw new InputMismatchException("Credit hours exceed the maximum 24.");
			}
		}
		catch(NumberFormatException e) {
			throw new NumberFormatException("Invalid credit hours.");
		}

	}
	/**
	 * Checks if aid amount is included.
	 * @param data The input line from user in tokenizer.
	 * @throws Exception exception thrown based on error.
	 */
	public void aidCheck(StringTokenizer data) throws Exception{
		int minTokens=3;
		if(data.countTokens()<minTokens) {
			throw new NoSuchElementException("Missing the amount."); 
		}
		data.nextToken();
		data.nextToken();
		double aid= Double.parseDouble(data.nextToken());
		if(aid<0||aid>10000) {
			throw new InputMismatchException("Invalid amount.");
		}
	}
	
	/**
	 * Checks if major is included.
	 * @param data The input line from user;
	 * @throws IllegalArgumentException exception thrown based on error.
	 */
	public void majorCheck(String data) throws IllegalArgumentException{
		try{
			Major.valueOf(data.toUpperCase());
		}
		catch(IllegalArgumentException e){
			throw new IllegalArgumentException("'"+data+"' is not a valid major."); 
		}
	}
		
	/**
	 * Checks if state is included.
	 * @param state The input line from user
	 */
	public void stateCheck(String state) {
		try{
			Tristates.valueOf(state.toUpperCase());
		}
		catch(IllegalArgumentException e){
			throw new IllegalArgumentException("Not part of the tri-state area."); 
		}
		
	}
	
	
	/**
	 * The method that will run the CollectionManger class.
	 */
	public void run() {
		System.out.println("Tuition Manager starts running.");
		boolean running=true;
		Scanner reader=new Scanner(System.in);
		String input;
		while(running) {
			input=reader.nextLine();
			running=caller(input);
		}
		reader.close();
		System.out.println("Tuition Manager terminated.");
	}
}
