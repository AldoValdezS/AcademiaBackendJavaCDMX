package com.valdez.amazonviewer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.aldo.amazonviewer.db.IDBConnection;
import com.anncode.amazonviewer.model.Movie;
import static com.aldo.amazonviewer.db.DataBase.*;

public interface MovieDAO extends IDBConnection{
	
	default Movie setMovieViewed(Movie movie) {
		 Date date = new Date();
		 DateFormat  formatDate  = new SimpleDateFormat("yyyy-MM-dd");
		 String fecha = formatDate.format(date);
	
		try(Connection connection = connecToDB()) {
			Statement statement = connection.createStatement();
			String query ="INSERT INTO "+TVIEWED+
					"("+ TVIEWED_IDMATERIAL+", "+TVIEWED_IDELEMENT +", "+TVIEWED_IDUSER+", "+TVIEWED_DATE+")"+
					" VALUES ("+ID_TMATERIALS[0]+", " +  movie.getId() + ", " + TUSER_ID + ", '" + fecha + "')";
			if(statement.executeUpdate(query)>0) {
				System.out.println("Se marcó en Visto");
			}else {
				System.out.println("Problema en la consulta");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return movie;
	}
	default ArrayList<Movie> read(){
		ArrayList<Movie> movies = new ArrayList();
		try (Connection connection = connecToDB()){
			
			String query = "SELECT * FROM "+TMOVIE;
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Movie movie = new Movie(
						rs.getString(TMOVIE_TITLE), 
						rs.getString(TMOVIE_GENRE), 
						rs.getString(TMOVIE_CREATOR), 
						Integer.valueOf(rs.getString(TMOVIE_DURATION)), 
						Short.valueOf(rs.getString(TMOVIE_YEAR)));
				movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));
				movie.setViewed(getMovieViewed(
						preparedStatement, 
						connection, 
						Integer.valueOf(rs.getString(TMOVIE_ID))));
				movies.add(movie);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return movies;
 	}
	private boolean getMovieViewed(PreparedStatement preparedStatement, Connection connection, int id_movie) {
		
		boolean viewed = false;
		String query = "SELECT * FROM "+ TVIEWED +
				" WHERE " + TVIEWED_IDMATERIAL +" = ? " +
				" AND " + TVIEWED_IDELEMENT + " = ?" +
				" AND " + TVIEWED_IDUSER + "= ?";
		ResultSet rs = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, ID_TMATERIALS[0]); 
			preparedStatement.setInt(2, id_movie); 
			preparedStatement.setInt(3, TUSER_ID); 
			rs = preparedStatement.executeQuery();
			viewed = rs.next();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return viewed; 
	}
	
	default ArrayList<Movie> moviesDate(String date) {
		
		ArrayList<Movie> movies = new ArrayList<Movie>();
		String query = "SELECT * FROM "+ TVIEWED +", "+ TMOVIE+
				" WHERE " + TMOVIE+"."+TMOVIE_ID +" = "+ TVIEWED+"."+TVIEWED_IDELEMENT +
				" AND " + TVIEWED+"."+TVIEWED_IDUSER +" = "+TUSER_ID +
				" AND " + TVIEWED_DATE + " = '" + date +"'";		
		try(Connection connection = connecToDB()) {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Movie movie = new Movie(
						rs.getString(TMOVIE_TITLE),
						rs.getString(TMOVIE_GENRE), 
						rs.getString(TMOVIE_CREATOR),
						Integer.valueOf(rs.getString(TMOVIE_DURATION)), 
						Short.valueOf(rs.getString(TMOVIE_YEAR)));
						movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));						
				movies.add(movie);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies; 
	}
	

}
