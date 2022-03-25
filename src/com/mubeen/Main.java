package com.mubeen;

/*
    * Video Store
    * The store sells movies and lets the user rent/return them.
    * The store starts by adding movies to its collections.
    * A movie is described by its name,format,rating.
    * A movie can be in-stock or rented
    * The selling price of a movie is $4.25 for blue-ray format and $2.25 for DVD.
    * The rental price of a movie is $1.99 for blue-ray format and $0.99 for DVD
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        Movie movie = new Movie("XD","DVD",4.5);

        Store store = new Store();

        store.Action("XD","Sell");
        System.out.println(store.getMovie(0));

    }
}
