package project2;



public class Students {

	private Profile profile;
	private int credits;
	private boolean resident;
	private boolean nonresident;
	private boolean international;
	private String state;
	private boolean fulltime;
	private boolean parttime;
	
	
	
	public void tuitionDue() {
		
	}
	
	public Students(Profile profile, int credits, boolean resident, boolean nonresident, boolean international, String state, 
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
	
	
	public Students(Students student) {
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
