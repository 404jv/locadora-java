/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.MVC.Controllers;

import br.edu.ifpr.MVC.Entities.Rental;
import br.edu.ifpr.MVC.Models.RentalModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author julia
 */
@WebServlet(name = "ListRentalsController", urlPatterns = {"/bills"})
public class ListRentalsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RentalModel rentalModel = new RentalModel();

        ArrayList<Rental> rentals = rentalModel.getRentals();

        request.setAttribute("bills", rentals);
        request.getRequestDispatcher("bills.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("devolution").forward(request, response);
    }
}
