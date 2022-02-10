/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.MVC.DAOs;

import br.edu.ifpr.MVC.Entities.Client;
import br.edu.ifpr.MVC.Factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author julia
 */
public class ClientsDAO {
    
    public void create(Client client) throws SQLException {
        String sql = "INSERT INTO CLIENTS (NAME, ADDRESS, DISTRICT, PHONE, CPF) "
            + "VALUES (?, ?, ?, ?, ?)";


        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement query = connection.prepareStatement(sql);

        query.setString(1, client.getName());
        query.setString(2, client.getAddress());
        query.setString(3, client.getDistrict());
        query.setString(4, client.getPhone());
        query.setString(5, client.getCpf());

        query.execute();
        query.close();
        connection.close();
    }

    public Client findByCpf(String cpf) throws SQLException {
        Client client = null;
        
        String sql = "SELECT * FROM CLIENTS WHERE CPF = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, cpf);
        
        ResultSet result = stmt.executeQuery();
        
        while(result.next()) {
            client = new Client();
            client.setId(result.getInt("ID"));
            client.setName(result.getString("NAME"));
            client.setAddress(result.getString("ADDRESS"));
            client.setCpf(result.getString("CPF"));
            client.setDistrict(result.getString("DISTRICT"));
            client.setPhone(result.getString("PHONE"));

        }
        
        return client;
    }
}
