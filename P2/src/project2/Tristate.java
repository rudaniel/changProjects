package project2;

public class Tristate extends NonResident{
	
	private static final String CT = "CT";
	private static final String NY = "NY";
	private static final String ny = "ny";
	private static final String ct = "ct";
	private static final int ctDiscount = 5000;
	private static final int nyDiscount = 4000;
	private String state;
	
	public Tristate(Profile profile, int credits, String state) {
		super(profile, credits);
		this.state=state;
	}
	
	//I think this overrides nonresident
	@Override
	public void tuitionDue(){
		
		if(credits<minFulltimeCredits) {
			super.tuition=UFEE*discountRate+creditHour*(credits);
		}
		else {	
			
			if(credits-maxFreeCredits > 0) {
				
				if(state.equals(NY) || state.equals(ny)) {
					super.tuition=tuitionCost-nyDiscount+UFEE+creditHour*(credits-maxFreeCredits);
				}
				else if(state.equals(CT) || state.equals(ct)) {
					super.tuition=tuitionCost-ctDiscount+UFEE+creditHour*(credits-maxFreeCredits);
				}
					
				
		
			}
			else {
				
				if(state.equals(NY) || state.equals(ny)) {
					super.tuition=tuitionCost-nyDiscount+UFEE;
				}
				else if(state.equals(CT) || state.equals(ct)) {
					super.tuition=tuitionCost-ctDiscount+UFEE;
				}
					
				
			}
			
		}
		
		
		
		
		
	}
	
	@Override
	public String toString() {
		return super.toString()+"(tri-state):"+state;
		
	}
	
}
