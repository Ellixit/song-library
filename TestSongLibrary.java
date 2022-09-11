public class TestSongLibrary {

	public static void main(String[] args) {
		
		Playlist p0 = new Playlist("Study Songs");
			Song s1 = new Song("Studying1", "ABC", "3:00");
			Song s2 = new Song("Studying2", "XYZ", "4:50");
			p0.addSong(s1);
			p0.addSong(new Song("Studying3", "CDE", "2:50"));
			p0.addSong(new Song("Studying4", "EFG", "3:25"));
		 
		Playlist p1 = new Playlist("Workout Songs");
			p1.addSong(new Song("Exercising1", "JKL", "3:00"));
			p1.addSong(new Song("Exercising2", "OPQRS", "2:50"));
			p1.addSong(new Song("Exercising3", "Wxyz", "4:35"));
			p1.addSong(new Song("Exercising3", "Stu", "3:25"));
		 
		User u0 = new User("user0");
		User u1 = new User("user1");
			SongLibrary.addUser(u0);
			SongLibrary.addUser(u1);
			        
		u0.addPlaylist(p0);
		u1.addPlaylist(p1);
		 
		System.out.println("ORIGINAL STUDY SONGS PLAYLIST BY USER0:");
		for(Playlist p : SongLibrary.getUserPlaylists(u0)) {
			System.out.println(p);
		}
		 
		System.out.println("ORIGINAL STUDY SONGS PLAYLIST BY USER1:");
		for(Playlist p : SongLibrary.getUserPlaylists(u1)) {
			System.out.println(p);
		}
		 
		u0.makeCollaborativePlaylist("Study Songs", u1);
		u0.getPlaylist("Study Songs").setTitle("Study Songs with "+u1.getUsername());
		u1.getPlaylist("Study Songs with "+u1.getUsername()).removeSong("Studying4");
		u1.getPlaylist("Study Songs with "+u1.getUsername()).addSong(s2);
		u1.getPlaylist("Study Songs with "+u1.getUsername()).swapSongs(s1, s2);
		u1.getPlaylist("Study Songs with "+u1.getUsername()).swapSongs(new Song("Does Not Exist", "In Playlist", "5:00"), s2);
		 
		System.out.println("UPDATED PLAYLISTS BY USER1:");
		for(Playlist p : SongLibrary.getUserPlaylists(u1)) {
			System.out.println(p);
		}
		 
		u0.getPlaylist("Study Songs with "+u1.getUsername()).sortSongs();
		u1.getPlaylist("Workout Songs").sortSongs();
		System.out.println("AFTER SORTING BOTH PLAYLISTS:");
		for(Playlist p : SongLibrary.getUserPlaylists(u1)) {
			System.out.println(p);
		}
	}

}