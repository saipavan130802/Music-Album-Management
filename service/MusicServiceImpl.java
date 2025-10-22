package com.codegnan.service;

import java.util.List;

import com.codegnan.dao.MusicDao;
import com.codegnan.dao.MusicDaoImpl;
import com.codegnan.exceptions.ArtistNotFoundException;
import com.codegnan.model.Music;

public class MusicServiceImpl implements MusicService{

	MusicDao dao=new MusicDaoImpl();
	@Override
	public void addAlbum(Music music) {
		dao.save(music);
		
	}

	@Override
	public List<Music> getAllAlbums() {
		return dao.findAll();
	}

	@Override
	public Music getAlbumByArtistId(int ArtistId) throws ArtistNotFoundException {
		return dao.findById(ArtistId);
	}

	@Override
	public void updateAlbum(Music music) throws ArtistNotFoundException {
		dao.Update(music);
		
	}

	@Override
	public void deleteAlbumByArtistId(int ArtistId) throws ArtistNotFoundException {
		dao.deleteById(ArtistId);
	}

}
