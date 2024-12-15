package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

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

    @OneToMany(mappedBy = "itemId")
    private List<Item> items = new ArrayList<>();

}
