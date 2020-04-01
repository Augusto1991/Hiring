package schoolSystem;

public class Teacher extends Employee{
	
	Subject subject;
	
	public Teacher(String firstName, String lastName, int schoolId, double salary, Subject subject) {
		super(lastName, lastName, schoolId, salary);
		this.subject = subject;
	}

	public String salaryIncrease(double amount) {
		setSalary(getSalary() + amount);
		return getFirstName()+" "+getLastName()+" new salary is "+getSalary();
	}

}
