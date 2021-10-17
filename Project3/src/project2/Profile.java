package project2;

/**
 * The Profile class creating a new data type profile that will be used to make each student unique.
 * Name and major is all that is need.
 * @author Manav Bali
 * @author Daniel Lopez
 */
public class Profile {
	private String name;
	private Major major; //5 majors and 2-charater each: CS, IT, BA, EE, ME
	
	/**
	 * Creates an instance of Profile given the correct parameters.
	 * @param name name of student.
	 * @param major major of student.
	 */
	public Profile(String name, Major major) {
		this.name=name;
		this.major=major;
	}
	
	/**
	 * Creates an instance of Profile given the correct parameters.
	 * @param name name of student.
	 * @param major major of student.
	 */
	public Profile(String name, String major) {
		this.name=name;
		this.major=Major.valueOf(major.toUpperCase());
	}
	
	/**
	 * Method extends subclasses and is used to print desired output.
	 */
	@Override
	public String toString() {
		return name+":"+major;
	}
	
	/**
	 * Checks to see if two profiles are squal to one another.
	 * @param obj of any subclass.
	 * @return true if equal, false otherwise.
	 */
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
	
	/**
	 * Getter method to return name.
	 * @return name name of student.
	 */
	public String getName() {
		return name;
	}
}
