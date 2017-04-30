import java.util.Scanner;

/**
 * AP Computer Science, Period 2 Project 2 - VisiCalc2015 Extra credit so far:
 * -Help (maybe)
 * 
 * @author Colbehr
 * @version March 2015 Checkpoint 1, 2, and a little bit of 3
 */
public class VisiCalc {
	public static void main(String[] args) {
		print("Welcome to VisiCalc!");
		Spreadsheet sheet = new Spreadsheet();
		sheet.initialize();
		while (true) {
			@SuppressWarnings("resource")
			Scanner console = new Scanner(System.in);
			println();
			print("Enter a command:");
			String userInput = console.nextLine();
			// Interpretation of input
			// This entire if command is all commands that can go into VisiCalc
			// with a try catch to catch exceptions
			try {
				if (userInput.equalsIgnoreCase("quit")
						|| userInput.equalsIgnoreCase("exit")) {
					println();
					print("Bye Bye!");
					console.close();
					break;
				} else if (userInput.equalsIgnoreCase("print")) {
					sheet.printSheet();
				} else if (userInput.equalsIgnoreCase("help")) {
					help();
				} else if (userInput.equalsIgnoreCase("clear")) {
					print("are you sure? y/n?");
					boolean answer = false;
					println();
					while (answer == false) {
						String a = console.nextLine();
						if (a.equals("y")) {
							answer = true;
							sheet.initialize();
						} else if (a.equals("n")) {
							answer = true;
						} else {
							print("y/n?");
						}
					}
					answer = false;
					// this is for display NOT set

				} else if (userInput.substring(0, 2).toLowerCase()
						.matches(".*[abcdefg].*")
						&& userInput.substring(0, 2)
								.matches(".*[1234567890].*")
						&& !userInput.contains("=")) {
					try {
						if (userInput.substring(0, 3).contains("10")) {
							display10(userInput);
						} else {
							display(userInput);
						}
					} catch (StringIndexOutOfBoundsException e) {
						display(userInput);
					}
					// contains specific pre-requisites for set but not display
				} else if (userInput.substring(0, 2).toLowerCase()
						.matches(".*[abcdefg].*")
						&& userInput.substring(0, 2)
								.matches(".*[1234567890].*")
						&& userInput.contains("=")) {
					if (userInput.substring(0, 3).contains("10")) {
						set10(userInput);
					} else {
						set(userInput);
					}
					// ping pong
				} else if (userInput.equalsIgnoreCase("ping")) {
					print("pong");
					// prints cat
				} else if (userInput.equalsIgnoreCase("cat")) {
					print("    (\"`-/\")_.-'\"``-._");
					println();
					print("      . . `; -._    )-;-,_`)");
					println();
					print("     (v_,)'  _  )`-.\\  ``-'");
					println();
					print("    _.- _..-_/ / ((.'");
					println();
					print("  ((,.-'   ((,/    ");
				} else {
					print("Something doesnt seem right, try another command.");
					println();
					print("Type 'help' to display all commands");
				}
			} catch (Exception e) {
				print("Something doesnt seem right, try another command.");
				println();
				print("Type 'help' to display all commands");
			}
		}
	}

	// setting cells 1-9
	public static void set(String string) {
		String x = string.substring(0, 1);
		int y = Integer.parseInt(string.substring(1, 2));
		String set = string.substring(string.indexOf("=") + 1, string.length());
		if (set.startsWith(" ")) {
			String setfix = set.substring(1, set.length());
			Spreadsheet.setCell(y, x, setfix);
		} else {
			Spreadsheet.setCell(y, x, set);
		}
		print("Set Success!");
	}

	// setting cells 10
	public static void set10(String string) {
		String x = string.substring(0, 1);
		int y = Integer.parseInt(string.substring(1, 3));
		String set = string.substring(string.indexOf("=") + 1, string.length());
		if (set.startsWith(" ")) {
			String setfix = set.substring(1, set.length());
			Spreadsheet.setCell(y, x, setfix);
		} else {
			Spreadsheet.setCell(y, x, set);
		}
		print("Set Success!");
	}

	// display cells 1=9
	public static void display(String string) {
		String x = string.substring(0, 1);
		int y = Integer.parseInt(string.substring(1, 2));
		println();
		String finalString = Spreadsheet.getCell(y, x);
		if (finalString == "" || finalString == " " || finalString == "  ") {
			print("Cell" + string + ": " + "<empty>");
		} else {
			print("Cell" + string + ": " + finalString);
		}
	}

	// display cells 10
	public static void display10(String string) {
		String x = string.substring(0, 1);
		int y = Integer.parseInt(string.substring(1, 3));
		println();
		String finalString = Spreadsheet.getCell(y, x);
		if (finalString == "" || finalString == " " || finalString == "  ") {
			print("Cell" + string + ": " + "<empty>");
		} else {
			print("Cell" + string + ": " + finalString);
		}
	}

	// just an enter/return
	public static void println() {
		System.out.println();
	}

	// prints a string
	public static void print(String string) {
		System.out.print(string);
	}

	// help stuff
	private static void help() {
		print("Type 'quit' or 'exit' to quit");
		println();
		print("Type 'print' to print the spreadsheet");
		println();
		print("Type a coulum and a row to show a value in the spreadsheet, for example, 'a1'");
		println();
		print("Type a coulum and a row then ' = ' then a value to set a value in the spreadsheet, for example, 'a1 tom'");
		println();
		print("Type 'clear' to clear the spreadsheet");
		println();
		print("Type 'cat' for a cat");
		println();
		print("Type 'ping'");
		println();
		print("Type 'help' for a list of commands");
	}
}
