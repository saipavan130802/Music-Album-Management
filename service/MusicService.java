package com.codegnan.service;

import java.util.List;

import com.codegnan.exceptions.ArtistNotFoundException;
import com.codegnan.model.Music;

public interface MusicService {
	
	void addAlbum(Music music);
	List<Music> getAllAlbums();
	Music getAlbumByArtistId(int ArtistId)throws ArtistNotFoundException;
	void updateAlbum(Music music)throws ArtistNotFoundException;
	void deleteAlbumByArtistId(int ArtistId)throws ArtistNotFoundException;
	
	
}
