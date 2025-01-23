package com.waxofalltrades.liftoff_capstone_vinyl_destination.controllers;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Album;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Genre;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.GenreRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping(value = "genre")
public class GenreController {

    @Autowired
    GenreRepository genreRepository;

    @RequestMapping("/")
    public String displayAllGenres(Model model) {
        model.addAttribute("genres", genreRepository.findAllByOrderByNameAsc());
        return "genre/list";
    }

    @GetMapping("add")
    public String displayAddGenreForm(Model model) {
        model.addAttribute(new Genre());

        return "genre/add";
    }

    @PostMapping("add")
    public String processAddGenreForm(@ModelAttribute @Valid Genre newGenre, Errors errors) {
        if (errors.hasErrors()) {
            return "genre/add";
        }

        genreRepository.save(newGenre);

        return "redirect:/genre/";
    }

    @GetMapping("edit/{id}")
    public String displayEditGenreForm(@PathVariable int id, Model model) {
        Optional<Genre> result = genreRepository.findById(id);

        if (result.isEmpty()) {
            model.addAttribute("heading", "No Genre Found for ID: " + id);
        } else {
            Genre genre = result.get();
            model.addAttribute("heading", "Modify Genre: " + genre.getName());
            model.addAttribute("genre", genre);
        }
        return "genre/edit";
    }

    @PostMapping("edit")
    public String processEditGenreForm(@RequestParam Integer genreId,
                                       @RequestParam(value = "name") String genreName) {
        Optional<Genre> result = genreRepository.findById(genreId);
        if (result.isEmpty()) {
            return "redirect:/genre/";
        }

        Genre genre = result.get();
        genre.setName(genreName);
        genreRepository.save(genre);

        return "redirect:/genre/";
    }

}


