package project2;

public class International extends NonResident{
	
	//regular can be from 12 to 24 credits
	//Study abroad needs 12 credits exactly
	
	//does this need to be public
	private static final int resetPayment=0;
	private static final int additionalFee = 2650;
	
	private boolean studyAbroad;
	public International(Profile profile, int credits, boolean studyAbroad) {
		super(profile, credits);
		this.studyAbroad=studyAbroad;
	}
	
	public void setStudyAbroad(boolean studyAbroad) {
		this.studyAbroad=studyAbroad;
		setPayment(resetPayment);
		if(getCredits()>minFulltimeCredits) {
			setCredits(minFulltimeCredits);
		}
		//clear date, may need a blank constructor
		setDate(null);
		tuitionDue();
	}
	
	//I think this overrides nonresident
	@Override
	public void tuitionDue(){	
		if(studyAbroad) {
			setTuition(additionalFee+UFEE);
		}
		setTuition(tuitionCost+additionalFee+UFEE+creditHour*(getCredits()-maxFreeCredits));
	}
	
	@Override
	public String toString() {
		if(studyAbroad) {
			return super.toString()+":international:study abroad";
		}
		return super.toString()+":international";
		
	}
}
