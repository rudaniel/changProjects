package project2;


public class Roster {
	private Student[] roster;
	private int size; //keep track of the number of students in the roster
	
	private int find(Student student) {
		
		int notFound = -1;
		
		for (int i = 0; i <= this.size-1; i++) { //works TESTED
			
			if(roster[i].equals(student) ) {
				return i;
			}
			
		}
		return notFound;
	} 
	private void grow() {
		
		Student[] copy = new Student[roster.length];
		
		for(int i =0; i <= size-1; i++) {
			copy[i] = roster[i];
		}
		
		this.roster = (new Student[roster.length+4]);
		
		for(int i =0; i <= size-1; i++) {
			roster[i] = copy[i];
		}
		
	}
	public boolean add(Student student) { 
		
		int currentSize = this.size;
		
		if (currentSize == 0) {
			this.roster = (new Student[4]);
			roster[0] = student;
			this.size  = 1;
			return true;
		}		
		
		if (currentSize == roster.length && find(student) == -1) {	
			 grow();
		}
		
		if (find(student) == -1) {
			roster[size] = student;
			this.size ++;
			return true;
		}
		
		return false;
	} 
	public boolean remove(Student student) {
		int currentSize = this.size;
		if (currentSize == 0) {
			this.roster = (new Student[4]);
			roster[0] = student;
			this.size  = 1;
			return true;
		}		
		if (currentSize == roster.length && find(student) == -1) {	
			 grow();
		}
		if (find(student) == -1) {
			roster[size] = student;
			this.size ++;
			return true;
		}
		return false;
	}
	
}
