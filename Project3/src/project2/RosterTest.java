package project2;

import static org.junit.Assert.*;
import org.junit.Test;


/**
 * Junit test class for Roster add() and remove() method
 * @author Manav Bali
 * @author Daniel Lopez
 *
 */
public class RosterTest {
	
	/**
	 * Creates students that test edge cases for add()/remove() method.
	 */
	@Test
	public void testAdd() {
		String name = "John Doe";
		Major major = Major.CS;
		Profile p = new Profile(name , major);
		
		String name2 = "John Doe";
		Major major2 = Major.CS;
		Profile p2 = new Profile(name2 , major2);
		
		String name3 = "Rob Harrison";
		Major major3 = Major.EE;
		Profile p3 = new Profile(name3 , major3);
			
		String name4 = "John Doe";
		Major major4 = Major.IT;
		String state4 = "NY";
		Profile p4 = new Profile(name4 , major4);
	
		String name5 = "James James";
		Major major5 = Major.IT;
		boolean abroad5 = true;
		Profile p5 = new Profile(name5 , major5);
		
		String name6 = "Daniel James";
		Major major6 = Major.IT;
		boolean abroad6 = false;
		Profile p6 = new Profile(name6 , major6);
		
		Student student1 = new Resident(p,18);
		Student student2 = new Resident(p2, 3);
		Student student3 = new NonResident (p3,12);
		Student student4 = new Tristate(p4,18, state4);
		Student student5 = new International(p5,11, abroad5);
		Student student6 = new International(p6,14, abroad6);
		
		Roster list = new Roster();
		
		assertTrue(list.add(student1));
		
		assertFalse(list.add(student2)); //Wont add copy of student
		
		assertTrue(list.add(student3)); 
		
		assertTrue(list.add(student4));

		assertTrue(list.add(student5));
		
		assertTrue(list.add(student6)); //array grows after 4
		
		
	}

	@Test
	public void testRemove() {
		String name = "John Doe";
		Major major = Major.CS;
		Profile p = new Profile(name , major);
		
		String name2 = "John Doe";
		Major major2 = Major.CS;
		Profile p2 = new Profile(name2 , major2);
		
		String name3 = "Rob Harrison";
		Major major3 = Major.BA;
		String state3 = "NY";
		Profile p3 = new Profile(name3 , major3);
		
		String name4 = "James James";
		Major major4 = Major.IT;
		boolean abroad4 = true;
		Profile p4 = new Profile(name4 , major4);
		
		Student student1 = new Resident(p,18);
		Student student2 = new NonResident(p2,18);
		Student student3 = new Tristate(p3,18, state3);
		Student student4 = new International(p4,20, abroad4);
		
		Roster list = new Roster();
		
		assertFalse(list.remove(student1)); 
		
		list.add(student1);
		list.add(student2);
		list.add(student3);
		
		assertTrue(list.remove(student2)); //removes middle of list
		
		assertTrue(list.remove(student3)); //removes after initial middle remove. No empty spaces in the list.
		
		assertFalse(list.remove(student4)); //removing student thats not in the list after the list has created.
		
		
		
	}

}
