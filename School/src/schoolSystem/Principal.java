package schoolSystem;

public class Principal extends Employee{

	public Principal(String firstName, String lastName, int schoolId, double salary) {
		super(firstName, lastName, schoolId, salary);
	}
	
	public String salaryIncrease(double amount) {
		//Principal get a 10% extra increased raise
		setSalary(getSalary() + (amount*1.1));
		return getFirstName()+" "+getLastName()+" new salary is "+getSalary();
	}

}
