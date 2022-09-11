import java.util.ArrayList;

public class User {

	private String userName;
	private ArrayList<Playlist> playlists = new ArrayList<>();
	
	public User() {																		//Default constructor
	}
	public User(String userName) {														//Constructor with username parameter
		this.userName = userName;
	}
	
	public String getUsername() {														//Username accessor
		return userName;
	}
	public void setUserName(String userName) {											//Username mutator
		this.userName = userName;
	}
	
	public void addPlaylist(Playlist input) {											//Adds Playlist given Playlist object
		String inputName = input.getPlaylistTitle();
		for (int i = 0; i < playlists.size(); i++) {
			if (playlists.get(i).getPlaylistTitle().equals(inputName)) {
				return;
			}
		}
		playlists.add(input);
	}
	
	public void removePlaylist(String inputName) {										//Removes Playlist given input String
		for (int i = 0; i < playlists.size(); i++) {
			if (playlists.get(i).getPlaylistTitle().equals(inputName)) {
				playlists.remove(i);
				return;
			}
		}
	}
	
	public ArrayList<Playlist> getUserPlaylists() {												//Returns all playlists of User instance
		return this.playlists;
	}
	
	public Playlist getPlaylist(String inputName) {										//Returns Playlist with specified title String
		for (int i = 0; i < playlists.size(); i++) {
			if (playlists.get(i).getPlaylistTitle().equals(inputName)) {
				return playlists.get(i);
			}
		}
		return null;
	}
	
	public void makeCollaborativePlaylist(String playlistTitle, User friend) {			//Adds playlist to playlists of specified user
		int playlistIndex = 0;
		boolean exists = false;
		for (int i = 0; i < playlists.size(); i++) {
			if (playlists.get(i).getPlaylistTitle().equals(playlistTitle)) {
				playlistIndex = i;
				exists = true;
				break;
			}
		}
		if (exists) {
			friend.playlists.add(playlists.get(playlistIndex));
		}
	}
	
	public String toString() {															//Overrides toString
		String playlistNames = "";
		for (int i = 0; i < playlists.size(); i++) {
			playlistNames += playlists.get(i).getPlaylistTitle() + ", ";
		}
		return "User " + this.userName + ": " + playlistNames;
	}
}