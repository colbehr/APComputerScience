/*
 * @author Colbehr
 * Assignment FracCalc checkpoint2
 * 
 * 		A lot of this code is probably redundant, and could be a ton better. 
 * I just don't want to break anything until I get a good chance to fix it. 
 * I believe it works enough for the checkpoint. 
 */

import java.util.Scanner;

public class fracCalc2 {

	public static void main(String[] args) {
		while (true) {
			// Input
			@SuppressWarnings("resource")
			Scanner console = new Scanner(System.in);
			System.out.println("Enter your calculation or type quit to exit: ");
			String userInput = console.nextLine();
			// Exit phrase
			if (userInput.equalsIgnoreCase("quit")) {
				System.out.println("Quitting.");
				break;
			} else {
				parseInput(userInput);
			}
		}
	}

	public static int gcm(int a, int b) {
		return b == 0 ? a : gcm(b, a % b);

	}

	public static String asFraction(int a, int b) {
		long gcm = gcm(a, b);
		return (a / gcm) + "/" + (b / gcm);
	}

	private static void parseInput(String userInput) {
		if (userInput.contains("_")) { // If Mixed number
			int underscore1 = userInput.indexOf("_");
			// Full Number
			String fullNumbers1 = userInput.substring(0, underscore1);
			int fullNumberi1 = Integer.parseInt(fullNumbers1);
			// Fraction line1
			int fracLine1 = userInput.indexOf("/");
			int operatorLoc = 0;
			String operatorText = "Broken";
			// if adding
			if (userInput.contains("+")) {
				operatorLoc = userInput.indexOf("+");
				operatorText = "+";
				// If subtracting
			} else if (userInput.contains("-")) {
				operatorLoc = userInput.indexOf("-");
				operatorText = "-";
				// If multiplying
			} else if (userInput.contains("*")) {
				operatorLoc = userInput.indexOf("*");
				operatorText = "*";
				// If dividing
			} else if (userInput.contains("/")) {
				operatorLoc = userInput.indexOf("/", fracLine1 + 1);
				operatorText = "/";
			} else {
				System.out.println("You broke me.");
			}
			// underscore 2
			int underscore2 = userInput.indexOf("_", operatorLoc);
			// Full Number 2
			String fullNumbers2 = userInput.substring(operatorLoc + 2,
					underscore2);
			int fullNumberi2 = Integer.parseInt(fullNumbers2);
			// Fraction line2
			int fracLine2 = userInput.indexOf("/", operatorLoc);
			// Numerator2
			String numerators2 = userInput
					.substring(underscore2 + 1, fracLine2);
			int numeratori2 = Integer.parseInt(numerators2);
			// Denominator2
			String denominators2 = userInput.substring(fracLine2 + 1);
			int denominatori2 = Integer.parseInt(denominators2);
			// Numerator1
			String numerators1 = userInput
					.substring(underscore1 + 1, fracLine1);
			int numeratori1 = Integer.parseInt(numerators1);
			// Denominator1
			String denominators1 = userInput.substring(fracLine1 + 1,
					operatorLoc - 1);
			int denominatori1 = Integer.parseInt(denominators1);
			calculate(fullNumberi1, numeratori1, denominatori1, operatorText,
					fullNumberi2, numeratori2, denominatori2);

		} else { // improper fraction
			// Fraction line1
			int fracLine1 = userInput.indexOf("/");
			int operatorLoc = 0;

			String operatorText = "Broken";
			// if adding
			if (userInput.contains("+")) {
				operatorLoc = userInput.indexOf("+");
				operatorText = "+";
				// If subtracting
			} else if (userInput.contains("-")) {
				operatorLoc = userInput.indexOf("-");
				operatorText = "-";
				// If multiplying
			} else if (userInput.contains("*")) {
				operatorLoc = userInput.indexOf("*");
				operatorText = "*";
				// If dividing
			} else if (userInput.contains("/")) {
				operatorLoc = userInput.indexOf("/", fracLine1 + 1);
				operatorText = "/";
			} else {
				System.out.println("You broke me.");
			}
			// Fraction line2
			int fracLine2 = userInput.indexOf("/", operatorLoc);
			// Numerator2
			String numerators2 = userInput
					.substring(operatorLoc + 2, fracLine2);
			int numeratori2 = Integer.parseInt(numerators2);
			// Denominator2
			String denominators2 = userInput.substring(fracLine2 + 1);
			int denominatori2 = Integer.parseInt(denominators2);
			// Numerator1
			String numerators1 = userInput.substring(0, fracLine1);
			int numeratori1 = Integer.parseInt(numerators1);
			// Denominator1
			String denominators1 = userInput.substring(fracLine1 + 1,
					operatorLoc - 1);
			int denominatori1 = Integer.parseInt(denominators1);
			int fullNumberi1 = 0;
			int fullNumberi2 = 0;
			calculate(fullNumberi1, numeratori1, denominatori1, operatorText,
					fullNumberi2, numeratori2, denominatori2);

		}

	}

	private static void calculate(int fullnumber1, int numerator1,
			int denominator1, String operator, int fullnumber2, int numerator2,
			int denominator2) {
		// if multiply then do the math
		if (operator.equals("*") && fullnumber1 == 0) {
			int answerNum = (numerator1 * numerator2);
			int answerDen = (denominator1 * denominator2);
			System.out.println("= " + asFraction(answerNum, answerDen));
			// multiply with mixed number
		} else if (operator.equals("*") && fullnumber1 != 0) {
			int answerNum = (((fullnumber2 * denominator2) + numerator2) * ((fullnumber1 * denominator1) + numerator1));
			int answerDen = (denominator1 * denominator2);
			System.out.println("= " + asFraction(answerNum, answerDen));
			// if adding then do math
		} else if (operator.equals("+") && fullnumber1 == 0) {
			int commonDenominator = (denominator2 * denominator1);
			int numeratorCommon1 = (numerator1 * denominator2);
			int numeratorCommon2 = (numerator2 * denominator1);
			int answerNum = (numeratorCommon1 + numeratorCommon2);
			int answerDen = (commonDenominator);
			// adding with mixed number
			System.out.println("= " + asFraction(answerNum, answerDen));
		} else if (operator.equals("+") && fullnumber1 != 0) {
			int commonDenominator = (denominator2 * denominator1);
			int numeratorCommon1 = ((fullnumber1 * denominator1) + numerator1);
			int numeratorCommon2 = ((fullnumber2 * denominator2) + numerator2);
			int answerNum = (numeratorCommon1 * denominator2)
					+ (numeratorCommon2 * denominator1);
			int answerDen = (commonDenominator);
			System.out.println("= " + asFraction(answerNum, answerDen));

		} else if (operator.equals("-") && fullnumber1 == 0) {
		} else if (operator.equals("-") && fullnumber1 != 0) {
		} else if (operator.equals("/") && fullnumber1 == 0) {
		} else if (operator.equals("/") && fullnumber1 != 0) {
		} else {
			System.out.println("You broke me.");
		}
	}
}
