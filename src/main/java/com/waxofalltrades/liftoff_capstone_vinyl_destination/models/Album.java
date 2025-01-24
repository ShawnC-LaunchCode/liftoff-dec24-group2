package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 120, message = "Album name must be less than 120 characters")
    @NotBlank
    private String name;

    @Digits(integer = 4, fraction = 0, message = "Year must be 4 digit number")
    private int releaseYear;

    @OneToOne(cascade = CascadeType.ALL)
    private Image albumImage;

    @ManyToOne
    private Artist artist;

    @ManyToOne
    private Genre genre;

    @OneToMany(mappedBy = "album")
    private final List<Item> items = new ArrayList<>();

    public Album(int id, String name, int releaseYear, Image albumImage, Artist artist, Genre genre) {
        this.id = id;
        this.name = name;
        this.releaseYear = releaseYear;
        this.albumImage = albumImage;
        this.artist = artist;
        this.genre = genre;
    }

    public Album() {
    }

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

    @Min(1870)
    @Digits(integer = 4, fraction = 0, message = "Year must be 4 digit number")
    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(@Digits(integer = 4, fraction = 0, message = "Year must be 4 digit number") int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<Item> getItems() {
        return items;
    }

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
