import java.io.*;
import java.net.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

import javax.script.ScriptException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Parser {
	public static void main(String[] args) throws Exception {
		for (int i = 1; i < 600; i++) {
			String url = "http://animejoy.tv/watch/one-piece/" + i;
			String name = getTitle(url);
			String downloadURLUni = getURL(url);
			String downloadUrlConverted = convertUni(downloadURLUni);
			Print(name);
			Print("");
			Print(downloadUrlConverted);
			download(downloadUrlConverted, name);
			Print("");

		}
		// for (int i = 10; i < 100; i++) {
		// String url = "http://animejoy.tv/watch/akiba-chan/1"
		// + i;
		// String name = getTitle(url);
		// String downloadURLUni = getURL(url);
		// String downloadUrlConverted = convertUni(downloadURLUni);
		// Print(name);
		// Print("");
		// Print(downloadUrlConverted);
		// download(downloadUrlConverted, name);
		// Print("");
		// }
	}

	private static void download(String url, String name) throws IOException {
		String location = "C:\\HERE\\Show";
		File file = new File(location + name + ".mp4");
		URL website = new URL(url);
		Print("Download Started");
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		@SuppressWarnings("resource")
		FileOutputStream fos = new FileOutputStream(file);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		Print("Download Finished");
	}

	private static void Print(String string) {
		System.out.println(string);
	}

	private static String convertUni(String downloadURLUni) throws IOException,
			ScriptException {
		String result = java.net.URLDecoder.decode(downloadURLUni, "UTF-8");
		return result;
	}

	private static String getURL(String url) throws IOException {
		Document document = Jsoup.connect(url).timeout(0).userAgent("Mozilla").get();
		Elements script = document.getElementsByTag("source");
		String scriptTemp = "" + script;
		int httploc = scriptTemp.indexOf("http://animejoy.tv/video/one-piece/");
		int amploc = scriptTemp.indexOf("4", 23);
		String Link = scriptTemp.substring(httploc, amploc+1);
		return Link;
	}

	private static String getTitle(String url) throws IOException {
		String metadata = "1";
		Document document = Jsoup.connect(url).timeout(0).userAgent("Mozilla").get();
		Elements links = document.select("meta[name=description]");
		metadata = "" + links;
		Scanner tom = new Scanner(metadata);
		tom.next();
		tom.next();
		tom.next();
		metadata = tom.next() + " " + tom.next() + " " + tom.next()+ " " + tom.next();
		tom.close();
		return metadata;
	}

}