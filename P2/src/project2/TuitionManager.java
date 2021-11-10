package project2;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TuitionManager {
	Roster obj=new Roster();
	public boolean caller(String input){
		if(input.equals("Q")) {
			return false;
		}
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
		else if(input.charAt(0)=='R'&&input.length()>1&&input.charAt(1)==',') {
			removeStudent(input);
		}
		else if(input.charAt(0)=='C'&&input.length()==1) {
			calculateTuition();
		}
		else if(input.charAt(0)=='T'&&input.length()>1&&input.charAt(1)==',') {
			payTuition(input);
		}
		else if(input.charAt(0)=='S'&&input.length()>1&&input.charAt(1)==',') {
			abroadStatus(input);
		}
		else if(input.charAt(0)=='F'&&input.length()>1&&input.charAt(1)==',') {
			setFinancialAid(input);
		}
		else if(input.charAt(0)=='P') {
			if(input.length()==1) {
				obj.print();
			}
			else if(input.charAt(1)=='N'&&input.length()==2) {
				obj.printN();
			}
			else if(input.charAt(1)=='T'&&input.length()==2) {
				obj.printT();
			}
			else {
				System.out.println("Command '"+input+"' not supported!");
			}
		}
	
		
		else {
			System.out.println("Command '"+input+"' not supported!");
		}
		return true;
	}

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
	
	public void intlCreditsCheck(StringTokenizer data) {
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
			if(credits<12) {
				throw new InputMismatchException("International students must enroll at least 12 credits.");
			}
			if(credits>24) {
				throw new InputMismatchException("Credit hours exceed the maximum 24.");
			}
		}
		catch(NumberFormatException e) {
			throw new NumberFormatException("Invalid credit hours.");
		}

		
	}

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
	public void setFinancialAid(String input) {
		try {
			StringTokenizer studentMaker= new StringTokenizer(input.substring(2),",");
			StringTokenizer temp= new StringTokenizer(input.substring(2),",");
			aidCheck(temp);
			String name=studentMaker.nextToken();
			String major=studentMaker.nextToken();
			Double amount=Double.parseDouble(studentMaker.nextToken());
			Profile profile= new Profile(name,major);
			Student student= new Student(profile);
			System.out.println(obj.aid(student, amount));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void abroadStatus(String input) {
			StringTokenizer studentMaker= new StringTokenizer(input.substring(2),",");
			String name=studentMaker.nextToken();
			String major=studentMaker.nextToken();
			boolean status=Boolean.parseBoolean(studentMaker.nextToken());
			Profile profile= new Profile(name,major);
			Student student= new Student(profile);
			if(obj.abroadStatus(student,status))
				System.out.println("Tuition updated.");
			else
				System.out.println("Couldn't find the international student.");
	}

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
			Student student= new Student(profile);
			if(obj.payment(student,amount,date))
				System.out.println("Payment applied.");
			else
				System.out.println("Amount is greater than amount due.");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void calculateTuition() {
		obj.printC();
		System.out.println("Calculation completed.");
		
	}

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
	
	public void dataCheck(int amount,int tokens) throws NoSuchElementException{
		if(amount>tokens) {
			throw new NoSuchElementException("Missing data in command line."); 
		}
	}
	
	public void payCheck(int tokens) throws NoSuchElementException{
		int amount=3;
		if(amount>tokens) {
			throw new NoSuchElementException("Payment amount missing."); 
		}
	}
	
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
	
	public void majorCheck(String data) throws IllegalArgumentException{
		try{
			Major.valueOf(data.toUpperCase());
		}
		catch(IllegalArgumentException e){
			throw new IllegalArgumentException("'"+data+"' is not a valid major."); 
		}
	}
		
	public void stateCheck(String state) {
		try{
			Tristates.valueOf(state.toUpperCase());
		}
		catch(IllegalArgumentException e){
			throw new IllegalArgumentException("Not part of the tri-state area."); 
		}
		
	}
	
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
