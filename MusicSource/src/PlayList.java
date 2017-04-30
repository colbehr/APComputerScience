/*
 * @author Colbehr
 * Playlist
 */

import java.util.ArrayList;

public class PlayList {

	static ArrayList<Song> Playlist = new ArrayList<Song>();

	public void add(Song inSong) {
		Playlist.add(inSong);
	}

	public int count() {
		return Playlist.size();
	}

	public String[] getSongTitles() {
		return null; //:(
	}

	public void clear() {
		Playlist.clear();
	}

	public String toString() {
		return Playlist.toString();
	}

}
