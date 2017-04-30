import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
/**
 * Simple swing GUI application starter code that will be used for
 * demonstrating event handling in Java.  You will implement several
 * event handling interfaces on this class.
 * @author Bubba Luego
 * @date 6-June-2015
 */
public class EventsDemo implements ActionListener, KeyListener {
	JFrame frame;
	
	public static void main(String args[]) {
		new EventsDemo().run();
	}
	
	public void run() {
		frame = new JFrame("Events Demo Application");
		Timer timer;
		frame.addKeyListener(this);
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		timer = new Timer(1000, this);
		timer.start();
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("ActionEvent: " + e.getWhen());
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println("keyXXXXX: " + arg0.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		String q = arg0.getKeyChar() + "";
		if(q.equals("q")){
		System.exit(0); 
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}