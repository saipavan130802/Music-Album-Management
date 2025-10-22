package com.codegnan.model;

public class Music {
	private int ArtistId;
	private String ArtistName;
	private String Album;
	private String Song;
	private String Language;
	public Music() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Music(int artistId, String artistName, String album, String song, String language) {
		super();
		ArtistId = artistId;
		ArtistName = artistName;
		Album = album;
		Song = song;
		Language = language;
	}
	public int getArtistId() {
		return ArtistId;
	}
	public void setArtistId(int artistId) {
		ArtistId = artistId;
	}
	public String getArtistName() {
		return ArtistName;
	}
	public void setArtistName(String artistName) {
		ArtistName = artistName;
	}
	public String getAlbum() {
		return Album;
	}
	public void setAlbum(String album) {
		Album = album;
	}
	public String getSong() {
		return Song;
	}
	public void setSong(String song) {
		Song = song;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	@Override
	public String toString() {
		return "Music [ArtistId=" + ArtistId + ", ArtistName=" + ArtistName + ", Album=" + Album + ", Song=" + Song
				+ ", Language=" + Language + "]";
	}
	
}
