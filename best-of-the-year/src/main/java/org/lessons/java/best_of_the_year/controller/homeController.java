package org.lessons.java.best_of_the_year.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class homeController {

    @GetMapping("/")
    public String home(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }

}
