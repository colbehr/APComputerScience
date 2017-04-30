/*
 * @author Colbehr
 * Assignment: FracCalc redo.
 * I pretty much restarted, my old code didn't feel very salvagable. I kept my main and gcm.
 * You might be able to see that I was looking at Jacob's code while coding my own, I based 
 * some of my code on his, but really tried not to copy.
 */

import java.util.Scanner;

public class FracCalc {

	/*
	 * Main: all the main does is have the infinite loop, user input, and
	 * prompts, along with some error handling.
	 */
	public static void main(String[] args) {
		System.out.println("Welcome.");
		while (true) {
			// User Input
			@SuppressWarnings("resource")
			Scanner console = new Scanner(System.in);
			System.out
					.println("Enter your calculation or type \"quit\" to exit: ");
			String userInput = console.nextLine();
			// Exit phrase
			if (userInput.equalsIgnoreCase("quit")
					|| userInput.equalsIgnoreCase("exit")) {
				System.out.println("Bye Bye!");
				break;
				// its only going to do math if it contains a operator,
				// otherwise it asks to try something else.
			} else if (userInput.contains("+") || userInput.contains("-")
					|| userInput.contains("*") || userInput.contains("/")) {
				parseInput(userInput);
			} else {
				System.out
						.println("Something doesn't seem right, try something else...");

			}
		}
	}

	// parseInput: it divides up the work a little bit, sends the fractions to
	// "convertToImproper" and then sends them to their respected operation
	// (+,-,*,/) the answer isn't printed here.
	private static void parseInput(String userInput) {
		// Parsing for fractions and operators
		Scanner parser = new Scanner(userInput);
		String firstOperand = parser.next();
		String operator = parser.next();
		String secondOperand = parser.next();
		parser.close();
		// makes fractions improper
		String firstOpImproper = convertToImproper(firstOperand);
		String secondOpImproper = convertToImproper(secondOperand);
		// next
		int num1 = Integer.parseInt(firstOpImproper.substring(0,
				firstOpImproper.indexOf("/")));
		int num2 = Integer.parseInt(secondOpImproper.substring(0,
				secondOpImproper.indexOf("/")));
		int denom1 = Integer.parseInt(firstOpImproper.substring(firstOpImproper
				.indexOf("/") + 1));
		int denom2 = Integer.parseInt(secondOpImproper
				.substring(secondOpImproper.indexOf("/") + 1));
		if (operator.equals("+")) {
			add(num1, denom1, operator, num2, denom2);
		} else if (operator.equals("-")) {
			subtract(num1, denom1, operator, num2, denom2);
		} else if (operator.equals("*")) {
			multiply(num1, denom1, operator, num2, denom2);
		} else if (operator.equals("/")) {
			divide(num1, denom1, operator, num2, denom2);
		} else {
			System.out.println("That isnt a valid operator...");
		}

	}

	// convertToImproper: each fraction gets sent here individually. It does
	// what it says, then returns the fraction back to parseInput.
	private static String convertToImproper(String fraction) {
		int numerator;
		int denominator;

		int underscoreLoc = fraction.indexOf("_");
		int fracLineLoc = fraction.indexOf("/");
		if (fracLineLoc == -1) {
			numerator = Integer.parseInt(fraction);
			denominator = 1;
		} else {
			String fractionNoFullNum = fraction.substring(underscoreLoc + 1);
			String numeratorTemp = fractionNoFullNum.substring(0,
					fractionNoFullNum.indexOf("/"));
			numerator = Integer.parseInt(numeratorTemp);
			String denominatortemp = fractionNoFullNum
					.substring(fractionNoFullNum.indexOf("/") + 1);
			denominator = Integer.parseInt(denominatortemp);
			if (underscoreLoc != -1) {
				int wholeNum = Integer.parseInt(fraction.substring(0,
						underscoreLoc));
				numerator += wholeNum * denominator;
			}
		}
		return numerator + "/" + denominator;
	}

	// adding
	private static void add(int num1, int denom1, String operator, int num2,
			int denom2) {
		int numFinal = num1 * denom2 + num2 * denom1;
		int denomFinal = denom1 * denom2;
		String answer = convertToMixed(numFinal, denomFinal);
		System.out.println(answer);
	}

	// subtracting
	private static void subtract(int num1, int denom1, String operator,
			int num2, int denom2) {
		int numFinal = num1 * denom2 - num2 * denom1;
		int denomFinal = denom1 * denom2;
		String answer = convertToMixed(numFinal, denomFinal);
		System.out.println(answer);
	}

	// multiplying
	private static void multiply(int num1, int denom1, String operator,
			int num2, int denom2) {
		int numFinal = num1 * num2;
		int denomFinal = denom1 * denom2;
		String answer = convertToMixed(numFinal, denomFinal);
		System.out.println(answer);
	}

	// dividing
	private static void divide(int num1, int denom1, String operator, int num2,
			int denom2) {
		int numFinal = num1 * denom2;
		int denomFinal = denom1 * num2;
		String answer = convertToMixed(numFinal, denomFinal);
		System.out.println(answer);
	}

	// convertToMixed: this converts them back to mixed for printing to console.
	// some of the code at the top makes sure it doesn't do more math than it
	// needs too.
	private static String convertToMixed(int numFinal, int denomFinal) {
		if (numFinal == 0) {
			return "0";
		}

		int gcm = gcm(numFinal, denomFinal);
		numFinal /= gcm;
		denomFinal /= gcm;

		if (denomFinal == 1) {
			return "" + numFinal;
		}

		int whole = numFinal / denomFinal;
		if (whole == 0) {
			return numFinal + "/" + denomFinal;
		}
		numFinal -= whole * denomFinal;
		return whole + "_" + Math.abs(numFinal) + "/" + Math.abs(denomFinal);
	}

	// Copied this from my old code, and that was modified code from the stack
	// overflow forum. It finds the greatest common divisor or multiple, I don't
	// understand the difference.
	private static int gcm(int numerator, int denominator) {
		return denominator == 0 ? numerator : gcm(denominator, numerator
				% denominator);
	}
}