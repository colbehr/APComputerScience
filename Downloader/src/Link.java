import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Link {
	String URL;

	public Link(String inURL) {
		URL = inURL;
	}

	public String toString() {
		return URL;
	}

	public void Print(String string) {
		System.out.print(string);
	}

	public void Println(String string) {
		System.out.println(string);
	}
	// public String decodeURL(String inurl) throws IOException {
	// if (!inurl.contains("http://")) {
	// inurl = "http://" + inurl;
	// }
	// //Connects to inurl
	// Document document = Jsoup.connect(inurl).ignoreContentType(true).get();
	// //grabs content of body tag
	// Elements html = document.getElementsByTag("body");
	// String htmlTemp = "" + html;
	// Scanner scanner = new Scanner(htmlTemp);
	// String temp = null;
	// while (scanner.hasNext()) {
	// temp = scanner.next();
	// if (temp.contains(".mp4")) {
	// break;
	// }
	// }
	// int mp4Loc = temp.indexOf(".mp4") + 3;
	// int httpLoc = temp.indexOf("http");
	// String link = temp.substring(httpLoc, mp4Loc);
	// scanner.close();
	// return link;
	// }

	public ArrayList<String> getDownloadURL(String URL) throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		list.add(URL);
		Println(list.toString());
		return list;
	}


	// public void download(String url) throws IOException {
	// String location = "C:\\";
	// // String name = name(url);
	// File file = new File(location + "download" + ".mp4");
	// URL website = new URL(url);
	// ReadableByteChannel rbc = Channels.newChannel(website.openStream());
	// FileOutputStream fos = new FileOutputStream(file);
	// fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
	// fos.close();
	// }
	public String getName(){
		//TODO
		return null;
		
	}
	// private String name(String url) {
	//
	// // http://vb.mirror.ninja/64kb.mp4
	// Scanner nameScanner = new Scanner(url);
	// if (nameScanner.hasNext()) {
	// nameScanner.next();
	// }
	// String name = nameScanner.next();
	// return name;
	// }

}
