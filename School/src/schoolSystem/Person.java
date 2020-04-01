package schoolSystem;

public class Person {

	private String firstName;
	private String lastName;
	private int schoolId;

	public Person(String firstName, String lastName, int schoolId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.schoolId = schoolId;
	}	
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getSchoolId() {
		return schoolId;
	}
	
	public String toString() {
		return schoolId+": "+firstName+" "+lastName;
	}
	
}
