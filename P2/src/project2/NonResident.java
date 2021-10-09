package project2;

public class NonResident extends Student {
	
	//partime 3 to >12 credits
	//fulltime 12 to 24 credits
	
	protected final int tuitionCost = 29737; 
	protected final int creditHour = 966;
	
	public NonResident(Profile profile, int credits){
		super(profile, credits);
		if(credits<minFulltimeCredits) {
			parttime=true;
		}
	}
	
	public void calculateTuition(){
		if(parttime) {
			super.tuition=UFEE*discountRate+creditHour*(credits);
		}
		else {	
			super.tuition=tuitionCost+UFEE+creditHour*(credits-maxFreeCredits);
		}
	}
	
	@Override
	public String toString() {
		return super.toString()+"non-resident";
		
	}

}
