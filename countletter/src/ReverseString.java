/*
 * @author Colbehr
 * 
 * Assignment reverse string. project 3
 */

import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		// Input
		System.out.print("Enter a string: ");
		String string = console.next();
		// process
		String reversedString = reverseString(string);
		// output
		System.out.print("Letter count: " + reversedString);
		console.close();
	}

	public static String reverseString(String string) {
		String reversedString = "";
		for (int position = string.length() - 1; position >= 0; position--) {
			reversedString = reversedString + string.charAt(position);
		}
		return reversedString;
	}
}
