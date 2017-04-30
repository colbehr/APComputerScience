/*
 * @author Colbehr
 * Assignment Rectangle class, part one,  Rectangle
 */
package rectangleclass;

public class Rectangle {
	int height = 0;
	int width = 0;

	public Rectangle() {
	}

	public static Rectangle define(int height, int width) {
		Rectangle rectangle = new Rectangle();
		rectangle.height = height;
		rectangle.width = width;
		return rectangle;
	}

	public static void render(Rectangle rectangle) {
		if (rectangle.height < 2) {
			System.out.println("Rectangle must have a height of at least 2");
			return;
		}
		if (rectangle.width < 2) {
			System.out.print("Rectangle must have a width of at least 2");
			return;
		}
		System.out.println("Rendering rectangle with height : "
				+ rectangle.height + ", width: " + rectangle.width);
		printline('+', rectangle.width, '-', '+');
		for (int height = 0; height < rectangle.height; height++) {
			printline('|', rectangle.width, '*', '|');
		}
		printline('+', rectangle.width, '-', '+');
	}

	private static void printline(char leftBoarder, int width, char filler,
			char rightBoarder) {
		System.out.print(leftBoarder);
		for (int i = 0; i < width; i++) {
			System.out.print(filler);
		}
		System.out.println(rightBoarder);
	}
}
