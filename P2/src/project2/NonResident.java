package project2;

/**
 * The NonResident sub class is where we create a student of type NonResident.
 * Tuition is calculated based on NonResident pricing.
 * Aid is also calculated and applied in this class.
 * @author Manav Bali
 * @author Daniel Lopez
 */
public class NonResident extends Student {
	
	public static final int tuitionCost = 29737; 
	public static final int creditHour = 966;
	
	/**
	 * Creates an instance of nonresident given the correct parameters.
	 * @param Profile profile of student.
	 * @param credits credits of student.
	 */
	public NonResident(Profile profile, int credits){
		super(profile, credits);
	
	}
	
	/**
	 * Calculates tuition based on if student is part time or full time.
	 * Credits are also used to find tuition.
	 */
	@Override
	public void tuitionDue(){
		if(isParttime()) {
			setTuition(UFEE*discountRate+creditHour*(getCredits()));
			return;
		}
		else {	
			setTuition(tuitionCost+UFEE);
			if(getCredits() > maxFreeCredits) {
				setTuition(getTuition()+creditHour*(getCredits()-maxFreeCredits));
			}			
		}
	}
	
	/**
	 * Method extends subclasses and is used to print desired output.
	 */
	@Override
	public String toString() {
		return super.toString()+"non-resident";
		
	}

}
