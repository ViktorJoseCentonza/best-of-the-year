package org.lessons.java.best_of_the_year.controller;

import java.util.ArrayList;

import org.lessons.java.best_of_the_year.classes.Movie;
import org.lessons.java.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        model.addAttribute("movies", getBestMovies());
        return "movies";
    }

    private ArrayList<Movie> getBestMovies() {
        return Movie.getBest();
    }

    @GetMapping("/movie/{id}")
    public String movie(@PathVariable int id, Model model) {
        model.addAttribute("movie", returnMovie(id));
        return "movie";
    }

    private Movie returnMovie(int id) {
        return Movie.getMovie(id);
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        model.addAttribute("songs", getBestSongs());
        return "songs";
    }

    private ArrayList<Song> getBestSongs() {
        return Song.getBest();
    }

    @GetMapping("/song/{id}")
    public String song(@PathVariable int id, Model model) {
        model.addAttribute("song", returnSong(id));
        return "song";
    }

    private Song returnSong(int id) {
        return Song.getSong(id);
    }
}
