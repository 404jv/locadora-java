/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.MVC.Models;

import br.edu.ifpr.MVC.DAOs.ClientsDAO;
import br.edu.ifpr.MVC.DAOs.MoviesDAO;
import br.edu.ifpr.MVC.DAOs.RentalsDAO;
import br.edu.ifpr.MVC.Entities.Rental;
import br.edu.ifpr.MVC.Entities.Client;
import br.edu.ifpr.MVC.Entities.Movie;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joao
 */
public class RentalModel {
    public ArrayList<Rental> getRentals() {
        RentalsDAO rentalDAO = new RentalsDAO();

        try {
            return rentalDAO.selectAll();
        } catch (SQLException e) {
            Logger.getLogger(MovieModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public void create(String client_cpf, String movieName, String start_date, String end_date) throws Exception {
        RentalsDAO rentalDAO = new RentalsDAO();
        MoviesDAO moviesDAO = new MoviesDAO();
        ClientsDAO clientsDAO = new ClientsDAO();

        try {
            Movie movieExists = moviesDAO.findByTitle(movieName);

            if (movieExists == null) {
                throw new Exception("Filme não encontrado!");
            }

            Client clientExists = clientsDAO.findByCpf(client_cpf);

            if (clientExists == null) {
                throw new Exception("Cliente não encontrado!");
            }

            Rental rental = new Rental(clientExists.getId(), movieExists.getId(), start_date, end_date);

            rentalDAO.create(rental);
        } catch (SQLException e) {
            Logger.getLogger(MovieModel.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
