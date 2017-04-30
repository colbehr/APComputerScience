/*
 * @author Colbehr
 * Playlist
 */

public class Song {
	private String Song = "N/a";
	private String Artist = "N/a";
	private String Genre = "N/a";
	private String Album = "N/a";
	private int Duration = 0;

	public Song() {
		this("", "", "", "", 0);
	}

	public Song(String inSong, String inArtist, String inGenre, String inAlbum,
			int inDuration) {
		Song = inSong;
		Artist = inArtist;
		Genre = inGenre;
		Album = inAlbum;
		Duration = inDuration;
	}

	public String getSong() {
		return Song;
	}

	public void setSong(String inSong) {
		Song = inSong;
	}

	public String getArtist() {
		return Artist;
	}

	public void setArtist(String inArtist) {
		Artist = inArtist;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String inGenre) {
		Genre = inGenre;
	}

	public String getAlbum() {
		return Album;
	}

	public void setAlbum(String inAlbum) {
		Album = inAlbum;
	}

	public int getDuration() {
		return Duration;
	}

	public void setDuration(int inDuration) {
		if (inDuration >= 0) {
			Duration = inDuration;
		}
	}

	public String durationToMinutes() {
		final int Sixty = 60;
		int seconds = Duration % Sixty;
		int totalMinutes = Duration / Sixty;
		int minutes = totalMinutes % Sixty;
		return minutes + ":" + seconds;
	}

	public String toString() {
		return Song + " | " + durationToMinutes();

	}
}
