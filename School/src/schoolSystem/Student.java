package schoolSystem;

public class Student extends Person{
	private int grade; 
	
	public Student(String firstName, String lastName, int schoolId, int grade) {
		super(firstName, lastName, schoolId);
		this.grade = grade;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int newGrade) {
		this.grade = newGrade;
	}

	public String selfIntroduction() {
		return  "Hi, my name is "+getFirstName();
	}
	
}
