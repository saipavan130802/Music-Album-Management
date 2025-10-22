package com.codegnan.controller;

import java.util.List;
import java.util.Scanner;

import com.codegnan.exceptions.ArtistNotFoundException;
import com.codegnan.model.Music;
import com.codegnan.service.MusicService;
import com.codegnan.service.MusicServiceImpl;

public class MusicAlbumApp {

    public static void main(String[] args) {
        MusicService service = new MusicServiceImpl();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n================ MUSIC ALBUM MANAGEMENT SYSTEM ================");
            System.out.println("1. Add Music Album");
            System.out.println("2. View All Music Albums");
            System.out.println("3. View Album by Artist ID");
            System.out.println("4. Update Album");
            System.out.println("5. Delete Album");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Artist ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Artist Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Album Name: ");
                    String album = sc.nextLine();
                    System.out.print("Enter Song Name: ");
                    String song = sc.nextLine();
                    System.out.print("Enter Language: ");
                    String lang = sc.nextLine();

                    service.addAlbum(new Music(id, name, album, song, lang));
                    System.out.println("Music Album Added Successfully!");
                    break;

                case 2:
                    System.out.println("\nArtistId\tArtistName\tAlbum\tSong\tLanguage");
                    System.out.println("------------------------------------------------------------------");
                    List<Music> allAlbums = service.getAllAlbums();
                    for (Music all: allAlbums) {
                        System.out.println(all);
                    }
                    break;

                case 3:
                    System.out.print("Enter Artist ID to fetch: ");
                    int fetchId = sc.nextInt();
                    try {
                        Music music = service.getAlbumByArtistId(fetchId);
                        System.out.println("Music Album Found: " + music);
                    } catch (ArtistNotFoundException e) {
                        System.out.println("Artist Not Found with ID: " + fetchId);
                    }
                    break;

                case 4:
                    System.out.print("Enter Artist ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Artist Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Album Name: ");
                    String newAlbum = sc.nextLine();
                    System.out.print("Enter New Song Name: ");
                    String newSong = sc.nextLine();
                    System.out.print("Enter New Language: ");
                    String newLang = sc.nextLine();
                    try {
                        service.updateAlbum(new Music(updateId, newName, newAlbum, newSong, newLang));
                        System.out.println("Music Album Updated Successfully!");
                    } catch (ArtistNotFoundException e) {
                        System.out.println("Artist Not Found with ID: " + updateId);
                    }
                    break;

                case 5:
                    System.out.print("Enter Artist ID to delete: ");
                    int deleteId = sc.nextInt();
                    try {
                        service.deleteAlbumByArtistId(deleteId);
                        System.out.println("Music Album Deleted Successfully!");
                    } catch (ArtistNotFoundException e) {
                        System.out.println("Artist Not Found with ID: " + deleteId);
                    }
                    break;

                case 6:
                    System.out.println("Exiting Music Album Management System");
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid option");
            }

        } while (choice != 6);

        sc.close();
    }
}
