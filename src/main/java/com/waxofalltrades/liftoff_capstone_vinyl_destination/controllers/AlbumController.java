package com.waxofalltrades.liftoff_capstone_vinyl_destination.controllers;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "album")
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

    // Display all albums
    @RequestMapping("/")
    public String displayAlbums(Model model){
        model.addAttribute("albums", albumRepository.findAll());
        return "album/list";
    }

    // Display Create album form

    // Process Create Album form

    // Display Edit album form

    // Process edit album form

    // Delete album


}
