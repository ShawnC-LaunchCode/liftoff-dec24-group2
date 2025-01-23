package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Must provide name")
    @Size(max = 120, message = "Artist name must be less than 120 characters")
    private String name;

    @OneToMany(mappedBy = "artist")
    private final List<Album> albums = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Image image;

    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Artist() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @Size(max = 120, message = "Artist name must be less than 120 characters") String getName() {
        return name;
    }

    public void setName(@Size(max = 120, message = "Artist name must be less than 120 characters") String name) {
        this.name = name;
    }
}
