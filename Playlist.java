import java.util.ArrayList;

public class Playlist {

	private String playlistTitle;
	private ArrayList<Song> songs = new ArrayList<>();
	
	public Playlist() {																	//Default constructor
	}
	public Playlist (String playlistTitle) {											//Constructor with playlistTitle parameter
		this.playlistTitle = playlistTitle;
	}
	
	public String getPlaylistTitle() {													//PlaylistTitle accessor
		return playlistTitle;
	}
	public void setTitle(String playlistTitle) {								//PlaylistTitle mutator
		this.playlistTitle = playlistTitle;
	}
	
	public void addSong(Song input) {													//Adds Song given Song object
		songs.add(input);
	}
	
	public void removeSong(String inputName) {											//Removes Song given Song title
		for (int i = 0; i < songs.size(); i++) {
			if (songs.get(i).getSongName().equals(inputName)) {
				songs.remove(i);
				return;
			}
		}
	}
		
	public void swapSongs(Song song1, Song song2) {										//Swaps the positions of two songs
		String song1Name = song1.getSongName();
		String song2Name = song2.getSongName();
		Song temp1 = null;
		Song temp2 = null;
		int song1Index = 0;
		int song2Index = 0;
		boolean song1Exists = false;
		boolean song2Exists = false;
		for (int i = 0; i < songs.size(); i++) {
			if (songs.get(i).getSongName().equals(song1Name)) {
				temp1 = (Song)songs.get(i).clone();
				song1Index = i;
				song1Exists = true;
			}
			if (songs.get(i).getSongName().equals(song2Name)) {
				temp2 = (Song)songs.get(i).clone();
				song2Index = i;
				song2Exists = true;
			}
		}
		if (song1Exists && song2Exists) {
			songs.set(song1Index, temp2);
			songs.set(song2Index, temp1);
		}
	}
	
	public String getTotalTime() {															//Calculates total time of playlist	
		int totalMinutes = 0;
		int totalSeconds = 0;
		String[] timeArray = new String[2];			
		for (int i = 0; i < songs.size(); i++) {
			timeArray = songs.get(i).getDuration().split(":");
			totalMinutes += Integer.parseInt(timeArray[0]);
			totalSeconds += Integer.parseInt(timeArray[1]);
		}
		totalMinutes += (totalSeconds / 60);
		totalSeconds = (totalSeconds % 60);
		return (totalMinutes + " min, " + totalSeconds + " sec");
	}
	
	public void sortSongs() {														//Sorts the playlist
		boolean sorted = false;
		Song temp = new Song();
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < songs.size()-1; i++) {
				if (songs.get(i).compareTo(songs.get(i+1)) > 0) {
					temp = songs.get(i);
					songs.set(i, songs.get(i+1));
					songs.set(i+1, temp);
					sorted = false;
				}
			}
		}
	}
	
	public String toString() {															//Overrides toString
		String songList = "";
		for (int i = 0; i < songs.size(); i++) {
			songList += (i + 1) + ". " + songs.get(i).toString() + "\n";
		}
		return this.getPlaylistTitle() + " - " + this.getTotalTime() + "\n" + songList; 
	}
	
}