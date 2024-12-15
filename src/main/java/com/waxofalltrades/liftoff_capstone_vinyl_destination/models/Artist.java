package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(max = 120, message = "Artist name must be less than 120 characters")
    private String name;

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
