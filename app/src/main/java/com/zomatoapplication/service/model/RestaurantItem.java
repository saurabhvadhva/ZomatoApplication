package com.zomatoapplication.service.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestaurantItem {

    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    @SerializedName("cuisines")
    private String cuisines;
    @SerializedName("average_cost_for_two")
    private int averageCostForTwo;
    @SerializedName("currency")
    private String currency;
    @SerializedName("featured_image")
    private String featuredImage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCuisines() {
        return cuisines;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    public int getAverageCostForTwo() {
        return averageCostForTwo;
    }

    public void setAverageCostForTwo(int averageCostForTwo) {
        this.averageCostForTwo = averageCostForTwo;
    }

    public String getAverageCostInString(){
        return "Cost for two "+ getCurrency() + " "+ getAverageCostForTwo() +" approx";
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFeaturedImage() {
        return featuredImage;
    }

    public void setFeaturedImage(String featuredImage) {
        this.featuredImage = featuredImage;
    }

    @Override
    public String toString() {
        return "RestaurantItem{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", cuisines='" + cuisines + '\'' +
                ", averageCostForTwo=" + averageCostForTwo +
                ", currency='" + currency + '\'' +
                ", featuredImage='" + featuredImage + '\'' +
                '}';
    }
}