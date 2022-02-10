package br.edu.ifpr.MVC.Entities;

/**
 *
 * @author julia
 */
public class Movie {
    private int id;
    private String title;
    private int rate;
    private String duration;
    private float fine_amount;
    private String image_url;
    private Float daily_rate;

    public Movie() {}

    public Movie(String title, int rate, String duration, float fine_amount, String image_url, Float daily_rate) {
        this.title = title;
        this.rate = rate;
        this.duration = duration;
        this.fine_amount = fine_amount;
        this.image_url = image_url;
        this.daily_rate = daily_rate;
    }

    public Float getDaily_rate() {
        return daily_rate;
    }

    public void setDaily_rate(Float daily_rate) {
        this.daily_rate = daily_rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public float getFine_amount() {
        return fine_amount;
    }

    public void setFine_amount(float fine_amount) {
        this.fine_amount = fine_amount;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
