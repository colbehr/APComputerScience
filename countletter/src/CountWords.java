/*
 * @author Colby Behnrdt
 * assignment Count Words project 5
 */
import java.util.Scanner;

public class CountWords {

	public static void main(String args[]) {
		Scanner console = new Scanner(System.in);
		System.out.println("Enter your sentence: ");
		String sentence = console.nextLine();
		int number = count(sentence);
		System.out.println("The length of that sentence is " + number
				+ " words");

		console.close();
	}

	private static int count(String sentence) {
		int words = 0;
		if (sentence.charAt(0) != ' ') {
			words++;
		}
		for (int i = 0; i < sentence.length(); i++) {
			if ((sentence.charAt(i) == ' ')) {
				words++;
			}
		}
		return words;
	}

}
