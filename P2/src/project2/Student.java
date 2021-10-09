package project2;



public class Student {

	protected static final int minFulltimeCredits = 12;
	protected static final double discountRate = 0.8;
	protected final int maxFreeCredits = 16;
	protected final int UFEE = 3268;
	private Profile profile;
	protected int credits;
	protected double tuition;
	protected double payment;
	protected Date date;
	protected boolean parttime;
	//private boolean resident;
	//private boolean nonresident;
	//private boolean international;
	//private String state;
	//private boolean fulltime;
	
	//@Override
	public void tuitionDue() {
		
	}
	
	@Override
	public String toString() {
		return profile+":"+credits+" credit hours"+":"+"tuition due:"+String.format("%.2f",tuition)+":"+"total payment:"+String.format("%.2f",payment)+"last payment date:"+date+":";
				//+(resident? "resident":nonresident? international? "international":"":"non-resident"+":"+state);
	}
	
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
	
	public Student(Profile profile, int credits) {
		this.profile = profile;
		this.credits=credits;
	}
	
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

	public Student(Profile profile, int credits, double tuition) {
		
		// TODO Auto-generated constructor stub
	}

//	public void setTuition(double d) {
//		this.tuition = d;
//	}
	
	public boolean payTuition(double amount){
		if(this.tuition-this.payment-amount>=0) {
		this.date=new Date();
		this.payment=this.payment+amount;
		this.tuition=this.tuition-amount;
		return true;
		}
		return false;
	}
	
	
	//@Override
	public boolean equals(Student student) {
		return this.profile.equals(student.profile);
	}
	
	

}
