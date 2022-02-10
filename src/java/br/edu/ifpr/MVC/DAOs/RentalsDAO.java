/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.MVC.DAOs;

import br.edu.ifpr.MVC.Entities.Rental;
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
public class RentalsDAO {
    public void create(Rental rental) throws SQLException {
        String sql = "INSERT INTO RENTALS (CLIENT_ID, MOVIE_ID, START_DATE, END_DATE) "
            + "VALUES (?, ?, ?, ?)";

        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement query = connection.prepareStatement(sql);

        query.setInt(1, rental.getClient_id());
        query.setInt(2, rental.getMovie_id());
        query.setString(3, rental.getStart_date());
        query.setString(4, rental.getEnd_date());

        query.execute();
        query.close();
        connection.close();
    }

    public ArrayList<Rental> selectAll() throws SQLException {
        ArrayList<Rental> rentals = new ArrayList();
    
        String sql = "SELECT * FROM RENTALS"
 +          " JOIN CLIENTS ON RENTALS.CLIENT_ID = CLIENTS.ID JOIN MOVIES ON RENTALS.MOVIE_ID = MOVIES.ID";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement query = connection.prepareStatement(sql);
        
        ResultSet result = query.executeQuery();
        
        while(result.next()) {
            Rental rental = new Rental();
            rental.setId(result.getInt("ID"));
            rental.setClient_id(result.getInt("client_id"));
            rental.setMovie_id(result.getInt("movie_id"));
            rental.setStart_date(result.getString("start_date"));
            rental.setEnd_date(result.getString("end_date"));
            rental.setStatus(result.getString("status"));
            rental.setTotal(result.getFloat("total"));
           
            rental.setClient_name(result.getString("NAME"));
            rental.setDaily_rate(result.getFloat("DAILY_RATE"));
            rental.setMovie_title(result.getString("TITLE"));
            rentals.add(rental);
        }
        
        query.close();
        connection.close();
        
        return rentals;
    }
}
