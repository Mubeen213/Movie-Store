package com.mubeen;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;

    public Movie(String name, String format, double rating){
        if(name==null||name.isBlank()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (!(format.equalsIgnoreCase("DVD") || format.equalsIgnoreCase("Blue-Ray"))) {
            throw new IllegalArgumentException("format must be DVD or Blue-Ray");
        }
        if(rating<0.0&&rating>10.0){
            throw new IllegalArgumentException("Rating cannot be less than 0.0 and greater than 10.0");
        }
        this.name = name;
        this.format = format;
        this.rating = rating;
        this.rentalPrice = format.equalsIgnoreCase("Blue-ray")?4.25 : 2.25;
        this.sellingPrice = format.equalsIgnoreCase("Blue-ray")? 1.99 : 0.99;
        this.isAvailable = true;
    }

    public Movie(Movie movie){
        this.name = movie.name;
        this.format = movie.format;
        this.rating = movie.rating;
        this.rentalPrice = movie.rentalPrice;
        this.sellingPrice = movie.sellingPrice;
        this.isAvailable = movie.isAvailable;
    }
    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public double getRating() {
        return rating;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setName(String name) {
        if(name==null||name.isBlank()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setFormat(String format) {
        if(!format.equalsIgnoreCase("DVD")||!format.equalsIgnoreCase("Blue-ray")){
            throw new IllegalArgumentException("Format cannot be other than DVD or Blue-ray");
        }
        this.format = format;
        setSellingPrice(format.equals("Blue-ray")?4.25 : 2.25);
        setRentalPrice(format.equals("Blue-ray")?1.99:0.99);
    }

    public void setRating(double rating) {
        if(rating<0.0&& rating>10.0){
            throw new IllegalArgumentException("Rating cannot be less than 0 and greater than 10");
        }
        this.rating = rating;
    }

    private void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    private void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String toString(){
        return "Name: " + this.name + ".\n"
                +"Format: " + this.format + ".\n"
                +"Rating: " +this.rating + ".\n"
                +"Selling Price: " + this.sellingPrice + ".\n"
                +"Rental Price: " + this.rentalPrice + ".\n"
                +"Availability: " + this.isAvailable + ".\n";

    }
}
