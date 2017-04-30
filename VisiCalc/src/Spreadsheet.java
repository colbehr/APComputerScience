public class Spreadsheet extends VisiCalc {
	/**
	 * AP Computer Science, Period 2
	 * Project 2 - VisiCalc2015
	 * Extra credit so far: 
	 * -Help (maybe)
	 * @author Colbehr
	 * @version March 2015
	 * Checkpoint 1, 2, and a little bit of 3
	 */
	static Cell[][] sheetCells = new blankCell[7][10];

	public Spreadsheet() {
		initialize();
	}

	// prints spreadsheet
	public void printSheet() {
		println();
		print("            |      A     |      B     |      C     |      D     |      E     |      F     |      G     |");
		printDivider();
		int tableHeight = 0;
		for (tableHeight = 0; tableHeight < 10; tableHeight++) {
			print(printCenteredString(tableHeight + 1 + ""));
			print("|");
			for (int tableWidth = 0; tableWidth < 7; tableWidth++) {
				print(printCenteredString(sheetCells[tableWidth][tableHeight]
						.toString() + ""));
				print("|");
			}
			printDivider();
		}
	}

	// this is called right at the start of the program
	public void initialize() {
		for (int tableHeight = 0; tableHeight < 10; tableHeight++) {
			for (int tableWidth = 0; tableWidth < 7; tableWidth++) {
				sheetCells[tableWidth][tableHeight] = new blankCell(" ");
			}
		}

	}

	// this takes an x and y and makes it into coords for grabbing on sheetCells
	public static String getCell(int x, String y) {
		int y_parsed = parseY(y);
		return sheetCells[y_parsed][x - 1].toString();
	}

	// same for this but it sets it with a string
	public static void setCell(int y, String x, String setString) {
		int y_parsed = y - 1;
		int x_parsed = parseY(x);
		sheetCells[x_parsed][y_parsed].setDisplayValue(setString);
	}

	// this parses a-g when sent in, to indexes
	private static int parseY(String y) {
		int y_parsed = 0;
		if (y.equalsIgnoreCase("a")) {
			y_parsed = 0;
		} else if (y.equalsIgnoreCase("b")) {
			y_parsed = 1;
		} else if (y.equalsIgnoreCase("c")) {
			y_parsed = 2;
		} else if (y.equalsIgnoreCase("d")) {
			y_parsed = 3;
		} else if (y.equalsIgnoreCase("e")) {
			y_parsed = 4;
		} else if (y.equalsIgnoreCase("f")) {
			y_parsed = 5;
		} else if (y.equalsIgnoreCase("g")) {
			y_parsed = 6;
		}
		return y_parsed;
	}

	// this giant method prints most strings sent in centered to 12 spaces, or
	// just prints 12 spaces. The first if test if its a string and adds quotes
	// to the begining and end, the second if tests if it is an int, doesnt put
	// quotes. The last just prints 12 spaces.
	private String printCenteredString(String string) {
		if (string instanceof String && !isParsable(string)
				&& !string.equals(" ")) {
			final int SpaceToPrint = 12;
			int length = string.length();
			String print;
			if (length > SpaceToPrint) {
				print = "\"" + string.substring(0, SpaceToPrint - 5) + "..."
						+ "\"";
				return print;
			} else {
				int spaces = (SpaceToPrint - length) / 2;
				StringBuffer sb = new StringBuffer("");
				sb.insert(0, "\"");
				sb.append(string);
				sb.append("\"");
				for (int i = 0; i < (spaces - 1); i++) {
					sb.append(" ");
					sb.insert(0, " ");
				}
				if (sb.length() % 2 == 0) {
				} else {
					sb.append(" ");
				}
				print = sb.toString();
				return print;
			}
		} else if (isParsable(string)) {
			final int SpaceToPrint = 12;
			int length = string.length();
			String print;
			if (length > SpaceToPrint) {
				print = string.substring(0, SpaceToPrint - 3) + "...";
				return print;
			} else {
				int spaces = (SpaceToPrint - length) / 2;
				StringBuffer sb = new StringBuffer("");
				sb.append(string);
				for (int i = 0; i < spaces; i++) {
					sb.append(" ");
					sb.insert(0, " ");
				}
				if (sb.length() % 2 == 0) {
				} else {
					sb.append(" ");
				}
				print = sb.toString();
				return print;
			}
		} else {
			return "            ";
		}
	}

	// prints dividers for printSheet
	private void printDivider() {
		int i = 1;
		println();
		while (i <= 8) {
			print("------------+");
			i++;
		}
		println();
	}

	// tests if input is an int, therefore it is parseble for parseInt somewhere
	// else
	public static boolean isParsable(String input) {
		boolean parsable = true;
		try {
//			Integer.parseInt(input);
			Float.parseFloat(input);
		} catch (NumberFormatException e) {
			parsable = false;
		}
		return parsable;
	}

}