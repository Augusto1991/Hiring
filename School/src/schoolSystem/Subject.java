package schoolSystem;

import java.util.LinkedHashSet;

import filter.Filter;

public class Subject {

	private String name;
	private LinkedHashSet<Student> students;
	
	public Subject(String name) {
		this.name = name;
		students = new LinkedHashSet<Student>();
	}
	
	public String getName() {
		return name;
	}
	public LinkedHashSet<Student> getStudents() {
		return students;
	}
	
	public void addStudent(Student s) {
		students.add(s);
	}
	
	public LinkedHashSet<Student> getStudentsFilterBy(Filter filter) {
		LinkedHashSet<Student> studentsFiltered = new LinkedHashSet<Student>();
		for (Student student : this.students) { 
			if (filter.applyFilter(student)) {
				studentsFiltered.add(student);
			}
            
        } 
		return studentsFiltered;
	}
}
