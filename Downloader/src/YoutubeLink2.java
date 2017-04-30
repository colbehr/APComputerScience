import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class YoutubeLink2 extends Link {
	String ID;
	

	public YoutubeLink2(String URL) {
		super(URL);
	}

	public ArrayList<String> getDownloadURL(String url) throws IOException {
		Document doc = Jsoup.connect("http://www.h3xed.com/blogmedia/youtube-info.php")
				.data("ytdurl", url)
				.userAgent("Mozilla").post();
		Elements links = doc.select("a[href]");
		String html = links + "";
//		html = html.replace("amp;", ""); 
		html = html.replace("<a href=\"", ""); 
		html = html.replace("\">URL</a>", ""); 
		html = java.net.URLDecoder.decode(html, "UTF-8");
		Print(html);
		ArrayList<String> list = new ArrayList<String>();
		Scanner scanner = new Scanner(html);
		scanner.useDelimiter("\n");
		while(scanner.hasNext()){
			list.add(scanner.next());
		}
		Println(list.toString());
		scanner.close();
		return list;
	}

	public String getID() {
		return ID;
	}

	public void setID(String inID) {
		ID = inID;
	}

}