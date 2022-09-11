import java.util.ArrayList;

public class SongLibrary {

	private static ArrayList<User> users = new ArrayList<>();
	
	public SongLibrary() {															//Default constructor
	}
	
	public static void addUser(User input) {												//Adds user
		String inputName = input.getUsername();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().equals(inputName)) {
				return;
			}
		}
		users.add(input);
	}
	
	public static void removeUser(String inputName) {										//Removes user given input String
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().equals(inputName)) {
				users.remove(i);
				return;
			}
		}
	}
	public static void removeUser(User input) {											//Removes user given User object
		String inputName = input.getUsername();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().equals(inputName)) {
				users.remove(i);
				return;
			}
		}
	}
	
	public static ArrayList<Playlist> getUserPlaylists(String inputName) {								//Returns playlist of specified user given input String
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().equals(inputName)) {
				return users.get(i).getUserPlaylists();
			}
		}
		return null;
	}
	public static ArrayList<Playlist> getUserPlaylists(User input) {										//Returns playlist of a specified user given User object
		String inputName = input.getUsername();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().equals(inputName)) {
				return users.get(i).getUserPlaylists();
			}
		}
		return null;
	}
	
	public String toString() {														//Overrides toString 
		String userList = "";
		for (int i = 0; i < users.size(); i++) {
			userList += users.get(i).getUsername() + ", ";
		}
		return "SongLibrary: " + userList;
	}
	
}