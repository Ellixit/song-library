public class Song {

	private String songName;
	private String artistName;
	private String duration;
	
	public Song() {
	}
	public Song(String songName, String artistName, String duration) {
		this.songName = songName;
		this.artistName = artistName;
		this.duration = duration;
	}
	
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public int compareTo(Song input) {
		int finalResult = 0;
		String inputString;
		String thisString;
		if (this.getSongName().equals(input.getSongName())) {
			inputString = input.getArtistName().toLowerCase();
			thisString = this.getArtistName().toLowerCase();
			finalResult = thisString.compareTo(inputString);
			return finalResult;
		} else {
			inputString = input.getSongName().toLowerCase();
			thisString= this.getSongName().toLowerCase();
			finalResult = thisString.compareTo(inputString);
			return finalResult;
		}
	}
	
	public Object clone() {
		Song clone = new Song(this.songName, this.artistName, this.duration);
		return clone;
	}
	
	public String toString() {
		return this.getSongName() + " by " + this.getArtistName() + " (" + this.getDuration() + ")";
	}
	
}