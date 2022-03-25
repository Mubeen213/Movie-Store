package com.mubeen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

    static Store store = new Store();
    public static void main(String[] args) {
	// write your code here

        try{
            loadMovies("Resources/movies.txt");
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Name: loadMovies
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   • 1. loads movies from <fileName>.txt.
     *   • 2. adds all movies to the store object's movie field.
     */

    public static void loadMovies(String fileName)throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner sc = new Scanner(fis);
        while(sc.hasNextLine()){
            String fullLine = sc.nextLine();
            String[] words = fullLine.split("--");
            store.addMovies(new Movie(words[0], words[1], Double.parseDouble(words[2])));
        }

    }
}
