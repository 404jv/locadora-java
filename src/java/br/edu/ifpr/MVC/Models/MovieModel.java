/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.MVC.Models;

import br.edu.ifpr.MVC.DAOs.MoviesDAO;
import br.edu.ifpr.MVC.Entities.Movie;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author julia
 */
public class MovieModel {
    static ArrayList<Movie> movies = new ArrayList<>();

    public ArrayList<Movie> getMovies() {
        return movies;
    }
    
    public void create(Movie movie) {
        MoviesDAO dao = new MoviesDAO();

        try {
            dao.create(movie);
        } catch (SQLException e) {
        }
    }
}
