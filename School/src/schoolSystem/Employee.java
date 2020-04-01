package schoolSystem;

public abstract class Employee extends Person{
	private double salary; 
	
	protected Employee(String firstName, String lastName, int schoolId, double salary) {
		super(lastName, lastName, schoolId);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}
	
	protected void setSalary(double newSalary) {
		salary = newSalary;
	}
	
	public abstract String salaryIncrease(double amount);
}
