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
            System.out.println(store);
            manageMovies();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Name: manageMovies
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. In an infinite loop, the user can choose to a) purchase b) rent c) return d) exit.
     *   •        case a: ask for the name and sell.
     *   •        case b: ask for the name and rent.
     *   •        case c: ask for the name and return.
     *   • 3. call close() from the Scanner object.
     */

    public static void manageMovies(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\nWould you like to \n\ta) purchase\n\tb) rent \n\tc) return");
            String response = sc.nextLine();
            if(!(response.equals("a")||response.equals("b")||response.equals("c"))){
               sc.close();
               break;
            }
            System.out.println("Enter the movie name: \n");
            String name = sc.nextLine();

            if(store.getMovie(name)==null){
                System.out.println("\n\nThe input you provided is not valid. Please try again\n");
                continue;
            }
            switch (response){
                case "a":
                    if(!(store.getMovie(name).isAvailable())){
                        System.out.println("\n\nThe movie is not available for purchase. Please try again\n");
                         continue;
                    }
                    store.action(name,"Sell");
                    break;
                case "b":
                    store.action(name,"Rent");
                    break;
                case "c":
                    store.action(name, "Return");
                    break;

            }
            System.out.println("\n\nUPDATED MOVIES\n\n" + store);
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
        sc.close();
    }
}
