package com.codegnan.controller;

import java.util.List;

import com.codegnan.exceptions.ArtistNotFoundException;
import com.codegnan.model.Music;
import com.codegnan.service.MusicService;
import com.codegnan.service.MusicServiceImpl;

public class MusicAlbumApp {
	public static void main(String[] args) {
		MusicService service=new MusicServiceImpl();
		service.addAlbum(new Music(1, "A.R. Rahman", "Rockstar", "Kun Faya Kun", "Hindi"));
        service.addAlbum(new Music(2, "Arijit Singh", "Soulful Melodies", "Tum Hi Ho", "Hindi"));
        service.addAlbum(new Music(3, "Anirudh Ravichander", "Leo", "Naa Ready", "Tamil"));
        service.addAlbum(new Music(4, "Sid Sriram", "Hits Collection", "Srivalli", "Telugu"));
        service.addAlbum(new Music(5, "Shreya Ghoshal", "Melodious Moments", "Teri Meri", "Hindi"));
		
        System.out.println("Music Saved Successfully in the database");
		
		//Get all the details
		
		System.out.println("ArtistId\tArtistName\tAlbum\tSong\tLanguage");
		System.out.println("------------------------------------------------------------------------------");
		List<Music> AllAlbums=service.getAllAlbums();
		for(Music all:AllAlbums) {
			System.out.println(all);
		}
		
		
		//Fetching Particular Music Album
		
		System.out.println("Fetch MusicAlbum with ArtistId 3");
     	try {
		Music fetchMusic=service.getAlbumByArtistId(3);
			System.out.println("Music Album Found: "+fetchMusic);
		}
		catch(ArtistNotFoundException e) {
			e.printStackTrace();
		}
		
		//Update Music Album 
		
		System.out.println("Update Music Album with ArtistId 5");
		try {
			service.updateAlbum(new Music(5,"Shreya","Melodious Moments", "Teri Meri", "Hindi"));
			System.out.println("Music Album Updated Successfully");
		}catch(ArtistNotFoundException e){
			e.printStackTrace();
		}
		
		//Delete Music By ArtistId
		try {
			service.deleteAlbumByArtistId(3);
			System.out.println("Music Album Deleted Successfully");
		}catch(ArtistNotFoundException e){
			e.printStackTrace();
		}
	}

}
