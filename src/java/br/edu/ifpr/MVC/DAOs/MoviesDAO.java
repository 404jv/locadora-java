package br.edu.ifpr.MVC.DAOs;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import br.edu.ifpr.MVC.Entities.Movie;
import br.edu.ifpr.MVC.Factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author julia
 */
public class MoviesDAO {
    public void create(Movie movie) throws SQLException {
        String sql = "INSERT INTO MOVIES (TITLE, RATE, DURATION, FINE_AMOUNT, IMAGE_URL) "
            + "VALUES (?, ?, ?, ?, ?, ?)";


        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement query = connection.prepareStatement(sql);

        query.setString(1, movie.getTitle());
        query.setInt(2, movie.getRate());
        query.setString(3, movie.getDuration());
        query.setFloat(4, movie.getFine_amount());
        query.setString(5, movie.getImage_url());

        query.execute();
        query.close();
        connection.close();
    }
}
