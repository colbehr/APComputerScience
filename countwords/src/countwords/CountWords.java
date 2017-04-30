package countwords;

import java.util.Scanner;

public class CountWords {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Enter a String: ");
		String string = console.next();


		// Process
		int wordCount = WordCount(string);

		// output
		System.out.println("Word Count: " + wordCount);

		console.close();
	}

	public static int WordCount(String string) {
		int wordCount = 0;
		for (int position = 0; position < string.length(); position++) {
			if (string.charAt(position) == word) {
				wordCount++;
			}
		}

		return wordCount;
	}
}
