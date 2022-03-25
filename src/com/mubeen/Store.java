package com.mubeen;

import java.util.ArrayList;

public class Store {
      ArrayList<Movie> movies;

      Store(){
        this.movies = new ArrayList<Movie>();
      }

      public void setMovie(Movie movie, int index){
          this.movies.add(index,new Movie(movie));
      }

      public Movie getMovie(int index){
          return new Movie(this.movies.get(index));
      }

      public void addMovies(Movie movie){
          this.movies.add(new Movie(movie));
      }

      public void Action(String name, String action){
         if(this.movies.isEmpty()){
             throw  new IllegalStateException("Movie Store is empty");
         }
         if(name==null||name.isBlank()){
             throw new IllegalArgumentException("Name cannot be empty");
         }
         if(!(action.equals("Sell")||action.equals("Rent")||action.equals("Return"))){
             throw new IllegalStateException("Action cannot be other than sell/Rent/Return");
         }

          for (int i = 0; i < this.movies.size(); i++) {
              if(this.movies.get(i).getName().equals(name)){
                  switch (action){
                      case "Sell":
                          if(!(this.movies.get(i).isAvailable())){
                              throw new IllegalStateException("Cannot sell a movie that was rented out");
                          }
                          this.movies.remove(i);
                          break;
                      case "Rent":
                          this.movies.get(i).setAvailable(false);
                      case "Return":
                          this.movies.get(i).setAvailable(true);
                  }
              }
          }
      }

}
