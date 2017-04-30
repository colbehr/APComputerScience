/*
 * @author Colbehr
 * assignement candysoldiers
 */
import java.io.*;
import java.util.Scanner;

public class CandyFile {

	public static void main(String[] args) throws FileNotFoundException {
		File inputFile = new File("candy.txt");
		if (!inputFile.exists()) {
			System.out.println("File not found at:"
					+ inputFile.getAbsolutePath());
			return;
		}
		System.out
				.println("Name        Mon     Tue    Wed   Thu     Fri    Total");
		System.out
				.println("-----------------------------------------------------");
		String name = "";
		File candy = new File("candy.txt");
		double total = 0;
		double finaltotal = 0;
		double temp = 0;
		double winner = 0;
		String winnername = "0";
		Scanner input = new Scanner(candy);
		while (input.hasNext()) {
			if (input.hasNextDouble()) {
				temp = input.nextDouble();
				System.out.printf("%7.2f", temp);
				total = total + temp;
				finaltotal = temp + finaltotal; 
			} else if (input.hasNextLine()) {
				if (total > winner){
					winner = total;
					winnername = name;
					
				}
				System.out.printf("  %-7.2f", total);
				total = 0;
				name = input.next();
				System.out.println();
				System.out.printf("%-9s", name);
			}
		}
		System.out.printf("  %-7.2f", total);
		System.out.printf("%nTotal %47.2f", finaltotal);
		System.out.println("    ");
		System.out.println("The Winner is " + winnername);
		input.close();
	}
}