package project2;

public class Tristate extends NonResident{
	
	private static final String CT = "CT";
	private static final String NY = "NY";
	/*
	private static final String ny = "ny";
	private static final String ct = "ct";
	*/
	private static final int ctDiscount = 5000;
	private static final int nyDiscount = 4000;
	private Tristates state;
	
	public Tristate(Profile profile, int credits, String state) {
		super(profile, credits);
		this.state=Tristates.valueOf(state.toUpperCase());
	}
	
	//I think this overrides nonresident
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
	
	@Override
	public String toString() {
		return super.toString()+"(tri-state):"+state;
		
	}
	
}
