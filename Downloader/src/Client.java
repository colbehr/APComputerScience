
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultEditorKit;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Client extends JFrame {

	private JPanel Main;
	private JTextField fieldUrl;
	private String url;
	private String saveLocation;
	public static ArrayList<String> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Client() {
		setResizable(false);
		setTitle("Enter A Url");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 119);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);

		JMenuItem menuDefaultLoc = new JMenuItem("Change Default Location");
		menuFile.add(menuDefaultLoc);

		// Quit
		JMenuItem menuQuit = new JMenuItem();
		menuQuit.setText("Quit");
		menuQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuFile.add(menuQuit);

		// Edit
		JMenu menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);

		// Cut Copy and Paste
		JMenuItem menuCut = new JMenuItem(new DefaultEditorKit.CutAction());
		menuCut.setText("Cut");
		menuCut.setMnemonic(KeyEvent.VK_X);
		menuEdit.add(menuCut);
		// Cut Copy and Paste
		JMenuItem menuCopy = new JMenuItem(new DefaultEditorKit.CopyAction());
		menuCopy.setText("Copy");
		menuCopy.setMnemonic(KeyEvent.VK_C);
		menuEdit.add(menuCopy);
		// Cut Copy and Paste
		JMenuItem menuPaste = new JMenuItem(new DefaultEditorKit.PasteAction());
		menuPaste.setText("Paste");
		menuPaste.setMnemonic(KeyEvent.VK_V);
		menuEdit.add(menuPaste);
		// help
		JMenu menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);

		// debug
		JMenuItem menuDebug = new JMenuItem("Debug");
		menuHelp.add(menuDebug);

		Main = new JPanel();
		Main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Main);
		Main.setLayout(null);
		// TEXT BOX
		fieldUrl = new JTextField();
		fieldUrl.setBounds(45, 12, 379, 20);
		Main.add(fieldUrl);
		fieldUrl.setColumns(10);
		// label
		JLabel labelUrl = new JLabel("URL");
		labelUrl.setBounds(10, 8, 46, 29);
		Main.add(labelUrl);
		// Button
		JButton btnGo = new JButton("Go");
		btnGo.setBounds(45, 36, 89, 23);
		Main.add(btnGo);
		btnGo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				url = fieldUrl.getText();
				Link link;
				if (url.toLowerCase().contains("youtube")) {
					link = new YoutubeLink2(url);
				} else {
					link = new Link(url);
				}
				System.out.println("Input url = " + link.toString());
				list = null;
				try {
					list = link.getDownloadURL(url);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.out.print(list.size());
				Main.add(new JButton("Button"));
				Main.revalidate();
				validate();
				if (list.size() < 12) {
					setBounds(Main.getX(), Main.getY(), 450,
							119 + (list.size() * 25));
				} else {
					setBounds(Main.getX(), Main.getY(), 450, 119 + (12 * 25));
				}
				int tempcount = 0;
				System.out.println("Num of Links Returned: " + list.size());
				while (tempcount < list.size()) {
					addButton(list.get(tempcount), 45, 36 + (tempcount * 25));
					tempcount++;
				}
			}
		});
	}

	public void addButton(String Name, int inx, int iny) {
		JButton b = new JButton(Name);
		b.setName(Name);
		b.setSize(89, 23);
		b.setLocation(inx, iny);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			Download url = new Download(b.getName(), b.getName());
//			StringSelection stringSelection = new StringSelection (b.getName());
//			Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
//			clpbrd.setContents (stringSelection, null);
				System.out.println("click");
				System.out.println(b.getName());
			}
		});
		Main.add(b);
		Main.repaint();
		Main.revalidate();
	}

	public static ArrayList<String> getList() {
		return list;

	}

}