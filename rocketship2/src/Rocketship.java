/*
 * @author Colbehr
 * Assignment #5 Rockets, build a rocket with loops.
 */
public class Rocketship {
	public static int SIZE = 13;
	
	public int size;
	
	public Rocketship(int size) {
		// Convert to an odd number - evens don't work!
		this.size = size + 1-size%2;
	}
	
	public void draw() {
		drawNoseCone();
		drawStage3();
		connector();
		drawStage2();
		connector();
		drawStage1();
		connector();
		drawNozzle();
	}
	
	// Tops and bottoms of the stages
	public void plusLine() {
		System.out.print('+');
		printChars('-', size-2);
		System.out.println('+');
	}
	// Sandwiched between stages
	public void connector() {
		printChars('%', size);
		System.out.println();
	}
	
	public void drawNoseCone() {
		for(int i = 0; i < size/2; i++) {
			drawCenteredBox(size/2, i, '/', '\\', '^', 'A');
			System.out.println();
		}
	}
	public void drawStage3() {
		plusLine();
		// Top of the diamond grows...
		for(int i = 0 ; i < size/2; i++) {
			System.out.print('|');
			drawCenteredBox(size/2-1, i, '*', '*', '*' , '*');
			System.out.println('|');
		}
		// And the bottom shrinks
		for(int i = size/2-2 ; i >= 0; i--) {
			System.out.print('|');
			drawCenteredBox(size/2-1, i, '*', '*', '*' , '*');
			System.out.println('|');
		}
		plusLine();
	}
	public void drawStage2() {
		plusLine();
		// Top of the diamond
		for(int i = 0 ; i < size/2-1; i++) {
			System.out.print('|');
			drawCenteredBox(size/2-1, i, '/', '\\', ' ' , '^');
			System.out.println('|');
		}
		// Emblem
		System.out.print("|<");
		printChars(' ', size/2-3);
		System.out.print("USA");
		printChars(' ', size/2-3);
		System.out.println(">|");
		// Bottom of the diamond
		for(int i = size/2-2 ; i >= 0; i--) {
			System.out.print('|');
			drawCenteredBox(size/2-1, i, '\\', '/', ' ' , 'v');
			System.out.println('|');
		}
		plusLine();
	}
	public void drawStage1() {
		plusLine();
		// Thanks to drawCenteredBox's absolute value behavior,
		// the X can be represented with one simple for loop.
		for(int i = 1-size/2; i < size/2; i++) {
			System.out.print('|');
			drawCenteredBox(size/2-1, i, 'X', 'X', ' ' , 'X');
			System.out.println('|');
		}
		plusLine();
	}
	public void drawNozzle() {
		for(int i = size/2-3; i <= size/2; i++) {
			drawCenteredBox(size/2, i, '/', '\\', '$' , ' ');
			System.out.println();
		}
	}
	
	/**
	 * Prints a box padded on either side with spaces
	 * @param space The total number of characters printed will be space*2+1
	 * @param width The total width of the box will be width*2+1
	 * @param lbound The character to print on the far left of the box
	 * @param rbound The character to print on the far right of the box
	 * @param fill The character to fill the middle of the box with
	 * @param tip The character to print when width is zero
	 */
	public static void drawCenteredBox(int space, int width, char lbound, char rbound, char fill, char tip) {
		if(width < 0) {
			width = -width;
			char tmp = lbound;
			lbound = rbound; rbound = tmp;
		}
		// Left-side padding
		printChars(' ', space-width);
		
		// If the width is zero, then we're at the tip, which means we may want
		// special behavior, and we don't want separators.
		if(width == 0) {
			System.out.print(tip);
		} else {
			// Print bounds and fill.
			System.out.print(lbound);
			printChars(fill, width*2-1);
			System.out.print(rbound);
		}
		// Right-side padding (not always necessary.)
		printChars(' ', space-width);
	}
	public static void printChars(char ch, int amt) {
		for(int i = 0; i < amt; i++) {
			System.out.print(ch);
		}
	}

	public static void main(String[] args) {
		Rocketship ship = new Rocketship(SIZE);
		
		ship.draw();
	}
}
