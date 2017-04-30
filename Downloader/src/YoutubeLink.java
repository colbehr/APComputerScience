import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class YoutubeLink extends Link {
	String ID;

	public YoutubeLink(String URL) {
		super(URL);
	}

	public ArrayList<String> getDownloadURL(String url) throws IOException {
		Println("Youtube ID = " + extractID(URL));
		String IDInfo = "http://www.youtube.com/get_video_info?video_id=" + ID + "&t=" + "vjVQa1PpcFN0p2rxQH4jdW4ZuQRsUZ6CrmB6N3AQhXk%3D" + "&asv=18";
		Println("ID info = " + IDInfo);
		Document doc = null;
		doc = Jsoup.connect(IDInfo).ignoreContentType(true).get();
		String html = doc + "";
		String decoded = html;
		Print(html);
		decoded = decoded.substring(30, decoded.length()-16);
		decoded = decoded.replace("url%3D", "\n");
		decoded = java.net.URLDecoder.decode(decoded, "UTF-8");
//		decoded = decoded.replace("&,", "");
		Println(decoded);
		ArrayList<String> list = new ArrayList<String>();
		return list;
	}

	public String extractID(String inURL) {
		int v = inURL.indexOf("?v=");
		setID(inURL.substring(v + 3, v + 14));
		return ID;
	}

	public String getID() {
		return ID;
	}

	public void setID(String inID) {
		ID = inID;
	}

}