package parametersandreturns;

/*
 * @author Colbehr
 * Assignement Parameters
 */
public class ParametersAndReturns {
	public static void main(String[] args) {
		System.out.println("Squares");
		squares(2);
		squares(6);
		System.out.println("Max Heart Rate");
		maxHeartRate(25);
		maxHeartRate(50);
		System.out.println("Distance between two points");
		distance(2, 1, 5, 1);
		distance(13, 12, 53, 45);
	}

	public static void squares(int x) {
		for (int i = 1; i <= x; i++)
			System.out.println(i + " * " + i + " = " + i * i);
	}

	public static void maxHeartRate(int i) {
		System.out.println(206.9 - (0.67 * i));
	}

	public static void distance(int x1, int x2, int y1, int y2) {
		double ans = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
		System.out.println(ans);
	}
}
