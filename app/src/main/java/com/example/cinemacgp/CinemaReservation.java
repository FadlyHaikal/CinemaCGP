package com.example.cinemacgp;

public class CinemaReservation {
    String id;
    String cinemaName;
    String movieId;
    String image;
    String title;

    public CinemaReservation(String id, String cinemaName, String movieId, String image, String title) {
        this.id = id;
        this.cinemaName = cinemaName;
        this.movieId = movieId;
        this.image = image;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
