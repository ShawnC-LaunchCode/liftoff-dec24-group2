package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Cascade;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(max = 120, message = "Album name must be less than 120 characters")
    private String name;

    private Date releaseDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Image albumImage;

    @ManyToOne(cascade = CascadeType.ALL)
    private Artist artist;

    @ManyToOne(cascade = CascadeType.ALL)
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
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
