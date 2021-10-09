package project2;

public class International extends NonResident{
	
	//regular can be from 12 to 24 credits
	//Study abroad needs 12 credits exactly
	
	private static final int additionalFee = 2650;
	private boolean studyAbroad;
	private static final int resetPayment=0;
	public International(Profile profile, int credits, boolean studyAbroad) {
		super(profile, credits);
		this.studyAbroad=studyAbroad;
	}
	
	public void setStudyAbroad(boolean studyAbroad) {
		this.studyAbroad=studyAbroad;
		payment=resetPayment;
		if(credits>minFulltimeCredits) {
			credits=minFulltimeCredits;
		}
		//clear date, may need a blank constructor
		date=null;
		calculateTuition();
	}
	
	//I think this overrides nonresident
	@Override
	public void calculateTuition(){	
		if(studyAbroad) {
			super.tuition=additionalFee+super.UFEE;
		}
		super.tuition=super.tuitionCost+additionalFee+super.UFEE+super.creditHour*(credits-super.maxFreeCredits);
	}
	
	@Override
	public String toString() {
		if(studyAbroad) {
			return super.toString()+":international:study abroad";
		}
		return super.toString()+":international";
		
	}
}
