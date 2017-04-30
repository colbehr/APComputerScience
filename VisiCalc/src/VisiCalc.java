import java.util.Scanner;

/**
 * AP Computer Science, Period 2
 * 
 * Project 2 - VisiCalc2015
 * 
 * Extra credit so far:
 *
 * @author Colbehr
 * @version 1.0
 */
public class VisiCalc {
	public static void main(String[] args) {
		print("Welcome to VisiCalc!");
//		String tom = "print";
		while (true) {
			// User Input
			@SuppressWarnings("resource")
			Scanner console = new Scanner(System.in);
//			Scanner console = new Scanner(tom);
//			tom = "exit";
			System.out.println();
			print("Enter a command:");
			String userInput = console.nextLine();
			// Interpretation of input
			if (userInput.equalsIgnoreCase("quit")
					|| userInput.equalsIgnoreCase("exit")) {
				System.out.println();
				print("Bye Bye!");
				console.close();
				break;
			} else if (userInput.equalsIgnoreCase("print")) {
				Spreadsheet sheet = new Spreadsheet("name");
				sheet.printSheet();
			} else if (userInput.equalsIgnoreCase("help")) {
				help();
			} else {
				print("Something doesnt seem right, try another command.");
				System.out.println();
				print("Type 'help' to display all commands");
			}
		}
	}

	public static void print(String string) {
		System.out.print(string);
	}

	private static void help() {
		print("Type 'quit' or 'exit' to quit");
		print("Type 'print' to print the spreadsheet");
		print("Type 'help' for a list of commands");
	}
}
