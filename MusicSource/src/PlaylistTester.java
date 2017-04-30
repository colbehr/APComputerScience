/*
 * @author Colbehr
 * Playlist
 */

public class PlaylistTester {
	public static void main(String[] args) {
		PlayList List = new PlayList();
		Song title1 = new Song("Title1","Artist1","Genre1","Album1", 1 );
		Song title2 = new Song("Title2","Artist2","Genre2","Album2", 2 );
		Song title3 = new Song("Title3","Artist3","Genre3","Album3", 3 );
		List.add(title1);
		List.add(title2);
		List.add(title3);
		System.out.println("This playlist contains " + List.count() + " songs " + List.toString());
		List.clear();
		System.out.println("This playlist contains " + List.count() + " songs " + List.toString());
	}

}
