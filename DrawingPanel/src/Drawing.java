import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;

/**
 * Drawing class to explore 2D graphics in Java
 * @author JimWe
 * @date 2015-May-10
 * @version 1.0
 */
public class Drawing
{
	Graphics2D g;
	
	public static void main(String[] args) {
		Drawing myDrawing = new Drawing();
		myDrawing.run();
	}
	public void run()
	{
		// Create a panel that is 600 pixels square
		DrawingPanel panel = new DrawingPanel(600,600);
//		
//		// Get the graphics context from the new panel. All drawing is done on the context.
		g = panel.getGraphics();
//		
//		// draw a square starting at 100,100 that has sides that are 400 pixels in length.
//		g.drawRect(100, 100, 400, 400);
//		
//		// Change the pen color in the graphics context
//		g.setColor(Color.BLUE);
//		
//		// Draw an oval that fills the rectangle starting at point 200,200 that is 100 x 200 pixels on the sides.
//		g.fillOval(200, 200, 100, 200);
//		
//		// Change the pen width and paint a yellow border around the ellipse.
//		g.setStroke(new BasicStroke(8.0f));
//		g.setColor(Color.YELLOW);
//		g.drawOval(2 00, 200, 100, 200);
//		
//		// Sign the masterpiece in red
//		g.setColor(Color.RED);
//		g.drawString("Sparky Bondstrand", 10, 590);
		String answer = JOptionPane.showInputDialog("Enter Speed (1-10)");
		int x = 100;
		int y = 100;
		while (!panel.closing) {
			g.setColor(Color.white);
			drawCircle(x,y,100,true);
			g.setColor(Color.red);
			drawCircle(x,y,100,true);
			try{
				panel.sleep(Integer.parseInt(answer) * 10);
			} catch (Exception name){
				 g.setFont(new Font("Courier New", Font.BOLD, 49));
				g.drawString("You broke it somehow.", 0, 100);
			}
//			if (x < 500*2 && y < 500*2){
//				x = x+10;
//				y = y+10;
//			}
			y--;
			if (x < y){
				x  = x + 16;
				y = y + 50;	
			} 
			g.setColor(Color.GREEN);
			drawCircle(x,y,100,true);
		}

	}
	public void drawCircle(int x, int y, int radius, boolean fill){
		g.drawOval(x/2, y/2, radius, radius);
		
	}
	
}