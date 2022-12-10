package com.example.movies.domain;

import com.google.gson.annotations.SerializedName;

public class Videos {

    @SerializedName("videos")
    private TrailersList trailersList;

    public Videos(TrailersList trailersList) {
        this.trailersList = trailersList;
    }

    public TrailersList getTrailersList() {
        return trailersList;
    }

    @Override
    public String toString() {
        return "Videos{" +
                "trailersList=" + trailersList +
                '}';
    }
}
