import java.util.Arrays;
/**
 * StudentTester class is used for testing Student objects.
 * @author JimWe
 * Date 2015-1-10
 */
public class StudentTester {
	public static void main(String[] args) {
		// Test initialization of a default student
		Student student1 = new Student();
		printStudent(student1);
		
		// Use the first constructor and set all valid state data
		Student student2 = new Student();
		student2.setFirstName("Bubba");
		student2.setLastName("Luego");
		student2.setGrade(11);
		student2.setGpa(3.7);
		student2.addCourse("AP Computer Science");
		student2.addCourse("English Literature");
		student2.addCourse("PreCalculus");
		student2.addCourse("Ceramics");
		printStudent(student2);

		// Use the first constructor and set some invalid data to see how the Student reacts
		Student student3 = new Student();
		student3.setFirstName("Sparky");
		student3.setLastName("Bondstrand");
//		student3.setGrade(8);
//		student3.setGrade(13);
//		student3.setGpa(-1.0);
//		student3.setGpa(4.1);
		student3.addCourse("Jumping in Lakes");
		printStudent(student3);
		
		// Test the second constructor that takes first name and last name parameters.
		Student student4 = new Student("Virginia", "Wolfe");
		student4.setGrade(12);
		student4.setGpa(3.1);
		student4.addCourse("Introduction to Skydiving");
		printStudent(student4);
	
	}
	
	private static void printStudent(Student student)
	{
		System.out.println("Student = " + student);
		System.out.println("Name    = " + student.getName());
		System.out.println("Grade   = " + student.getGrade());
		System.out.println("GPA     = " + student.getGpa());
		System.out.println("Courses = " + Arrays.toString(student.getCourses()));
		System.out.println();
	}
}