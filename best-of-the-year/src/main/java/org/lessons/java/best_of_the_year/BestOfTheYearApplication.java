package org.lessons.java.best_of_the_year;

import java.util.ArrayList;

import org.lessons.java.best_of_the_year.classes.Media;
import org.lessons.java.best_of_the_year.classes.Movie;
import org.lessons.java.best_of_the_year.classes.Song;
import org.lessons.java.best_of_the_year.controller.HomeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BestOfTheYearApplication {

	private final HomeController homeController;

	public static ArrayList<Media> mediaList = new ArrayList<>();

	BestOfTheYearApplication(HomeController homeController) {
		this.homeController = homeController;
	}

	public static void main(String[] args) {

		mediaList.add(new Movie("Interstellar1"));

		mediaList.add(new Movie("Interstellar2"));

		mediaList.add(new Movie("Interstellar3"));

		mediaList.add(new Movie("Interstellar4", 99));

		mediaList.add(new Song("BestSongEver1"));

		mediaList.add(new Song("BestSongEver2"));

		mediaList.add(new Song("BestSongEver3"));

		mediaList.add(new Song("BestSongEver4", 99));

		mediaList.sort((a, b) -> b.getLikes() - a.getLikes());

		SpringApplication.run(BestOfTheYearApplication.class, args);
	}

	public static ArrayList<Song> getSongs() {
		ArrayList<Song> songList = new ArrayList<>();
		for (Media m : mediaList) {
			if (m instanceof Song) {
				songList.add((Song) m);
			}
		}
		return songList;
	}

	public static ArrayList<Movie> getMovies() {
		ArrayList<Movie> movieList = new ArrayList<>();
		for (Media m : mediaList) {
			if (m instanceof Movie) {
				movieList.add((Movie) m);
			}
		}
		return movieList;
	}

}
