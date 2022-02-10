package br.edu.ifpr.MVC.DAOs;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import br.edu.ifpr.MVC.Entities.Movie;
import br.edu.ifpr.MVC.Factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author julia
 */
public class MoviesDAO {
    public void create(Movie movie) throws SQLException {
        String sql = "INSERT INTO MOVIES (TITLE, RATE, DURATION, FINE_AMOUNT, DAILY_RATE, IMAGE_URL) "
            + "VALUES (?, ?, ?, ?, ?, ?)";


        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement query = connection.prepareStatement(sql);

        query.setString(1, movie.getTitle());
        query.setInt(2, movie.getRate());
        query.setString(3, movie.getDuration());
        query.setFloat(4, movie.getFine_amount());
        query.setFloat(5, movie.getDaily_rate());
        query.setString(6, movie.getImage_url());

        query.execute();
        query.close();
        connection.close();
    }

    public ArrayList<Movie> selectAll() throws SQLException {
        ArrayList<Movie> movies = new ArrayList();
    
        String sql = "SELECT * FROM MOVIES";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement query = connection.prepareStatement(sql);
        
        ResultSet result = query.executeQuery();
        
        while(result.next()) {
            Movie movie = new Movie();
            movie.setId(result.getInt("ID"));
            movie.setTitle(result.getString("title"));
            movie.setRate(result.getInt("rate"));
            movie.setDuration(result.getString("duration"));
            movie.setFine_amount(result.getFloat("fine_amount"));
            movie.setImage_url(result.getString("image_url"));
            movies.add(movie);
        }
        
        query.close();
        connection.close();
        
        return movies;
    }

    public Movie findByTitle(String title) throws SQLException {
        Movie movie = null;
        
        String sql = "SELECT * FROM MOVIES WHERE TITLE = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, title);
        
        ResultSet result = stmt.executeQuery();
        
        while(result.next()) {
            movie = new Movie();
            movie.setId(result.getInt("ID"));
            movie.setTitle(result.getString("TITLE"));
            movie.setDuration(result.getString("DURATION"));
            movie.setFine_amount(result.getFloat("FINE_AMOUNT"));
            movie.setImage_url(result.getString("IMAGE_URL"));
            movie.setRate(result.getInt("RATE"));
        }
        
        return movie;
    }
}
