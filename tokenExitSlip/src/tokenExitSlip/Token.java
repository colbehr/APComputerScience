package tokenExitSlip;

import java.util.Scanner;

public class Token {

	/**
	 * addIntegers
	 * 
	 * @param input
	 *            - String containing some integers mixed in with other data.
	 *            E.g. “22 5.6 -8 Zippy 93 -42 3.14 85”
	 * @return sum of any integers found in the input string.
	 */
	public static void main(String[] args) {
		addIntegers("22 5.6 -8 Zippy 93 -42 3.14 85");
	}

	private static int addIntegers(String input) {
		Scanner inputScanner = new Scanner(input);
		int sum = 0;
		while (inputScanner.hasNext()) {
			if (inputScanner.hasNextInt()) {
				sum = sum + inputScanner.nextInt();
			} else {
				System.out.println(inputScanner.next());
			}
		}
		System.out.println("The sum of the ints are " + sum);
		inputScanner.close();
		return sum;
	}

}