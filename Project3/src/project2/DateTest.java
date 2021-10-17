package project2;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * Junit test class for date isvalid() method
 * @author Manav Bali
 * @author Daniel Lopez
 *
 */
public class DateTest {

	/**
	 * Creates dates that test edge cases for isvalid method.
	 */
	@Test
	public void testIsValid() {
		Date date1 = new Date("13/31/2021"); 
		assertFalse(date1.isValid());
		
		Date date2 = new Date("2/28/2021"); 
		assertTrue(date2.isValid());
		
		Date date3 = new Date("9/30/2021"); 
		assertTrue(date3.isValid());
		
		Date date4 = new Date("0/19/2021"); //month under 1
		assertFalse(date4.isValid());
		
		Date date5 = new Date("12/19/2021"); //future date 
		assertFalse(date5.isValid());

		Date date6 = new Date("12/31/2020"); //date before 2021
		assertFalse(date6.isValid());
		
		Date date7 = new Date("1/31/2021"); //month at 31
		assertTrue(date7.isValid());
		
		Date date8 = new Date("3/32/2021"); //month over 31
		assertFalse(date8.isValid());
		
		Date date9 = new Date("9/30/2021"); //month at 30
		assertTrue(date9.isValid());
		
		Date date10 = new Date("9/30/2022"); //year over 2021
		assertFalse(date10.isValid());
		
		Date today = new Date();//todays date
		String todaysdate = today.toString();
		Date date11 = new Date(todaysdate); 
		assertTrue(date11.isValid());

		
	}

}
