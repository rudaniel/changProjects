package project2;



public class Student {

	private Profile profile;
	private double credits;
	//private boolean resident;
	//private boolean nonresident;
	//private boolean international;
	//private String state;
	//private boolean fulltime;
	//private boolean parttime;
	private double tuition;
	private double payment;
	private Date date;
	
	//@Override
	public void tuitionDue() {
		
	}
	
	@Override
	public String toString() {
		return profile+":"+credits+
				" credit hours"+":"+"tuition due:"+tuition+":"+"total payment:"+
				payment+"last payment date:"+date+":"+(resident? "resident":nonresident? international? "international":"":"non-resident"+":"+state);
	}
	
	public Student(Profile profile, double credits, double tuition, double payment, Date date) {
		
		this.profile = profile;
		this.credits = credits;
		this.setTuition(tuition);
		this.payment=payment;
		this.date=date;
		//this.resident = resident;
		//this.nonresident = nonresident;
		//this.international = international;
        //this.state = state; 
        //this.fulltime = fulltime;
        //this.parttime = parttime;
	}
	
	
	public Student(Student student) {
		this.profile=student.profile;
		this.credits=student.credits;
		this.setTuition(student.tuition);
		this.payment=student.payment;
		this.date=student.date;
//		this.resident=student.resident;
//		this.nonresident=student.nonresident;
//		this.international=student.international;
//		this.state = student.state;
//		this.fulltime = student.fulltime;
//		this.parttime = student.parttime;
	}

	public Student(Profile profile, double credits, double tuition) {
		
		// TODO Auto-generated constructor stub
	}

	public void setTuition(double d) {
		this.tuition = d;
	}
	
	
	
	

}
