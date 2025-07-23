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
        model.addAttribute("movies", Movie.getBest());
        return "movies";
    }

    @GetMapping("/movie/{id}")
    public String movie(@PathVariable int id, Model model) {
        model.addAttribute("pageId", id);
        model.addAttribute("movie", Movie.getMovie(id));
        return "movie";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        model.addAttribute("songs", Song.getBest());
        return "songs";
    }

    @GetMapping("/song/{id}")
    public String song(@PathVariable int id, Model model) {
        model.addAttribute("pageId", id);
        model.addAttribute("song", Song.getSong(id));
        return "song";
    }
}
