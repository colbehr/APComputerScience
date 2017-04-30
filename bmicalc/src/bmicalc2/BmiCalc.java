package bmicalc2;

public class BmiCalc {
	public static void main(String[] args) {
		double height;
		double weight;
		double bmi;

		height = 70;
		weight = 195;
		bmi = weight / (height * height) * 703;
		
		System.out.println("Previous BMI: ");
		System.out.println(bmi);
		
		weight = 180;
		bmi = weight / (height * height) * 703;
		
		System.out.println("Current BMI:");
		System.out.println(bmi);
	}
}
