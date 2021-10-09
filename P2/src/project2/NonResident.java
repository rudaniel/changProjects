package project2;

public class NonResident extends Student {
	
	//partime 3 to >12 credits
	//fulltime 12 to 24 credits
	
	protected final int tuitionCost = 29737; 
	protected final int creditHour = 966;
	
	public NonResident(Profile profile, int credits){
		super(profile, credits);
	
	}
	@Override
	public void tuitionDue(){
		if(credits<minFulltimeCredits) {
			super.tuition=UFEE*discountRate+creditHour*(credits);
		}
		else {	
			
			if(credits-maxFreeCredits > 0) {
				super.tuition=tuitionCost+UFEE+creditHour*(credits-maxFreeCredits);
			}
			else {
				super.tuition=tuitionCost+UFEE;
			}
			
		}
	}
	

	@Override
	public String toString() {
		return super.toString()+"non-resident";
		
	}

}
