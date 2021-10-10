package project2;

public class Resident extends Student {
	
	//partime 3 to >12 credits
	//fulltime 12 to 24 credits
	
	private static final int tuitionCost = 12536; 
	private static final int creditHour = 404;
	private boolean aid;
	private double financialAid;
	private static final int aidMax=10000;
	private static final double minAid = 0;
	//private double tuitionTracker;
	
	//@Override
	public Resident(Profile profile, int credits) {
		super(profile, credits);
		
		
		
//		if(credits<minFulltimeCredits) {
//			//tuitionTracker=UFEE*discountRate+creditHour*(credits);
//			super.tuition=UFEE*discountRate+creditHour*(credits);
//			//setTuition(tuitionTracker);
//		}
//		else {	
//			//tuitionTracker=tuitionCost+UFEE+creditHour*(credits-maxFreeCredits);
//			super.tuition=tuitionCost+UFEE+creditHour*(credits-maxFreeCredits);
//			//setTuition(tuitionTracker);
//		}
//		// TODO Auto-generated constructor stub
	}

		//possibly return string
	public boolean giveAid(double amount) {
		if(isParttime()) {
			//return "Parttime student doesn't qualify for the award.";
			return false;
		}
		if(this.aid) {
			//return "Awarded once already.";
			return false;
		}
		if(amount<minAid) {
			//return "Invalid amount.";
			return false;
		}
		if(amount>aidMax) {
			//return "Invalid amount.";
			return false;
		}
		this.aid=true;
		financialAid=amount;
		//tuitionTracker=tuitionTracker+amount;
		this.setTuition(this.getTuition()-this.financialAid);
		//return "Tuition updated.";
		return true;
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
		if(financialAid>0) {
			return super.toString()+"resident:financial aid $"+String.format("%.2f",financialAid);
		}
		return super.toString()+"resident";
		
	}

}
