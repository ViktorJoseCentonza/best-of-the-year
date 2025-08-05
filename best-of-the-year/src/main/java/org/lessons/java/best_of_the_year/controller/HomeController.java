package org.lessons.java.best_of_the_year.controller;

import org.lessons.java.best_of_the_year.BestOfTheYearApplication;
import org.lessons.java.best_of_the_year.classes.Media;
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
        if (name == null) {
            model.addAttribute("name", "viktor");
        } else {
            model.addAttribute("name", name);
        }

        return "home";
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        model.addAttribute("movies", BestOfTheYearApplication.getMovies());
        return "movies/index";
    }

    @GetMapping("/movie/{id}")
    public String movie(@PathVariable int id, Model model) {
        model.addAttribute("pageId", id);

        for (Media m : BestOfTheYearApplication.mediaList) {
            if (m.getId() == id) {
                model.addAttribute("movie", m);
            }
        }
        // todo implement notfound
        return "movies/show";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        model.addAttribute("songs", BestOfTheYearApplication.getSongs());
        return "songs/index";
    }

    @GetMapping("/song/{id}")
    public String song(@PathVariable int id, Model model) {
        model.addAttribute("pageId", id);
        for (Media m : BestOfTheYearApplication.mediaList) {
            if (m.getId() == id) {
                model.addAttribute("song", m);
            }
        }
        // todo implement notfound
        return "songs/show";
    }
}
