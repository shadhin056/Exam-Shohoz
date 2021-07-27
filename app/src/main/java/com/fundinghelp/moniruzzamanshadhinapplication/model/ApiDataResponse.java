package com.fundinghelp.moniruzzamanshadhinapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiDataResponse {

    @SerializedName("genres")
    private List<String> genres = null;

    @SerializedName("movies")
    private List<Movie> movies = null;

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

}
