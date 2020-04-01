package schoolSystem;

public class ForeignStudent extends Student{
	private String country ;
	
	public ForeignStudent(String firstName, String lastName, int schoolId, int grade, String country) {
		super(firstName, lastName, schoolId, grade);
		this.country = country;
	}
	
	public String selfIntroduction() {
		return  "Hi, my name is "+getFirstName()+" and I'm from "+country;
	}

	public String getCountry() {
		return this.country;
	}
}
