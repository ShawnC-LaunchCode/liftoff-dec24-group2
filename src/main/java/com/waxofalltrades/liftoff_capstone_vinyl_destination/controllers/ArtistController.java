package com.waxofalltrades.liftoff_capstone_vinyl_destination.controllers;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Artist;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.ArtistRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.AttributedString;
import java.util.Optional;

@Controller
@RequestMapping(value = "artist")
public class ArtistController {

    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/")
    public String displayAllArtists(Model model){
        model.addAttribute("artists", artistRepository.findAllByOrderByNameAsc());
        return "artist/list";
    }

    @GetMapping("detail/{artistId}")
    public String displayArtistDetail(@PathVariable int artistId, Model model){
        Optional<Artist> result = artistRepository.findById(artistId);

        if (result.isEmpty()){
            model.addAttribute("heading", "Invalid Artist ID");
        } else {
            Artist artist = result.get();
            model.addAttribute("heading", "Artist Detail: " + artist.getName());
            model.addAttribute("artist", artist);
        }

        return "artist/detail";
    }

    @GetMapping("add")
    public String displayAddArtistForm(Model model){
        model.addAttribute(new Artist());
        return "artist/add";
    }

    @PostMapping("add")
    public String processAddArtistForm(@ModelAttribute @Valid Artist newArtist, Errors errors){
        if (errors.hasErrors()) {
            return "artist/add";
        }
        artistRepository.save(newArtist);

        return "redirect:/artist/";
    }


    @GetMapping("edit/{artistId}")
    public String displayEditArtistForm(@PathVariable int artistId, Model model){
        Optional<Artist> result = artistRepository.findById(artistId);

        if (result.isEmpty()){
            model.addAttribute("heading", "Invalid Artist ID");
        } else {
            Artist artist = result.get();
            model.addAttribute("heading", "Artist Detail: " + artist.getName());
            model.addAttribute("artist", artist);
        }

        return "artist/edit";
    }

    @PostMapping("edit")
    public String processEditArtistForm(@RequestParam Integer artistId,
                                        @RequestParam(value = "name") String artistName,
                                        RedirectAttributes redirectAttributes){
        Optional<Artist> result = artistRepository.findById(artistId);

        if (result.isEmpty()){
            return "redirect:/album/";
        }

        Artist artist = result.get();
        artist.setName(artistName);

        artistRepository.save(artist);

        redirectAttributes.addAttribute("id", artistId);

        return "redirect:/artist/detail/{id}";
    }

    @PostMapping("delete/{id}")
    public String processDeleteArtistForm(@PathVariable("id") int artistId){
        artistRepository.deleteById(artistId);
        return "redirect:/album/";
    }
}
