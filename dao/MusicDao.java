package com.codegnan.dao;

import java.util.List;

import com.codegnan.exceptions.ArtistNotFoundException;
import com.codegnan.model.Music;

public interface MusicDao {
	void save(Music music);
	List<Music>findAll();
	Music findById(int ArtistId) throws ArtistNotFoundException;
	void Update(Music music) throws ArtistNotFoundException;
	void deleteById(int ArtistId) throws ArtistNotFoundException;
	
}
