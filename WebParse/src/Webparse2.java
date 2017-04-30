import java.io.*;
import java.net.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

import javax.script.ScriptException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Webparse2 {
	public static void main(String[] args) throws Exception {
		for (int i = 1; i < 10; i++) {
			String url = "http://kissanime.com/Anime/One-Piece/Episode-00"
					+ i;
			String name = getTitle(url);
			String downloadURLUni = getURL(url);
			String downloadUrlConverted = convertUni(downloadURLUni);
			Print(name);
			Print("");
			Print(downloadUrlConverted);
			download(downloadUrlConverted, name);
			Print("");

		}
		for (int i = 10; i < 100; i++) {
			String url = "http://kissanime.com/Anime/One-Piece/Episode-0"
					+ i;
			String name = getTitle(url);
			String downloadURLUni = getURL(url);
			String downloadUrlConverted = convertUni(downloadURLUni);
			Print(name);
			Print("");
			Print(downloadUrlConverted);
			download(downloadUrlConverted, name);
			Print("");
		}
		for (int i = 100; i < 678; i++) {
			String url = "http://kissanime.com/Anime/One-Piece/Episode-"
					+ i;
			String name = getTitle(url);
			String downloadURLUni = getURL(url);
			String downloadUrlConverted = convertUni(downloadURLUni);
			Print(name);
			Print("");
			Print(downloadUrlConverted);
			download(downloadUrlConverted, name);
			Print("");
		}
	}

	private static void download(String url, String name) throws IOException {
		String location = "C:\\Shows\\One\\";
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
		Document document = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36").timeout(10000).followRedirects(true).get();
		Elements script = document.getElementsByTag("script");
		String scriptTemp = "" + script;
		int httploc = scriptTemp
				.indexOf("https%3a%2f%2fredirector.googlevideo.com");
		int amploc = scriptTemp.indexOf("&amp;video");
		String Link = scriptTemp.substring(httploc, amploc);
		return Link;
	}

	private static String getTitle(String url) throws IOException {
		String metadata = "1";
		Document document = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36").timeout(10000).followRedirects(true).get();
		Elements links = document.select("meta[itemprop=description]");
		metadata = "" + links;
		Scanner tom = new Scanner(metadata);
		tom.next();
		tom.next();
		tom.next();
		metadata = tom.next() + " " + tom.next() + " " + tom.next() + " "
				+ tom.next() + " " + tom.next();
		tom.close();
		return metadata;
	}

}