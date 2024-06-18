package com.example.weatherlistview;

public class WeatherItem {
    private String city;
    private String status;
    private int degree;
    private int image;

    public WeatherItem(String city, int degree, String status, int image) {
        this.city = city;
        this.degree = degree;
        this.status = status;
        this.image = image;
    }

    // getters and setters

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
