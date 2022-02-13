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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julia
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

            Rental rental = new Rental(
                clientExists.getId(), 
                movieExists.getId(), 
                start_date, 
                end_date
            );

            rentalDAO.create(rental);
        } catch (SQLException e) {
            Logger.getLogger(MovieModel.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void devolution(String rental_id, String endDateString) throws Exception {
        RentalsDAO rentalDAO = new RentalsDAO();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int MINIMUM_DAY = 1;
        String DELIVERED_STATUS = "entregue";

        try {
            Rental rental = rentalDAO.findById(rental_id);

            if (rental == null) {
               throw new Exception("Aluguel não encontrado!");
            }

            if (DELIVERED_STATUS.equals(rental.getStatus())) {
               throw new Exception("Esse aluguel já foi pago!");
            }


            Date endDate = dateFormat.parse(endDateString);
            Date startDate = dateFormat.parse(rental.getStart_date());
            Date dateNow = this.formatDate(new Date());

            int totalUsedDays = this.compareInDays(startDate, dateNow);
              
            if (totalUsedDays <= 0) {
               totalUsedDays = MINIMUM_DAY;
            }

            int totalDelayDays = this.compareInDays(dateNow, endDate);

            float totalToPay = 0;

            if (totalDelayDays > 0) {
               float calculateFine = totalDelayDays * rental.getFine_amount();
               totalToPay = calculateFine;
            }

            totalToPay += totalUsedDays * rental.getDaily_rate();
         
            String dateNowString = dateFormat.format(dateNow);

            rental.setTotal(totalToPay);
            rental.setEnd_date(dateNowString);
            rental.setStatus("entregue");

            rentalDAO.update(rental);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private int compareInDays(Date start_date, Date end_date) {
        long diff = end_date.getTime()- start_date.getTime();

        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    private Date formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
       
        String stringDate = dateFormat.format(date);
        
        try {
            Date formatedDate = dateFormat.parse(stringDate);

            return formatedDate;
        } catch (Exception e) {
            Logger.getLogger(MovieModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
