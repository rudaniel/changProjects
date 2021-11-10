package project2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Junit test class for International tuitionDue() method
 * @author Manav Bali
 * @author Daniel Lopez
 *
 */
public class InternationalTest {

	/**
	 * Creates international students that test edge cases for tuitionDue() method.
	 */
	@Test
	public void testTuitionDue() {
		
		
		
		String name1 = "James James";
		Major major1 = Major.IT;
		boolean abroad1 = false;
		Profile p1 = new Profile(name1 , major1);
		
		String name2 = "Daniel James";
		Major major2 = Major.IT;
		boolean abroad2 = false;
		Profile p2 = new Profile(name2 , major2);
		
		String name3 = "Angelica S";
		Major major3 = Major.IT;
		boolean abroad3 = true;
		Profile p3 = new Profile(name3 , major3);
		
		Student student1 = new International(p1,15, abroad1); //under 16 credits. Abroad F
		Student student2 = new International(p2,21, abroad2); //above 16 credits. Abroad F
		Student student3 = new International(p3,12, abroad3); //Credits must be 12. Abroad T 
		
		student1.tuitionDue();
		student2.tuitionDue();
		student3.tuitionDue();
	
		double tuition1  = student1.getTuition();
		double tuition2  = student2.getTuition();
		double tuition3  = student3.getTuition();
			
		double Compare1 = 35655.0; //the correct result
		double Compare2 = 40485.0;
		double Compare3 = 5918.0;
		
		
		assertTrue(tuition1 == Compare1);
		
		assertTrue(tuition2 == Compare2);
		
		assertTrue(tuition3 == Compare3);
		
		
	}

}
