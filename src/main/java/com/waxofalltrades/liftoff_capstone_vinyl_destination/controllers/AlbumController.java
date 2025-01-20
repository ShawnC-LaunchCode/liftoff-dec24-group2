package com.waxofalltrades.liftoff_capstone_vinyl_destination.controllers;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Album;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Artist;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Genre;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Item;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.AlbumRepository;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.ArtistRepository;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.GenreRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

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
        model.addAttribute("albums", albumRepository.findAlbumsWithInventory());
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
    @GetMapping("edit/{albumId}")
    public String displayEditAlbumForm(@PathVariable int albumId, Model model){
        Optional<Album> result = albumRepository.findById(albumId);

        if (result.isEmpty()) {
            model.addAttribute("heading", "Invalid Album ID: " + albumId);
        } else {
            Album album = result.get();
            model.addAttribute("heading", "Modify Album: " + album.getName() + " (ID: " + album.getId() + ")");
            model.addAttribute("album", album);
            model.addAttribute("artists", artistRepository.findAll());
            model.addAttribute("genres", genreRepository.findAll());
        }

        return "album/edit";
    }


    // Process edit album form
    @PostMapping("edit")
    public String processEditAlbumForm(@RequestParam Integer albumId,
                                      @RequestParam(value = "name") String albumName,
                                      @RequestParam(value = "artist.Id") int artistId,
                                       @RequestParam(value = "genre.Id") int genreId,
                                      @RequestParam(value = "releaseDate") LocalDate releaseDate){
        Optional<Album> result = albumRepository.findById(albumId);
        Optional<Artist> newArtist = artistRepository.findById(artistId);
        Optional<Genre> newGenre = genreRepository.findById(genreId);

        if (result.isEmpty()) {
            return "redirect:/album/";
        } else {
            Album album = result.get();
            album.setName(albumName);
            if(newArtist.isPresent()) {album.setArtist(newArtist.get());}
            if(newGenre.isPresent()){album.setGenre(newGenre.get());}
            album.setReleaseDate(releaseDate);
            albumRepository.save(album);
        }
        return "redirect:/album/";
    }


    // Delete album
    @PostMapping("delete/{albumId}")
    public String processDeleteAlbum(@PathVariable("albumId") int albumId) {
        albumRepository.deleteById(albumId);
        return "redirect:/album/";
    }

    // Display Inventory
    @GetMapping("inventory/{albumId}")
    public String viewAlbumInventory(@PathVariable("albumId") int albumId, Model model){
        Optional<Album> result = albumRepository.findById(albumId);

        if (result.isEmpty()) {
            model.addAttribute("heading", "Invalid Album ID: " + albumId);
        } else {
            Album album = result.get();
            model.addAttribute("heading", "Inventory For: " + album.getName() + " (ID: " + album.getId() + ")");
            model.addAttribute("album", album);
            model.addAttribute("items", album.getItems());
        }

        return "album/inventory";
    }
}
