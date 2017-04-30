import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Timer;

/**
 * Drawing class to explore displaying images in Java
 * 
 * @author Bubba Luego
 * @date 2015-June-8
 * @version 1.0
 */

public class ImageDemo implements ActionListener {
	DrawingPanel panel;
	Timer timer;
	int imageIndex = 0;
	int WIDTH = 400;
	int HEIGHT = 400;
	ArrayList<URL> webImages;

	public static void main(String[] args) {
		new ImageDemo().run();

	}

	public void run() {
		webImages = getURLList();
		panel = new DrawingPanel(WIDTH, HEIGHT);
		loadStartPage();
		timer = new Timer(3000, this);
		timer.start();
	}

	private void loadStartPage() {
		try {
			URL shs = new URL(
					"https://sehome.bellinghamschools.org/sites/default/files/resize/domain-8/Sehome_color129x200-97x150.png");
			BufferedImage img = ImageIO.read(shs);
			panel.getGraphics().drawImage(img, 0, 0, WIDTH, HEIGHT, 0, 0,
					img.getWidth(), img.getHeight(), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private ArrayList<URL> getURLList() {
		ArrayList<URL> webImages = new ArrayList<>();
		try {
			webImages.add(new URL(
					"http://images.wsdot.wa.gov/nw/005vc20609.jpg"));
			webImages.add(new URL("http://www.harveyfield.com/wxcam.jpg"));
			webImages.add(new URL(
					"http://images.wsdot.wa.gov/nw/005vc16508.jpg"));
			webImages
					.add(new URL(
							"https://www.whidbeytel.com/sites/all/themes/wtel/cam/dock-boothdock.jpg"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return webImages;
	}

	public BufferedImage getNextFileImage() {
		BufferedImage img = null;
		String imageFile = ".\\sailboat" + imageIndex + ".jpg";
		try {
			img = ImageIO.read(new File(imageFile));
		} catch (IOException e) {
			System.out.println("file " + imageFile + " not found.");
		}
		return img;
	}

	public BufferedImage getNextWebImage() {
		BufferedImage img = null;
		if (imageIndex >= webImages.size()) {
			imageIndex = 0;
		}
		try {
			img = ImageIO.read(webImages.get(imageIndex));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}

	public BufferedImage getNextFolderImage() {
		BufferedImage img = null;
		String imageFile = ".\\sailboat" + imageIndex + ".jpg";
		try {
			img = ImageIO.read(new File(imageFile));
		} catch (IOException e) {
			System.out.println("file " + imageFile + " not found.");
		}
		return img;
	}	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		BufferedImage img = getNextWebImage();
		Graphics graphics = panel.getGraphics();
		panel.clear();
		if (img == null) {
			imageIndex = 0;
		} else {
			graphics.drawImage(img, 0, 0, Math.min(WIDTH, img.getWidth()),
					Math.min(HEIGHT, img.getHeight()), 0, 0, img.getWidth(),
					img.getHeight(), null);
			imageIndex++;
		}
	}
}
