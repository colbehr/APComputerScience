/*
 * @author Colbehr
 * 
 * Assignment Count letter. project 1
 */

import java.util.Scanner;

public class CountLetter {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		// Input
		System.out.print("Enter a String: ");
		String string = console.next();

		System.out.print("Enter a letter to count: ");
		String input = console.next();
		char letter = input.charAt(0);

		// Process

		int letterCount = countLetter(string, letter);

		// Output

		System.out.println("Letter count: " + letterCount);

		console.close();
	}

	public static int countLetter(String string, char letter) {
		int letterCount = 0;
		for (int position = 0; position < string.length(); position++) {
			if (string.charAt(position) == letter) {
				letterCount++;
			}
		}
		return letterCount;

	}
}
