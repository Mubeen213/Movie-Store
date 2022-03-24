package com.mubeen;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;

    Movie(String name, String format, double rating){
        this.name = name;
        this.format = format;
        this.rating = rating;
        this.rentalPrice = format.equals("Blue-ray")?4.25 : 2.25;
        this.sellingPrice = format.equals("Blue-ray")? 1.99 : 0.99;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setRentalPrice(double rentalPrice, String format) {
        this.rentalPrice = rentalPrice;
    }
}
