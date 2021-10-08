package project2;

public class Profile {
	private String name;
	private Major major; //5 majors and 2-charater each: CS, IT, BA, EE, ME
	
	public Profile(String name, Major major) {
		this.name=name;
		this.major=major;
	}
	
	@Override
	public String toString() {
		return name+":"+major;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Profile) {
		Profile profile= (Profile) obj;
			if(this.name.equals(profile.name)&&this.major.equals(profile.major)) {
				return true;
			}
		}
		return false;
	}
}
