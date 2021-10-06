package project2;

import project.Album;

public class Roster {
	private Student[] roster;
	private int size; //keep track of the number of students in the roster
	
	private int find(Student student) {
		
		int notFound = -1;
		
		for (int i = 0; i <= this.size-1; i++) { //works TESTED
			
			if(roster[i].major == student.major && roster[i].name == student.name ) {
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
		
	} 
	public boolean remove(Student student) {
		
	}
	
}
