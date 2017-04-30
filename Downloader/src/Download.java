import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

/**
 * most source code from slartidan
 * https://stackoverflow.com/questions/22273045/java-getting-download-progress
 */

public class Download extends JFrame {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Download a_thing = new Download("name", "url");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param string
	 */
	public Download(String Label, String inurl) {
		JFrame f = new JFrame("Download: " + Label);
		setResizable(false);
		
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container content = f.getContentPane();
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(25);
		progressBar.setStringPainted(true);
		progressBar.setMaximum(100000);
		Border border = BorderFactory.createTitledBorder(Label);
		progressBar.setBorder(border);
		content.add(progressBar, BorderLayout.NORTH);
		f.setSize(300, 85);
		f.setVisible(true);
		f.setLocation(0,0);
		Runnable updatethread = new Runnable() {
			public void run() {
				try {

					URL url = new URL(inurl);
					HttpURLConnection httpConnection = (HttpURLConnection) (url
							.openConnection());
					long completeFileSize = httpConnection.getContentLength();

					java.io.BufferedInputStream in = new java.io.BufferedInputStream(
							httpConnection.getInputStream());
					java.io.FileOutputStream fos = new java.io.FileOutputStream(
							"C:/" + Label);
					java.io.BufferedOutputStream bout = new BufferedOutputStream(
							fos, 1024);
					byte[] data = new byte[1024];
					long downloadedFileSize = 0;
					int x = 0;
					while ((x = in.read(data, 0, 1024)) >= 0) {
						downloadedFileSize += x;

						// calculate progress
						final int currentProgress = (int) ((((double) downloadedFileSize) / ((double) completeFileSize)) * 100000d);

						// update progress bar
						SwingUtilities.invokeLater(new Runnable() {

							@Override
							public void run() {
								progressBar.setValue(currentProgress);
							}
						});

						bout.write(data, 0, x);
					}

					bout.close();
					in.close();
				} catch (FileNotFoundException e) {
				} catch (IOException e) {
				}
			}
		};
		new Thread(updatethread).

		start();
	}
}
