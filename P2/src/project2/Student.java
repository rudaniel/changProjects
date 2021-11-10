package project2;

import java.text.DecimalFormat;

/**
 * The Student Super class is where we create a student of type Student.
 * There are getter and setter methods for the Student's properties (except class).
 * Two subclass extend student.
 * @author Manav Bali
 * @author Daniel Lopez
 */
public class Student {

	public static final int minFulltimeCredits = 12;
	public static final double discountRate = 0.8;
	public static final int maxFreeCredits = 16;
	public static int UFEE = 3268;
	private Profile profile;
	private int credits;
	private double tuition;
	private double payment;
	private Date date;
	private boolean parttime; 
	//private boolean resident;
	//private boolean nonresident;
	//private boolean international;
	//private String state;
	//private boolean fulltime;
	
	/**
	 * Method extends subclasses and is used to calculate tuition.
	 */
	public void tuitionDue() {
		
	}
	
	/**
	 * Method extends subclasses and is used to print desired output.
	 */
	@Override
	public String toString() {
		DecimalFormat format=new DecimalFormat("#,##0.00");
		return profile+":"+credits+" credit hours"+":"+"tuition due:"+format.format(tuition)+":"+"total payment:"+format.format(payment)+":"+"last payment date: "+(date==null? "--/--/--":date)+":";
		
		//return profile+":"+credits+" credit hours"+":"+"tuition due:"+String.format("%.2f",tuition)+":"+"total payment:"+String.format("%.2f",payment)+"last payment date:"+(date==null? "--/--/--":date)+":";
				//+(resident? "resident":nonresident? international? "international":"":"non-resident"+":"+state);
	}
	
	/**
	 * Creates an instance of student given the correct parameters.
	 * @param Profile profile of student.
	 * @param credits credits of student.
	 * @param tuition amount owed by student.
	 * @param payment payment by student.
	 * @param date date of payment.
	 */
	public Student(Profile profile, int credits, double tuition, double payment, Date date) {
		
		this.profile = profile;
		this.credits = credits;
		this.tuition=tuition;
		this.payment=payment;
		this.date=date;
		//this.resident = resident;
		//this.nonresident = nonresident;
		//this.international = international;
        //this.state = state; 
        //this.fulltime = fulltime;
        //this.parttime = parttime;
	}
	
	/**
	 * Creates an instance of student given the correct parameters.
	 * @param Profile profile of student.
	 * @param credits credits of student.
	 */
	public Student(Profile profile, int credits) {
		this.profile = profile;
		this.credits=credits;
		if(credits<minFulltimeCredits) {
			this.parttime=true;
		}
	}
	
	
	
	/**
	 * Creates a new copy student using another student.
	 * @param student that needs to be copied.
	 */
	public Student(Student student) {
		this.profile=student.profile;
		this.credits=student.credits;
		this.tuition=student.tuition;
		this.payment=student.payment;
		this.date=student.date;
//		this.resident=student.resident;
//		this.nonresident=student.nonresident;
//		this.international=student.international;
//		this.state = student.state;
//		this.fulltime = student.fulltime;
//		this.parttime = student.parttime;
	}

	public Student(Profile profile, int credits, double tuition) { //whats this??
		
		// TODO Auto-generated constructor stub
	}

//	public void setTuition(double d) {
//		this.tuition = d;
//	}
	
	/**
	 * Creates an instance of student given the correct parameters.
	 * @param Profile profile of student.
	 */
	public Student(Profile profile) {
		this.profile=profile;
	}

	
	
	public String isValid() { //comment unknown
		
		return "true";
	}
	
	/**
	 * Updates tuition based on payment. 
	 * @param amount being payed.
	 * @param date 
	 * @return true if paid, false otherwise.
	 */
	public boolean payTuition(double amount, Date date){
		this.date=date;
		this.payment=this.payment+amount;
		this.tuition=this.tuition-amount;
		return true;
	}
	
	

	/**
	 * Grabs the current instance of Student and comapres to other student.
	 * @param student being compared
	 * @return true if equal, false otherwise. 
	 */
	public boolean equals(Student student) {
		return this.profile.equals(student.profile);
	}
	
	/**
	 * Getter method to return payment.
	 * @return payment.
	 */
	public double getPayment() {
		return payment;
	}
	
	/**
	 * Setting method to update total payments.
	 * @param payment being made.
	 */
	public void setPayment(double payment) {
		this.payment = payment;
	}
	
	/**
	 * Getter method to return credits.
	 * @return credits.
	 */
	public int getCredits() {
		return credits;
	}
	
	/**
	 * Setting method to update credits.
	 * @param credits to be updated.
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	/**
	 * Getter method to return tuition.
	 * @return tuition.
	 */
	public double getTuition() {
		return tuition;
	}
	
	/**
	 * Setting method to update tuition.
	 * @param tuition to be updated.
	 */
	public void setTuition(double tuition) {
		this.tuition = tuition;
	}
	
	/**
	 * Getter method to return date.
	 * @return date.
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * Getter method to return Profile.
	 * @return profile.
	 */
	public Profile getProfile() {
		return profile;
	}
	
	/**
	 * Setting method to update credits.
	 * @param date to be updated.
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * Getter method to return parttime.
	 * @return parttime
	 */
	public boolean isParttime() {
		return parttime;
	}

	/**
	 * Setting method to update part time.
	 * @param parttime to be updated.
	 */
	public void setParttime(boolean parttime) {
		this.parttime = parttime;
	}

	/**
	 * Declares a international student as abroad and limits credits if needed.
	 * @param studyAbroad Abroad status.
	 */
	public boolean setStudyAbroad(boolean studyAbroad) {
		return false;
	}
	
	public String giveAid(double amount) {
		return "Not a resident student.";
	}

}
