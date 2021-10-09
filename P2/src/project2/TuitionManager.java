package project2;

public class TuitionManager {
	
	public boolean caller(String input){
		if(input.equals("Q")) {
			return false;
		}
		else if(input.length()==0) {
		}
		else if(input.charAt(0)=='A'&&input.length()>1) {
			addStudent(input);
		}
		else if(input.charAt(0)=='R'&&input.length()>1&&input.charAt(1)==',') {
			removeStudent(input);
		}
		else if(input.charAt(0)=='C'&&input.length()==1) {
			calculateTuition(input);
		}
		else if(input.charAt(0)=='T'&&input.length()>1&&input.charAt(1)==',') {
			payTuition(input);
		}
		else if(input.charAt(0)=='S'&&input.length()>1&&input.charAt(1)==',') {
			abroadStatus(input);
		}
		else if(input.charAt(0)=='F'&&input.length()>1&&input.charAt(1)==',') {
			setFinancialAid(input);
		}
		else if(input.charAt(0)=='P') {
			print(input);
		}
		else {
			System.out.println("Invalid command!");
		}
		return true;
	}

	private void print(String input) {
		// TODO Auto-generated method stub
		
	}

	private void setFinancialAid(String input) {
		// TODO Auto-generated method stub
		
	}

	private void abroadStatus(String input) {
		// TODO Auto-generated method stub
		
	}

	private void payTuition(String input) {
		// TODO Auto-generated method stub
		
	}

	private void calculateTuition(String input) {
		// TODO Auto-generated method stub
		
	}

	private void removeStudent(String input) {
		// TODO Auto-generated method stub
		
	}

	private void addStudent(String input) {
		// TODO Auto-generated method stub
		
	}

	public void run() {
		
	}
}
