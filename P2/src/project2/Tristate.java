package project2;

public class Tristate extends NonResident{
	
	private static final String CT = "CT";
	private static final String NY = "NY";
	private static final int ctDiscount = 5000;
	private static final int nyDiscount = 4000;
	private Tristates state;
	
	public Tristate(Profile profile, int credits, Tristates state) {
		super(profile, credits);
		this.state=state;
	}
	
	//I think this overrides nonresident
	@Override
	public void calculateTuition(){
		if(parttime) {
			super.tuition=UFEE*discountRate+creditHour*(credits);
			return;
		}
		else {	
			super.tuition=tuitionCost+UFEE+creditHour*(credits-maxFreeCredits);
		}
		if(state.equals(Tristates.valueOf(NY))) {
			super.tuition=super.tuition-nyDiscount;
		}
		else if(state.equals(Tristates.valueOf(CT))) {
			super.tuition=super.tuition-ctDiscount;
		}
	}
	
	@Override
	public String toString() {
		return super.toString()+"(tri-state) :"+state;
		
	}
	
}
