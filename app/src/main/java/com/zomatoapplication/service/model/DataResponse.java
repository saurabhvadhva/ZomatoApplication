package com.zomatoapplication.service.model;

import java.util.ArrayList;
import java.util.List;

public class DataResponse {
    private int resultsFound;
    private int resultsStart;
    private int resultsShown;
    private List<Restaurant> restaurants = new ArrayList<>();

    public int getResultsFound() {
        return resultsFound;
    }

    public void setResultsFound(int resultsFound) {
        this.resultsFound = resultsFound;
    }

    public int getResultsStart() {
        return resultsStart;
    }

    public void setResultsStart(int resultsStart) {
        this.resultsStart = resultsStart;
    }

    public int getResultsShown() {
        return resultsShown;
    }

    public void setResultsShown(int resultsShown) {
        this.resultsShown = resultsShown;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    @Override
    public String toString() {
        return "DataResponse{" +
                "resultsFound=" + resultsFound +
                ", resultsStart=" + resultsStart +
                ", resultsShown=" + resultsShown +
                ", restaurants=" + restaurants +
                '}';
    }
}
