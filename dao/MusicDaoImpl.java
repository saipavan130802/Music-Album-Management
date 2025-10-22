package com.codegnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.exceptions.ArtistNotFoundException;
import com.codegnan.model.Music;
import com.codegnan.util.DBConnectionUtil;

public class MusicDaoImpl implements MusicDao{

	@Override
	public void save(Music music) {
		String sql="insert into MusicAlbum(ArtistId,ArtistName,Album,Song,Language)values(?,?,?,?,?)";
		try(Connection con=DBConnectionUtil.getConnection();
				PreparedStatement pst=con.prepareStatement(sql)){
			 
			pst.setInt(1, music.getArtistId());
			pst.setString(2, music.getArtistName());
			pst.setString(3,music.getAlbum());
			pst.setString(4, music.getSong());
			pst.setString(5, music.getLanguage());
			
			pst.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Album Not Created"+e.getMessage());
		}
		
	}

	@Override
	public List<Music> findAll() {
		List <Music> list=new ArrayList();
		String sql="select * from MusicAlbum";
		try(Connection con=DBConnectionUtil.getConnection();
				PreparedStatement pst=con.prepareStatement(sql)){
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				list.add(new Music(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
	}catch(SQLException e) {
		System.out.println("Fetch all records failed"+e.getMessage());
	}
		return list;
	}

	@Override
	public Music findById(int ArtistId) throws ArtistNotFoundException {
		String sql="select * from MusicAlbum where ArtistId=?";
		try(Connection con=DBConnectionUtil.getConnection();
				PreparedStatement pst=con.prepareStatement(sql)){
			pst.setInt(1, ArtistId);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
			return new Music(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
			else {
				 throw new ArtistNotFoundException("ArtistId Not Found"+ArtistId);
			}
	}catch(SQLException e) {
		System.out.println("Database Error"+e.getMessage());
		throw new ArtistNotFoundException("Database error while finding ArtistId " + ArtistId);
	}
	}

	@Override
	public void Update(Music music) throws ArtistNotFoundException {
		String sql="update MusicAlbum set ArtistName=?, Album=?, Song=?,Language=? where ArtistId=?";
		try(Connection con=DBConnectionUtil.getConnection();
				PreparedStatement pst=con.prepareStatement(sql)){
			pst.setString(1, music.getArtistName());
			pst.setString(2, music.getAlbum());
			pst.setString(3, music.getSong());
			pst.setString(4, music.getLanguage());
			pst.setInt(5, music.getArtistId());
			
			int rowsEffected=pst.executeUpdate();
			if(rowsEffected==0) {
				throw new ArtistNotFoundException("Artist Id not Found "+music.getArtistId());
			}
			else {
				System.out.println("Music Album Updated "+music);
			}
		}catch(SQLException e) {
			System.out.println("Updation Failed of ArtistId "+e.getMessage());
		}
		
	}

	@Override
	public void deleteById(int ArtistId) throws ArtistNotFoundException {
		String sql="delete from MusicAlbum where ArtistId=?";
		try(Connection con=DBConnectionUtil.getConnection();
				PreparedStatement pst=con.prepareStatement(sql)){
			pst.setInt(1, ArtistId);
			int rowsEffected=pst.executeUpdate();
			if(rowsEffected==0) {
				throw new ArtistNotFoundException("Artist Id not Found "+ArtistId);
			}
			else {
				System.out.println("Music Album Deleted of ArtistId "+ArtistId);
			}
			
		}catch(SQLException e) {
			System.out.println("Deletion Failed of ArtistId "+ArtistId);
		}
		
	}

}
