public class Rocketship {
	public static int SIZE = 13;

	public int size;

	public Rocketship(int size) {
		this.size = size;
	}

	public void drawNoseCone() {
		for (int i = 0; i < size / 2; i++) {
			drawCenteredBox(size / 2, i, '/', '\\', '^', 'A');
			System.out.println();
		}
	}

	public void plusLine() {
		System.out.print('+');
		printChars('-', size - 2);
		System.out.println('+');
	}

	public void percentLine() {
		System.out.print('%');
		printChars('%', size - 2);
		System.out.println('%');
	}

	public void drawStage3() {
		plusLine();
		for (int i = 0; i < size / 2; i++) {
			System.out.print('|');
			drawCenteredBox(size / 2-1, i, '*', '*', '*', '*');
			System.out.println('|');
		}
		for (int i = 0; i > size / 2; i--) {
			System.out.print('|');
			drawCenteredBox(size / 2-1, i, '*', '*', '*', '*');
			System.out.println('|');
		}
		plusLine();
	}

	public static void drawCenteredBox(int space, int width, char lbound,
			char rbound, char fill, char tip) {
		if (width < 0)
			width = -width;
		// Left-side padding
		printChars(' ', space - width);

		// If the width is zero, then we're at the tip, which means we may want
		// special behavior, and we don't want separators.
		if (width == 0) {
			System.out.print(tip);
		} else {
			// Print bounds and fill.
			System.out.print(lbound);
			printChars(fill, width * 2 - 1);
			System.out.print(rbound);
		}
		// Right-side padding (not always necessary.)
		printChars(' ', space - width);
	}

	public static void printChars(char ch, int amt) {
		for (int i = 0; i < amt; i++) {
			System.out.print(ch);
		}
	}

	public static void main(String[] args) {
		Rocketship ship = new Rocketship(SIZE);

		ship.drawNoseCone();
		ship.drawStage3();
		ship.percentLine();

	}
}