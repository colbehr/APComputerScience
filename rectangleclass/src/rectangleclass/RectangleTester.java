/*
 * @author Colbehr
 * Assignment Rectangle class, part two, RectangleTester
 */
package rectangleclass;

public class RectangleTester {

	public static void main(String[] args) {
		Rectangle myRectangle = Rectangle.define(3, 5);

		Rectangle.render(myRectangle);

		Rectangle.render(Rectangle.define(9, 7));
	}

	public static void show(Rectangle rectangle) {
		System.out.println("Rectangle height: " + rectangle.height
				+ ", width: " + rectangle.width);
		Rectangle.render(rectangle);
		System.out.println("");
	}
}
