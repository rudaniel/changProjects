package project2;

public class NonResident extends Student {
	
	//partime 3 to >12 credits
	//fulltime 12 to 24 credits
	
	public static final int tuitionCost = 29737; 
	public static final int creditHour = 966;
	
	public NonResident(Profile profile, int credits){
		super(profile, credits);
	
	}
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
	

	@Override
	public String toString() {
		return super.toString()+"non-resident";
		
	}

}
