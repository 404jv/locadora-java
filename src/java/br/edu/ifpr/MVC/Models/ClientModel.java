/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.MVC.Models;

import br.edu.ifpr.MVC.DAOs.ClientsDAO;
import br.edu.ifpr.MVC.Entities.Client;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julia
 */
public class ClientModel {
    public void create(Client client) throws Exception {
        ClientsDAO clientsDAO = new ClientsDAO();

        try {
            Client clientAlreadyExists = clientsDAO.findByCpf(client.getCpf());
       
            if (clientAlreadyExists != null) {
                throw new Exception("Cliente com o CPF " + client.getCpf() + " já existe!");
            }

            clientsDAO.create(client);
        } catch (SQLException e) {
            Logger.getLogger(ClientModel.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
