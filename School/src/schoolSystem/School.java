package schoolSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import filter.*;

public class School {
	private Principal principal;
	private List<Teacher> teachers;
	private List<Student> students;
	
	public School(Principal principal, List<Teacher> teachers, List<Student> students) {
		this.principal = principal;
		this.teachers = teachers;
		this.students = students;
	}
	
	public School(Principal principal) {
		this.principal = principal;
		this.teachers = new ArrayList<Teacher>();
		this.students = new ArrayList<Student>();
	}
	
	public List<Teacher> getTeachers() {
		return this.teachers;
	}
	
	public List<Student> getStudents() {
		return this.students;
	}
	
	public void addTeacher(Teacher newTeacher) {
		teachers.add(newTeacher);
	}
	
	public void addStudent(Student newStudent) {
		students.add(newStudent);
	}
	
	public Map<Character,List<Student>> studentsByFirstLetter() {
        Map<Character,List<Student>> groupedLastName = new HashMap<>();

        for(Student student : students){
        	char firstLastNameChar = Character.toUpperCase(student.getLastName().charAt(0));
            if(!groupedLastName.containsKey(firstLastNameChar)){
            	groupedLastName.put(firstLastNameChar, new ArrayList<Student>());
            	groupedLastName.get(firstLastNameChar).add(student);
            } else {
            	groupedLastName.get(firstLastNameChar).add(student);
            }
        }
		return groupedLastName;
	}
	
	public void listStudents() {
		System.out.println("Students: ");
		 for (Student student : this.students) { 
	            System.out.println(student);
	        } 
		 System.out.println();
	}
	
	public void schoolFilterStudentsBy(Filter filter) {
		for (Student student : this.students) { 
			if (filter.applyFilter(student)) {
				System.out.println(student);
			}
        } 
	}
	
	public static void main(String[] args) {
		
		Principal principal  = new Principal("Ana","Principal",0,200);
		
		Subject maths = new Subject("Maths");
		
		List<Teacher> teachers = new ArrayList<Teacher>();
		Teacher teacher1 = new Teacher("Juan","Teacher",1,120,maths);
		teachers.add(teacher1);
		teachers.add(new Teacher("Maria","Teacher",2,120,maths));
		
		List<Student> students = new ArrayList<Student>();
		Student s1 = new Student("Baylor","ALastName",3,6);
		students.add(s1);
		Student s2 = new Student("Briar","CLastName",4,7);
		students.add(s2);
		Student s3 = new Student("Gramercy","ELastName",5,2);
		students.add(s3);
		Student s4 = new Student("Farren","ALastName",6,3);
		students.add(s4);
		students.add(new Student("Gracen","DLastName",7,6));
		students.add(new Student("Abner","CLastName",8,6));
		students.add(new Student("Kehlani","BLastName",9,6));
		students.add(new Student("Quartz","ELastName",10,6));
		students.add(new Student("Quartz","ALastName",11,6));
		students.add(new Student("Zaylee","DLastName",12,6));
		Student s5 = new ForeignStudent("Édouard","ELastName",13,6,"France");
		students.add(s5);
		
		School school = new School(principal,teachers,students);
		
		school.listStudents();
		
		Map<Character,List<Student>> groupedStudents =  school.studentsByFirstLetter();
		System.out.println("Students grouped by first letter:");
		System.out.println(groupedStudents);
		System.out.println();
		
		System.out.println("Checking employee salary increase");
		System.out.println(principal.salaryIncrease(10));
		System.out.println(teacher1.salaryIncrease(10));
		System.out.println();
		
		System.out.println("Checking students self introduction:");
		System.out.println(s1.selfIntroduction());
		System.out.println(s5.selfIntroduction());
		System.out.println();
		
		System.out.println("Filter all students with last name = 'ALastName' :");
		Filter LastName = new LastNameFilter("ALastName");
		school.schoolFilterStudentsBy(LastName);
		System.out.println();
	
		maths.addStudent(s1);
		maths.addStudent(s2);
		maths.addStudent(s3);
		maths.addStudent(s4);
		//Add repeated
		maths.addStudent(s1);
		maths.addStudent(s1);
		System.out.println("List all students taking Maths:");
		System.out.println(maths.getStudents());
		System.out.println();
		
		//Apply filter
		System.out.println("List all students taking Maths with last name = 'ALastName' :");
		System.out.println(maths.getStudentsFilterBy(LastName));
		System.out.println();
		
	}

}
