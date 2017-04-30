/*
 * @author Colbehr
 * 
 * assignment Count Letter with with boolean. Project 2
 */

import java.util.Scanner;

public class CountLetterWithBoolean {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		// input
		System.out.print("Enter a string of characters: ");
		String string = console.next();

		System.out.print("Enter a letter of count: ");
		String input = console.next();
		char letter = input.charAt(0);

		// process

		int letterCount = Countletter(string, letter, true);

		System.out.print("Letter count: " + letterCount);

		console.close();

	}

	public static int Countletter(String string, char letter,
			Boolean caseSensitivity) {
		int letterCount = 0;
		if (caseSensitivity == false) {
			string = string.toLowerCase();

			letter = Character.toLowerCase(letter);
		}
		for (int position = 0; position < string.length(); position++) {
			if (string.charAt(position) == letter)
			{
				letterCount++;
			}

		}
		return letterCount;
	}

}
