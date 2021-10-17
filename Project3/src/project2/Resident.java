package project2;

/**
 * The Resident sub class is where we create a student of type Resident.
 * Tuition is calculated based on Resident pricing.
 * Aid is also calculated and applied in this class.
 * @author Manav Bali
 * @author Daniel Lopez
 */
public class Resident extends Student {
	
	private static final int tuitionCost = 12536; 
	private static final int creditHour = 404;
	private boolean aid;
	private double financialAid;	
	
	/**
	 * Creates an instance of resident given the correct parameters.
	 * @param profile profile of student.
	 * @param credits credits of student.
	 */
	public Resident(Profile profile, int credits) {
		super(profile, credits);
	}
	
	/**
	 * Applies student's aid to their tuition.
	 * Aid can't be over tuition total.
	 * @param amount of aid.
	 * @return applied if aid applied to tuition, error statement otherwise.
	 */
	@Override
	public String giveAid(double amount) {
		if(isParttime()) {
			return "Parttime student doesn't qualify for the award.";
		}
		if(this.aid) {
			return "Awarded once already.";
		}
		this.aid=true;
		financialAid=amount;
		this.setTuition(this.getTuition()-this.financialAid);
		return "Tuition updated.";
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
		if(financialAid>0) {
			return super.toString()+"resident:financial aid $"+String.format("%.2f",financialAid);
		}
		return super.toString()+"resident";
		
	}

}
