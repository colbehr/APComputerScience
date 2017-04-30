public class Spreadsheet extends VisiCalc {
	int sizeX = 10;
	int sizeY = 10;
	String name;

	public Spreadsheet(String inName) {
		name = inName;
	}

	public void printSheet() {
		Cell[][] sheet = new Cell[sizeX][sizeY];
		System.out.println();
		print("             |      A     |     B      |     C      |     D      |      E     |      F     |      G     |");
		for (int i = 0; i < 10; i++) {
			System.out.println();
			print(" ------------+------------+------------+------------+------------+------------+------------+------------+");
			System.out.println();
			if (i < 9) {
				print("     " + (i + 1) + "       ");
			} else {
				print("     " + (i + 1) + "      ");
			}
			for (int j = 0; j < 7; j++) {
				print("|");
				sheet[i][j] = Cell.newCell(name + i + j);
				print("            ");
			}
			print("|");
		}
		System.out.println();
		print(" ------------+------------+------------+------------+------------+------------+------------+------------+");
	}
}
