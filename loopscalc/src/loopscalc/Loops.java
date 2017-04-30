package loopscalc;
/*
 * @author Colbehr 
 * assignment Loops Multiplication Tables
 */
public class Loops {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i = i + 1) {

			for (int j = 1; j <= 10; j = j + 1) {
				calcs(i, j);
			}
		}

	}

	public static void calcs(int i, int j) {
		System.out.println(i + " * " + j + " = " + i * j);

	}
}
