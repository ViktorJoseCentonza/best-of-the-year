package org.lessons.java.best_of_the_year.classes;

import java.util.ArrayList;

public class Movie extends Media {

    private static int generalId = 0;
    private final int id;

    static private ArrayList<Movie> existingMovies = new ArrayList<Movie>();

    public Movie(String title) {
        super(title);
        this.id = generalId;
        generalId++;
        existingMovies.add(this);
    }

    public Movie(String title, int likes) {
        super(title, likes);
        this.id = generalId;
        generalId++;
        existingMovies.add(this);
    }

    public int getId() {
        return id;
    }

    public static Movie getMovie(int i) {
        return existingMovies.get(i);
    }

    public static ArrayList<Movie> getBest() {

        ArrayList<Movie> BestMovies = new ArrayList<Movie>();

        for (int i = 0; i < existingMovies.size(); i++) {
            int j = 0;
            if (BestMovies.size() == 0) {
                BestMovies.add(existingMovies.get(i));
                continue;
            }
            do {

                if (existingMovies.get(i).getLikes() > BestMovies.get(j).getLikes()
                        && existingMovies.get(i) != BestMovies.get(j)) {
                    BestMovies.add(j, existingMovies.get(i));
                    if (BestMovies.size() > 10) {
                        BestMovies.remove(BestMovies.size() - 1);
                    }
                    break;
                }
                j++;
            } while (j < BestMovies.size());
            if (j == BestMovies.size() && BestMovies.size() < 10) {
                BestMovies.add(BestMovies.size(), existingMovies.get(i));
            }
        }

        return BestMovies;
    }

    @Override
    public String toString() {
        return super.toString() + " id: " + this.id;
    }

}
