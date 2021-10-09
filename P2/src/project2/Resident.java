package project2;

public class Resident extends Student {
	private static final int minFulltimeCredits = 12;
	private static final int maxFreeCredits = 16;
	private static final double discountRate = 0.8;
	private static final int tuitionCost = 12536; 
	private static final int UFEE = 3268;
	private static int tuition;
	private static int creditHour = 404;
	private int aid;
	//@Override
	public Resident(Profile profile, int credits, int tuition ) {
		super(profile, credits, tuition);
		
		if(credits<minFulltimeCredits) {
			setTuition(UFEE*discountRate+creditHour*(credits));
		}
		else {	
			setTuition(tuitionCost+UFEE+creditHour*(credits-maxFreeCredits));
		}
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return super.toString();
		
	}
	
}
