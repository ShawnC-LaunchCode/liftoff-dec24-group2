package com.waxofalltrades.liftoff_capstone_vinyl_destination.controllers;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Album;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Item;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.AlbumRepository;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.ArtistRepository;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.GenreRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "album")
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private GenreRepository genreRepository;

    // Display all albums
    @RequestMapping("/")
    public String displayAlbums(Model model){
        model.addAttribute("albums", albumRepository.findAll());
        return "album/list";
    }

    // Display Create album form

    @GetMapping("add")
    public String displayAddAlbumForm(Model model){
        model.addAttribute(new Album());
        model.addAttribute("artists", artistRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());

        return "album/add";
    }


    // Process Create Album form
    @PostMapping("add")
    public String processAddEventForm(@ModelAttribute @Valid Album newAlbum,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("artists", artistRepository.findAll());
            model.addAttribute("genres", genreRepository.findAll());
            return "album/add";
        }

        albumRepository.save(newAlbum);

        return "redirect:/album/";
    }
    // Display Edit album form

    // Process edit album form

    // Delete album


}
