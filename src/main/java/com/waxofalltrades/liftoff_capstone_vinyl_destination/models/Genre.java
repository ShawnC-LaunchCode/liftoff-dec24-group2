package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message="Name is required")
    @Size(max = 120, message = "Genre name must be less than 120 characters")
    private String name;

    @OneToMany(mappedBy = "genre")
    private final List<Album> albums = new ArrayList<>();

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Genre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @Size(max = 120, message = "Genre name must be less than 120 characters") String getName() {
        return name;
    }

    public void setName(@Size(max = 120, message = "Genre name must be less than 120 characters") String name) {
        this.name = name;
    }
}
