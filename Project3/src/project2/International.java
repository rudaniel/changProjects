package project2;

/**
 * The International class is a sub class of NonResident where we create a student of type International.
 * Tuition is calculated based on International pricing.
 * Abroad student discount is calculated if needed.
 * @author Manav Bali
 * @author Daniel Lopez
 */
public class International extends NonResident{
	
	private static final int resetPayment=0;
	private static final int additionalFee = 2650;
	private boolean studyAbroad;
	
	/**
	 * Creates an instance of international given the correct parameters.
	 * @param profile profile of student.
	 * @param credits credits of student.
	 * @param studyAbroad studyAbroad student.
	 */
	public International(Profile profile, int credits, boolean studyAbroad) {
		super(profile, credits);
		this.studyAbroad=studyAbroad;
	}
	
	/**
	 * Creates an instance of international given the correct parameters.
	 * @param profile profile of student.
	 * @param status studyAbroad student.
	 */
	public International(Profile profile, boolean status) {
		super(profile);
		this.studyAbroad=status;
	}

	/**
	 * Declares a international student as abroad and limits credits if needed.
	 * @param studyAbroad Abroad status.
	 */
	@Override
	public boolean setStudyAbroad(boolean studyAbroad) {
		this.studyAbroad=studyAbroad;
		setPayment(resetPayment);
		if(getCredits()>minFulltimeCredits) { 
			setCredits(minFulltimeCredits);
		}
		setDate(null);
		tuitionDue();
		return true;
	}
	
	/**
	 * Calculates tuition based on international student guidelines.
	 * Credits are also used to find tuition.
	 */
	@Override
	public void tuitionDue(){	
		if(studyAbroad) {
			setTuition(additionalFee+UFEE);
			return;
		}
		setTuition(tuitionCost+UFEE+additionalFee);
		if(getCredits()>maxFreeCredits) {
			setTuition(getTuition()+creditHour*(getCredits()-maxFreeCredits));
		}
	}
	
	/**
	 * Method extends subclasses and is used to print desired output.
	 */
	@Override
	public String toString() {
		if(studyAbroad) {
			return super.toString()+":international:study abroad";
		}
		return super.toString()+":international";
		
	}
	
	/**
	 * Getter method to return studyAbroad status.
	 * @return studyAbroad.
	 */
	public boolean getStatus(){
		return this.studyAbroad;
	}
}
