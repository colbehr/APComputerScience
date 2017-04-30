import java.util.ArrayList;

/**
 * Student class
 * 
 * @author Colbehr Date: 13-January-2015
 */
public class Student {
	private String firstName = "N/a";
	private String lastName = "";
	private int grade = 0;
	private Double Gpa = 0.0;
	private ArrayList<String> Course = new ArrayList<>();

	public Student() {
		
	}

	public Student(String inFirstName, String inLastName) {
		firstName = inFirstName;
		lastName = inLastName;
	}

	public Student(String inFirstName, String inLastName, int inGrade,
			Double inGpa, String inCourse) {
		firstName = inFirstName;
		lastName = inLastName;
		grade = inGrade;
		Gpa = inGpa;
		addCourse(inCourse);
	}

	public void addCourse(String inCourse) {
		Course.add(inCourse);
	}

	public void setGpa(double inGpa) {
		if (inGpa < 4.1 && inGpa >= 0.0) {
			Gpa = inGpa;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void setGrade(int inGrade) {
		if (inGrade > 9 || inGrade < 12) {
			grade = inGrade;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void setFirstName(String inFirstName) {
		firstName = inFirstName;
	}

	public void setLastName(String inLastName) {
		lastName = inLastName;
	}

	public String getName() {
		return firstName + " " + lastName;
	}

	public String getGrade() {
		if(grade != 0){
		return grade + "";
		} else{
			return "No grade";
		}
	}

	public String getGpa() {
		return Gpa + "";
	}

	public String[] getCourses() {
		if (Course != null) {
			String[] courseArray = new String[Course.size()];
			courseArray = Course.toArray(courseArray);
			return courseArray;
		} else {
			return null;
		}

	}

	public String toString() {
		if(grade != 0){
			return firstName + " " + lastName + " - Grade: " + grade;
			} else{
				return firstName + " " + lastName + " - Grade: " + "N/a";
			}
		
	}

}