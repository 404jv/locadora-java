/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.MVC.Controllers;

import br.edu.ifpr.MVC.Entities.Movie;
import br.edu.ifpr.MVC.Models.MovieModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author julia
 */
@WebServlet(name = "CreateMovieController", urlPatterns = {"/movies"})
public class CreateMovieController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        request.getRequestDispatcher("create-movie.jsp")
                .forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");


        String title = request.getParameter("title");
        int rate = Integer.parseInt(request.getParameter("rate"));
        String duration = request.getParameter("duration");
        float fine_amount = Float.parseFloat(request.getParameter("fine_amount"));
        float daily_rate = Float.parseFloat(request.getParameter("daily_rate"));
        String image_url = request.getParameter("image_url");

        Movie movie = new Movie(title, rate, duration, fine_amount, image_url, daily_rate);

        MovieModel model = new MovieModel();

        model.create(movie);

        response.sendRedirect("/locadora/movies");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
