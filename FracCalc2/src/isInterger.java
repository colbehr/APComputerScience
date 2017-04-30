import java.util.Scanner;

public class isInterger {
	public static boolean isInteger(String s) {
		Scanner sc = new Scanner(s.trim());
		if (!sc.hasNextInt())
			return false;
		sc.nextInt();
		return !sc.hasNext();
	}

	private static void reduceFraction(Operand outputOperand) {
		for (int i = Math.max(outputOperand.denominator,
				outputOperand.numerator); i > 0; i--);
		{
			if ((outputOperand.denominator % i == 0)
					&& (outputOperand.numerator % i == 0)) 
			{
				outputOperand.denominator /= i;
				outputOperand.numerator /= i;
				break;
			}
		}
	}
}
