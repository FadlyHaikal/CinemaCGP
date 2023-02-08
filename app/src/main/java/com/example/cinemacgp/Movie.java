package com.example.cinemacgp;

public class Movie {
    String id;
    String title;
    String plot;
    String year;
    String image;
    String directors;
    String stars;
    String releaseDate;
    String runtimeMinutes;
    String fullTitle;
    String genres;
    String imDbRating;
    String crew;

    public Movie(String id, String title, String plot, String year, String image, String directors, String stars, String releaseDate, String runtimeMinutes, String fullTitle, String genres, String imDbRating) {
        this.id = id;
        this.title = title;
        this.plot = plot;
        this.year = year;
        this.image = image;
        this.directors = directors;
        this.stars = stars;
        this.releaseDate = releaseDate;
        this.runtimeMinutes = runtimeMinutes;
        this.fullTitle = fullTitle;
        this.genres = genres;
        this.imDbRating = imDbRating;
    }

    public Movie(String id, String fullTitle, String image, String imDbRating, String crew) {
        this.id = id;
        this.image = image;
        this.fullTitle = fullTitle;
        this.imDbRating = imDbRating;
        this.crew = crew;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public void setRuntimeMinutes(String runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getImDbRating() {
        return imDbRating;
    }

    public void setImDbRating(String imDbRating) {
        this.imDbRating = imDbRating;
    }





}
