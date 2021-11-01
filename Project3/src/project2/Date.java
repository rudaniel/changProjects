package project2;

import java.util.Calendar;

/**
 * The date class creates a date, that date being todays date by default  or a specific date.
 * The date class can create those dates and check if those dates are real and compare two dates.
 * @author Manav Bali
 * @author Daniel Lopez
 *
 */
public class Date implements Comparable<Date> { 

	private int year;
	private int month;
	private int day;
	
	private static final int QUADRENNIAL = 4;
	private static final int CENTENNIAL = 100; 
	private static final int QUATERCENTENNIAL = 400; 
	private static final int JAN = 1;
	private static final int FEB = 2; 
	private static final int MAR = 3; 
	private static final int APR = 4;
	private static final int MAY = 5;
	private static final int JUN = 6; 
	private static final int JUL = 7; 
	private static final int AUG = 8;
	private static final int SEP = 9;
	private static final int OCT = 10; 
	private static final int NOV = 11; 
	private static final int DEC = 12;
	private static final int MONTHEND31 = 31; 
	private static final int MONTHEND30 = 30; 
	private static final int MONTHEND29 = 29;
	private static final int MONTHEND28 = 28; 
	private static final int MINDAY = 1; 
	/**
	 * Grabs the current instances of date and returns a string.
	 * @return string of date.
	 */
	public String toString() {
	String date= this.month+"/"+this.day+"/"+this.year;
	return date;
	}
	
	/**
	 * Separates the string into the correct instance variable. 
	 * Creates a date object.
	 * @param date the specific date.
	 */
	public Date(String date) { //take �mm/dd/yyyy"�and create a Date object
		String seperate[] = date.split("/");
		month = Integer.parseInt(seperate[0]);
		day = Integer.parseInt(seperate[1]);
		year = Integer.parseInt(seperate[2]);
	} 
	
	/**
	 * Creates a default date with that date being todays date.
	 * Creates a date object.
	 */
	public Date() { //create an object with today's date (see Calendar class)
		Calendar today = Calendar.getInstance();
		 month = today.get(Calendar.MONTH);
		 year = today.get(Calendar.YEAR);
		 day = today.get(Calendar.DATE);
		 month++;
	}
	
	/**
	 * Checks the date to see if its a real date. 
	 * Checks for future dates and dates that don't follows the rules of the months/days.
	 * Dates before 1980 will not be accepted and dates past todays date will also not be accepted.
	 * @return true is date is valid, false otherwise.
	 */
	public boolean isValid() { 
		Date todaysDate = new Date(); 
		if (year == todaysDate.year) {
			if(month == todaysDate.month &&day == todaysDate.day) 
				return true;
			if (month < todaysDate.month && year < todaysDate.year)
				return true;
			if ((month == todaysDate.month && day > todaysDate.day) || month > todaysDate.month)
				return false;	
		}
		if (year != todaysDate.year ) {
			return false;
		}
		int maxMonth = 12;
		int minMonth = 1;
		if (month > maxMonth || month < minMonth) {
			return false;
		}
		else if((month == JAN || month == MAR || month == MAY || month == JUL || month == AUG || month == OCT|| month == DEC) && (day > MONTHEND31 || day < 1) || 
		   (month == APR || month == JUN || month == SEP || month == NOV) && (day > MONTHEND30 || day < MINDAY)) { 
			return false;
		}
		boolean leapYear = leapYear(); 
		if (leapYear == true && (month == FEB && (day > MONTHEND29 || day < MINDAY ))) 
			return false;
		else if (leapYear == false && (month == FEB && (day > MONTHEND28 || day < MINDAY )))
			return false;
		return true;
	}
	
	/**
	*Checks to see if the year is a leap year.
	*@return true if leap year, false otherwise
	*/
	public boolean leapYear() {
		Date todaysDate = new Date(); 
		boolean leapYear = false;
		if (year % QUADRENNIAL == 0) {
			if(year % CENTENNIAL != 0) {
				leapYear = true;	
			}
		}
		if (year % QUATERCENTENNIAL == 0) {
			if( year % CENTENNIAL == 0) {
				leapYear = true;
			}
		}
		if(year == todaysDate.year) {
			leapYear = false;
		}	
		return leapYear;
	}
	
	/**
	 *Compares two dates.
	 * @param date the date to be compared.
	 * @return int 1 if bigger, 0 if the same, -1 if smaller.
	 */
	@Override
	public int compareTo(Date date) { //sort by release date 
		int compareM = date.month;
		int compareD = date.day;
		int compareY = date.year;
		if(this.year < compareY)
			return -1;
		else if(this.year > compareY)
			return 1;
		else if(this.year == compareY && this.month == compareM && this.day == compareD)
			return 0;
		else if (this.year == compareY && this.month == compareM && this.day < compareD)	
			return -1;
		else if (this.year == compareY && this.month == compareM && this.day > compareD)
			return 1;
		else if(this.year == compareY&& this.month < compareM) 		
			return -1;
		else 
			return 1;
	} 
	

	


}
