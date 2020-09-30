package com.example.zomatoproject;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Model {
    @SerializedName("location_suggestions")
    private List<Location> locationList;
    @SerializedName("status")
    private String status;

    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class Location {
    @SerializedName("entity_id")
    private int entity_id;
    @SerializedName("entity_type")
    private String entity_type;

    public int getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(int entity_id) {
        this.entity_id = entity_id;
    }

    public String getEntity_type() {
        return entity_type;
    }

    public void setEntity_type(String entity_type) {
        this.entity_type = entity_type;
    }
}

class ResturantModel {
    @SerializedName("best_rated_restaurant")
    private List<BestRatedResturant> bestRetedRasturant;

    public List<BestRatedResturant> getBestRetedRasturant() {
        return bestRetedRasturant;
    }

    public void setBestRetedRasturant(List<BestRatedResturant> bestRetedRasturant) {
        this.bestRetedRasturant = bestRetedRasturant;
    }
}

class BestRatedResturant {
    @SerializedName("restaurant")
    private Restaurant restaurant;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}

class Restaurant {
    @SerializedName("name")
    private String restaurantName;
    @SerializedName("location")
    private RestaurantLocation restaurantLocation;

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public RestaurantLocation getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(RestaurantLocation restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }
}

class RestaurantLocation {
    @SerializedName("city")
    private String city;
    @SerializedName("locality")
    private String locality;
    @SerializedName("address")
    private String address;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}