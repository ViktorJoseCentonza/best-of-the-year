package org.lessons.java.best_of_the_year;

import java.util.ArrayList;

import org.lessons.java.best_of_the_year.classes.Media;
import org.lessons.java.best_of_the_year.classes.Movie;
import org.lessons.java.best_of_the_year.classes.Song;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BestOfTheYearApplication {

	public static void main(String[] args) {
		Movie Interstellar = new Movie("Interstellar1");

		Movie Interstellar2 = new Movie("Interstellar2");

		Movie Interstellar3 = new Movie("Interstellar3");

		Movie Interstellar4 = new Movie("Interstellar4", 99);

		ArrayList<Movie> BestMovies = Movie.getBest();

		for (int i = 0; i < BestMovies.size(); i++) {
			System.out
					.println(BestMovies.get(i).getTitle() + " #" + (i + 1) + " total amount of likes ="
							+ BestMovies.get(i).getLikes());
		}

		Song bestSongEver = new Song("bestSongEver1");

		Song bestSongEver2 = new Song("bestSongEver2");

		Song bestSongEver3 = new Song("bestSongEver3");

		Song bestSongEver4 = new Song("bestSongEver4", 99);

		ArrayList<Song> BestSongs = Song.getBest();
		System.out.println("-----------------------------------------------------------------");
		for (int i = 0; i < BestSongs.size(); i++) {
			System.out
					.println(BestSongs.get(i).getTitle() + " #" + (i + 1) + " total amount of likes ="
							+ BestSongs.get(i).getLikes());
		}
		SpringApplication.run(BestOfTheYearApplication.class, args);
	}

}
