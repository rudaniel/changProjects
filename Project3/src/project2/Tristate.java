package project2;

/**
 * The Tristate class is a sub class of NonResident where we create a student of type Tristate.
 * Tuition is calculated based on Tristate pricing.
 * Discount is dependent on state.
 * @author Manav Bali
 * @author Daniel Lopez
 */
public class Tristate extends NonResident{
	
	private static final String CT = "CT";
	private static final String NY = "NY";
	private static final int ctDiscount = 5000;
	private static final int nyDiscount = 4000;
	private Tristates state;
	
	/**
	 * Creates an instance of Tristate given the correct parameters.
	 * @param profile profile of student.
	 * @param credits credits of student.
	 * @param state state of student.
	 */
	public Tristate(Profile profile, int credits, String state) {
		super(profile, credits);
		this.state=Tristates.valueOf(state.toUpperCase());
	}
	
	/**
	 * Calculates tuition based on Tristate student guidelines.
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
			if(getCredits()>maxFreeCredits) {
				setTuition(getTuition()+creditHour*(getCredits()-maxFreeCredits));
			}
		}
		if(state.toString().equals(NY)) {
			setTuition(getTuition()-nyDiscount);
		}
		else if(state.toString().equals(CT)) {
			setTuition(getTuition()-ctDiscount);
		}
	}
	
	/**
	 * Method extends subclasses and is used to print desired output.
	 */
	@Override
	public String toString() {
		return super.toString()+"(tri-state):"+state;
		
	}
	
}
