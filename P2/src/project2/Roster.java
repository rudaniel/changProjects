package project2;

/**
*The Roster class is what stores our students and handles features.
*The Roster class is able to add new students, remove students and can calculate tuition/payments.
*@author Daniel Lopez, Manav Bali
*/

public class Roster {
	private Student[] roster;
	private int size; //keep track of the number of students in the roster
	
	/**
	 * Looks through the roster[] array to see if the student is in the collection.
	 * @param student that is being searched for.
	 * @return index if found, -1 if not in collection.
	 */
	private int find(Student student) {
		
		int notFound = -1;
		
		for (int i = 0; i <= this.size-1; i++) { //works TESTED
			
			if(roster[i].equals(student) ) {
				return i;
			}
			
		}
		return notFound;
	} 
	
	/**
	 * Increases the roster[] array by 4 without losing any students.
	 */
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
	
	/**
	 * Checks the current roster size and adds the student to the roster[] array.
	 * If the size is too small, the array size gets increased.
	 * If the size is 0 the array roster[] is initialized.
	 * @param student that needs to be added.
	 * @return true if student is added, false otherwise.
	 */
	public boolean add(Student student) { 
		
		int currentSize = this.size;
		
		int minCredit = 3;
		int maxCredit = 24;
		
		if(student.getCredits() < minCredit && student.getCredits() > 0) {
			System.out.println("Minimum credit hours is 3.");
			return false;
		}
		if(student.getCredits() > maxCredit) {
			System.out.println("Credit hours exceed the maximum 24.");
			return false;
		}
		if(student.getCredits() < 0) {
			System.out.println("Credit hours cannot be negative.");
			return false;
		}
		if (currentSize == 0) {
			this.roster = (new Student[4]);
			roster[0] = student;
			this.size  = 1;
			return true;
		}		
		if (find(student) != -1) {
			return false;			
		}
		if (currentSize == roster.length && find(student) == -1) {	
			 grow();
		}
		roster[size] = student;
		this.size ++;
		return true;
	} 
	
	/**
	 * Checks if the student is in the roster. 
	 * Removes that student and moves students after the removed back a spot in the array.
	 * @param student that is being removed.
	 * @return true if student is removed, false otherwise.
	 */
	public boolean remove(Student student) {
	    int index = find(student);
	    int notfound = -1;
		
		if (index == notfound) {
			//System.out.println("Student is already in the roster.");
			return false;
		}
		for(int i =index; i <=  size-1; i++) {
			if(i != size-1) {
				this.roster[i] =  this.roster[i+1];	
			}
			if(i == size-1) {
				this.roster[i] = null;
			}
		}
		//System.out.println("Student removed from the roster.");
		this.size --;
		return true; 
	}
	
	/**
	 * Checks if collection is empty and if not prints the entire albums[] array.
	 */
	public void print() {
	
		if(this.size==0) {
			System.out.println("Student roster is empty!");
			return;
		}
		System.out.println("* list of students in the roster **");
		
		for(int counter=0; counter<roster.length; counter++) {
			if(roster[counter]!=null) {
			System.out.println(roster[counter]);
			}
		}
		System.out.println("* end of roster **");
	
	}
	
	

	/**
	 * Checks if collection is empty and if not prints the entire albums[] array with tuition amount.
	 */
	public void printC() {
		
		if(this.size==0) {
			System.out.println("Student roster is empty!");
			return;
		}
		System.out.println("* list of students in the roster **");
		
		for(int counter=0; counter<roster.length; counter++) {
			
			
			if(roster[counter]!=null) {
			roster[counter].tuitionDue();
			System.out.println(roster[counter]);
			}
		}
		System.out.println("*End of list");
		
	}
	

	/**
	 * Sorts roster[] by Name and prints them.
	 */
   public void printN() {
		
		if(this.size==0) {
			System.out.println("Student roster is empty!");
			return;
		}
		System.out.println("* list of students ordered by name **");
		
		Student[] sortedNames = new Student[roster.length];
		for(int counter=0; counter<roster.length;counter++) {
			sortedNames[counter]=roster[counter];
		}
		
		for(int counter=0; counter<sortedNames.length;counter++) {
			int minIndex=counter;
			for(int secCounter=minIndex+1; secCounter<sortedNames.length; secCounter++) {
				if(sortedNames[secCounter]!=null && sortedNames[secCounter].getProfile().getName().charAt(0)<sortedNames[minIndex].getProfile().getName().charAt(0)) {
					minIndex= secCounter;
				}
			}
			Student temp= sortedNames[minIndex];
			sortedNames[minIndex]=sortedNames[counter];
			sortedNames[counter]=temp;
		}
		
		
		System.out.println("*End of list");
		
	}

   /**
	 * Sorts roster[] by Payment Date and prints them.
	 */
	public void printT() {
		
		if(this.size==0) {
			System.out.println("Student roster is empty!");
			return;
		}
		System.out.println("* list of students made payments ordered by payment date **");
		
		
		Student[] sortedDate= new Student[roster.length];
		
		for(int counter=0; counter<roster.length;counter++) {
			if(roster[counter].getPayment() > 0) {//will only had students who had made payments to the array
				for(int i = 0; i <roster.length; i++ ){
					sortedDate[counter]=roster[counter]; //Adds them in the right order, no nulls
				}
				
			}
			
		
		}
		for(int counter=0; counter<sortedDate.length;counter++) {
			int minIndex=counter;
			for(int secCounter=minIndex+1; secCounter<sortedDate.length; secCounter++) {
				if(sortedDate[secCounter]!=null&&sortedDate[secCounter].getDate().compareTo(sortedDate[minIndex].getDate())==-1) {
					minIndex= secCounter;
				}	
			}
			Student temp= sortedDate[minIndex];
			sortedDate[minIndex]=sortedDate[counter];
			sortedDate[counter]=temp;
		}
		
		System.out.println("*End of list");
	}
	
	
	
	public static void main (String arg []) {
		
		
		String name = "John Doe";
		Major major = Major.EE;
		Profile p = new Profile(name , major);
		Student student1 = new Resident(p,18);
		
		String name2 = "Jane Doe";
		Major major2 = Major.CS;
		Profile p2 = new Profile(name2 , major2);
		Student student2 = new Resident(p2, 3);
		
		String name3 = "John Doe";
		Major major3 = Major.BA;
		Profile p3 = new Profile(name3 , major3);
		Student student3 = new Resident (p3,24);

		String name4 = "Rob Harrison";
		Major major4 = Major.EE;
		Profile p4 = new Profile(name4 , major4);
		Student student4 = new NonResident (p4,12);
		
		String name5 = "Rob Harrison";
		Major major5 = Major.IT;
		Profile p5 = new Profile(name5 , major5);
		Student student5 = new NonResident (p5,12);
		
		
		String name6 = "John Doe";
		Major major6 = Major.it;
		String state6 = "NY";
		Profile p6 = new Profile(name6 , major6);
		Student student6 = new Tristate(p6,18, state6);
		
		String name7 = "Rob Harrison";
		Major major7 = Major.BA;
		String state7 = "ny";
		Profile p7 = new Profile(name7 , major7);
		Student student7 = new Tristate(p7, 9, state7);
		
		String name8 = "Rob Harrison";
		Major major8 = Major.me;
		String state8 = "ct";
		Profile p8 = new Profile(name8 , major8);
		Student student8 = new Tristate(p8,6, state8);
	
		String name9 = "Mary Johnson";
		Major major9 = Major.it;
		String state9 = "CT";
		Profile p9 = new Profile(name9 , major9);
		Student student9 = new Tristate(p9,15, state9);
		
		String name00 = "Barry Young";
		Major major00 = Major.it;
		String state00 = "ny";
		Profile p00 = new Profile(name00 , major00);
		Student student00 = new Tristate(p00,14, state00);
		
		Roster r = new Roster();
		
		r.add(student1);
		r.add(student1);
		r.add(student2);
		r.add(student3);
		r.add(student4);
		r.add(student5);
		r.add(student6);
		r.add(student7);
		r.add(student8);
		r.add(student9);
		r.add(student00);
		
		//r.print();
		//r.printT();
		
	}
	
	
	
}
