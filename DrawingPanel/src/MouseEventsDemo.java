import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.event.MouseInputListener;

/**
 * Drawing class to explore mouse events in Java
 * 
 * @author Bubba Luego
 * @date 2015-June-7
 * @version 1.0
 */
public class MouseEventsDemo implements MouseInputListener {
	final int WIDTH = 400;
	final int HEIGHT = 400;
	int prevLocx = 0;
	int prevLocy = 0;

	public int getPrevLocx() {
		return prevLocx;
	}

	public int getPrevLocy() {
		return prevLocy;
	}

	Graphics2D graphics;

	public static void main(String[] args) {
		new MouseEventsDemo().run();

	}

	public void run() {
		DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);
		panel.addMouseListener(this);
		panel.setVisible(true);
		graphics = panel.getGraphics();

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("Click!");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		System.out.println("enter!");

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		System.out.println("exit!");

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		System.out.println("press!");

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		System.out.println("released!");
		int size = 1;
		int color = 255;
		while (size < 800) {
			Color randomColor = new Color(color, 5, 5);
			graphics.setColor(randomColor);
			if (size != 30){
			drawCircle(arg0.getX() - size, arg0.getY() - size, size, false);
			} else {
				drawCircle(arg0.getX() - size, arg0.getY() - size, size, false);
				
			}
			size = size + 10;
		}
		if (color > 0) {
			color = color - 10;
		}
		size = 30;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {

		System.out.println("dragged!   " + arg0.getX() + "  " + arg0.getY());
		graphics.drawLine(getPrevLocx(), getPrevLocy(), arg0.getX(),
				arg0.getY());
		prevLocx = arg0.getX();
		prevLocy = arg0.getY();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		System.out.println("moved!");
		prevLocx = arg0.getX();
		prevLocy = arg0.getY();

	}

	public void drawCircle(int x, int y, int radius, boolean fill) {
		graphics.drawOval(x / 2, y / 2, radius, radius);
		if (fill) {
			graphics.fillOval(200, 200, 100, 200);

		}

	}
}
