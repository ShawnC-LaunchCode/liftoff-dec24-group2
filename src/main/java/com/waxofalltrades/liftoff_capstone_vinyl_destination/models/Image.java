package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(max = 120, message = "Image URL must be less than 120 characters")
    private String link;

    @OneToOne(mappedBy = "albumImage")
    private Album album;

    public Image(int id, String link) {
        this.id = id;
        this.link = link;
    }

    public Image() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @Size(max = 120, message = "Image URL must be less than 120 characters") String getLink() {
        return link;
    }

    public void setLink(@Size(max = 120, message = "Image URL must be less than 120 characters") String link) {
        this.link = link;
    }
}
