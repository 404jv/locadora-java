/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.MVC.Entities;

/**
 *
 * @author julia
 */
public class Rental {
    private int id;
    private int client_id;
    private int movie_id;
    private String start_date;
    private String end_date;
    private String status;
    private Float total;

    private String client_name;
    private String movie_title;
    private float daily_rate;

    public Rental() {}

    public Rental(int client_id, int movie_id, String start_date, String end_date) {
        this.client_id = client_id;
        this.movie_id = movie_id;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public float getDaily_rate() {
        return daily_rate;
    }

    public void setDaily_rate(float daily_rate) {
        this.daily_rate = daily_rate;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

}
