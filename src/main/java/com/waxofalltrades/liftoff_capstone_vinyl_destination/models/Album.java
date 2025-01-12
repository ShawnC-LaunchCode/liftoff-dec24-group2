package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(max = 120, message = "Album name must be less than 120 characters")
    @NotBlank
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Image albumImage;

    @ManyToOne
    private Artist artist;

    @ManyToOne
    private Genre genre;

    @OneToMany(mappedBy = "album")
    private final List<Item> items = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @Size(max = 120, message = "Album name must be less than 120 characters") String getName() {
        return name;
    }

    public void setName(@Size(max = 120, message = "Album name must be less than 120 characters") String name) {
        this.name = name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    /*
    public List<Item> getItems() {
        return items;
    }
    */
    public Image getAlbumImage() {
        return albumImage;
    }

    public void setAlbumImage(Image albumImage) {
        this.albumImage = albumImage;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
