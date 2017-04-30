/*
 * @author Colbehr
 * assignment file reading
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fileReading {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("data.txt"));
		float sum = 0;
		float length = 0;
		float even = 0;
		while (input.hasNext()) {
			int value = input.nextInt();
			sum += value;
			length++;
			if (value % 2 == 0) {
				even++;
			}
		}
		float percent = ((even / length) * 100);
		System.out.printf("%.0f numbers, sum = %.0f %n%.0f evens (%.2f%%)",
				length, sum, even, percent);
		input.close();
	}
}
