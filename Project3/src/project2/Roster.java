package project2;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
	public void print(TextArea p) {
	
		if(this.size==0) {
			p.appendText("Student roster is empty!\n");
			return;
		}
		p.appendText("* list of students in the roster **\n");
		
		for(int counter=0; counter<roster.length; counter++) {
			if(roster[counter]!=null) {
				p.appendText(roster[counter].toString()+"\n");
			}
		}
		p.appendText("* end of roster **\n");
	
	}
	
	

	/**
	 * Checks if collection is empty and if not prints the entire albums[] array with tuition amount.
	 */
	public void printC() { 
		for(int counter=0; counter<roster.length; counter++) {
			if(roster[counter]!=null&&roster[counter].getTuition()==0&&roster[counter].getPayment()==0) {
			roster[counter].tuitionDue();
			}
		}
	}
	
	public boolean calcSingle(Student student, TextField f) {
		int index = find(student);
	    int notfound = -1;
		if (index == notfound) {
			//System.out.println("Student is already in the roster.");
			return false;
		}
		roster[index].tuitionDue();
		f.setText(roster[index].getTuition()+"");
		return true; 
	}

	/**
	 * Sorts roster[] by Name and prints them.
	 */
   public void printN(TextArea p) {
		
		if(this.size==0) {
			p.appendText("Student roster is empty!\n");
			return;
		}	
		for(int counter=0; counter<roster.length;counter++) {
			int minIndex=counter;
			for(int secCounter=minIndex+1; secCounter<roster.length; secCounter++) {
				if(roster[secCounter]!=null && roster[secCounter].getProfile().getName().charAt(0)<roster[minIndex].getProfile().getName().charAt(0)) {
					minIndex= secCounter;
				}
				if(roster[secCounter]!=null && roster[secCounter].getProfile().getName().charAt(0)==roster[minIndex].getProfile().getName().charAt(0)) {
					if(roster[secCounter].getProfile().getName().charAt(1)<roster[minIndex].getProfile().getName().charAt(1)) {
						minIndex= secCounter;
					}
				}
			}
			Student temp= roster[minIndex];
			roster[minIndex]=roster[counter];
			roster[counter]=temp;
		}
		p.appendText("* list of students ordered by name **\n");	
		for(int counter=0; counter<roster.length; counter++) {
			if(roster[counter]!=null) {
				p.appendText(roster[counter].toString()+"\n");
			}
		}
		p.appendText("* end of roster **\n");
		
	}

   /**
	 * Sorts roster[] by Payment Date and prints them.
	 */
	public void printT(TextArea p) {
		if(this.size==0) {
			p.appendText("Student roster is empty!\n");
			return;
		}
		Student[] sortedDate= new Student[roster.length];
		boolean paid=false;
		for(int counter=0; counter<roster.length;counter++) {
			if(roster[counter]!=null&&roster[counter].getPayment() > 0) {//will only had students who had made payments to the array
				sortedDate[counter]=roster[counter]; //Adds them in the right order, no nulls	
				paid=true;
			}
		}
		if(!paid) {
			p.appendText("Student roster is empty!\n");
			return;
		}
		for(int counter=0; counter<sortedDate.length;counter++) {
			int minIndex=counter;
			for(int secCounter=minIndex+1; secCounter<sortedDate.length; secCounter++) {
				if(sortedDate[secCounter]!=null&&sortedDate[minIndex]!=null&&sortedDate[secCounter].getDate().compareTo(sortedDate[minIndex].getDate())==-1) {
					minIndex= secCounter;
				}	
			}
			Student temp= sortedDate[minIndex];
			sortedDate[minIndex]=sortedDate[counter];
			sortedDate[counter]=temp;
		}
		p.appendText("* list of students made payments ordered by payment date **\n");
		for(int counter=0; counter<sortedDate.length; counter++) {
			if(sortedDate[counter]!=null) {
				p.appendText(sortedDate[counter]+"\n");
			}
		}
		p.appendText("* end of roster **\n");
	}
	
	/**
	 * Checks if the student is in the roster. 
	 * Makes payment on behalf of student.
	 * @param student that is making the payment.
	 * @return true if payment successful, false otherwise.
	 */
	public boolean payment(Student student) {
		int notFound=-1;
		int index = find(student);
		if(index==notFound) {
			return false;
		}
		if(roster[index].getTuition()>=student.getPayment()) {
			roster[index].payTuition(student.getPayment(),student.getDate());
			return true;
		}
		return false;
	}

	/**
	 * Checks if the International student is in the roster. 
	 * Sets studyAbroad status of student.
	 * @param student that is getting study abroad changed.
	 * @return true if status change successful, false otherwise.
	 */
	public boolean abroadStatus(International student) {
		int notFound=-1;
		int index = find(student);
		if(index==notFound)
			return false;
		if(roster[index].setStudyAbroad(student.getStatus()))
			return true;
		return false;
	}	
	
	/**
	 * Checks if the student is in the roster. 
	 * Sets financial aid of student.
	 * @param student that is getting financial aid.
	 * @return true if aid given successfully, false otherwise.
	 */
	public String aid(Student student) {
		int notFound=-1;
		int index = find(student);
		if(index==notFound)
			return "Student not in the roster.";
		return roster[index].giveAid(student.getPayment());
	}	
	
}
