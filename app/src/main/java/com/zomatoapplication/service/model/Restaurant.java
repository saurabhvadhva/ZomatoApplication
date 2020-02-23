package com.zomatoapplication.service.model;

public class Restaurant {

    private RestaurantItem restaurant;

    public RestaurantItem getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantItem restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurant=" + restaurant +
                '}';
    }
}