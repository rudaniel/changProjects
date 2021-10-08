package project2;



public class Student {

	private Profile profile;
	private int credits;
	private boolean resident;
	private boolean nonresident;
	private boolean international;
	private String state;
	private boolean fulltime;
	private boolean parttime;
	
	
	//@Override
	public void tuitionDue() {
		
	}
	
	@Override
	public String toString() {
		return profile+":"+credits+
				" credit hours"+":"+"tuition due:"+tuition+":"+"total payment:"+
				payment+"last payment date:"+date+":"+(resident? "resident":nonresident? international? "international":"":"non-resident"+":"+state);
	}
	
	public Student(Profile profile, int credits, boolean resident, boolean nonresident, boolean international, String state, 
			        boolean fulltime, boolean parttime ) {
		
		this.profile = profile;
		this.credits = credits;
		this.resident = resident;
		this.nonresident = nonresident;
		this.international = international;
        this.state = state; 
        this.fulltime = fulltime;
        this.parttime = parttime;
	}
	
	
	public Student(Student student) {
		this.profile=student.profile;
		this.credits=student.credits;
		this.resident=student.resident;
		this.nonresident=student.nonresident;
		this.international=student.international;
		this.state = student.state;
		this.fulltime = student.fulltime;
		this.parttime = student.parttime;
	}
	
	
	
	

}
